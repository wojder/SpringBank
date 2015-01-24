package pl.training.facade;

import java.math.BigDecimal;

import pl.training.domain.Account;
import pl.training.domain.Client;
import pl.training.service.persistence.AccountRepository;
import pl.training.service.persistence.ClientRepository;
import pl.training.service.persistence.generator.AccountNumberGenerator;

public class BankImpl implements Bank {

    private final AccountNumberGenerator accountNumberGenerator;
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public BankImpl(AccountNumberGenerator accountNumberGenerator, AccountRepository accountRepository, ClientRepository clientRepository) {
        this.accountNumberGenerator = accountNumberGenerator;
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Account createAccountForClient(Client client) {
        String newAccountNumber = accountNumberGenerator.getNext();
        Account account = new Account(newAccountNumber);
        account.getClients().add(client);
        client.getAccounts().add(account);
        accountRepository.save(account);
        return account;
    }

    @Override
    public void payInCashToAccount(String accountNumber, BigDecimal amount) {
        Account account = accountRepository.read(accountNumber);
        account.payIn(amount);
        accountRepository.update(account);
    }

    @Override
    public void payOutCashFromAccount(String accountNumber, BigDecimal amount) {
        Account account = accountRepository.read(accountNumber);
        account.payOut(amount);
        accountRepository.update(account);
    }

    @Override
    public void transferCash(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        payOutCashFromAccount(fromAccountNumber, amount);
        payInCashToAccount(toAccountNumber, amount);
    }

}

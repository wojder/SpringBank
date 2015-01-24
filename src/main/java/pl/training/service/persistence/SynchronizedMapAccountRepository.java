package pl.training.service.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.training.domain.Account;

public class SynchronizedMapAccountRepository implements AccountRepository {

    private final Map<String, Account> accounts = new HashMap<>();

    private void throwExceptionIfAccountAlreadyExists(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            throw new AccountAlreadyExistsException();
        }
    }

    private void throwExceptionIfAccountDoesNotExist(String accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            throw new AccountDoesNotExistException();
        }
    }

    @Override
    public void save(Account account) {
        String accountNumber = account.getNumber();
        throwExceptionIfAccountAlreadyExists(accountNumber);
        accounts.put(accountNumber, account);
    }

    @Override
    public Account read(String accountNumber) {
        throwExceptionIfAccountDoesNotExist(accountNumber);
        return accounts.get(accountNumber);
    }

    @Override
    public List<Account> read(int startIndex, int pageSize) {
        int accountsNumber = accounts.size();
        int endIndex = startIndex + pageSize < accountsNumber ? startIndex + pageSize : accountsNumber;
        return new ArrayList<>(accounts.values()).subList(startIndex, endIndex);
    }

    @Override
    public void update(Account account) {
        String accountNumber = account.getNumber();
        throwExceptionIfAccountDoesNotExist(accountNumber);
        accounts.put(accountNumber, account);
    }

}

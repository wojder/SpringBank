package pl.training.facade;

import java.math.BigDecimal;

import pl.training.domain.Account;
import pl.training.domain.Client;

public interface Bank {
	
	Client addClient(Client client) throws BankOperationException;
	
	Account createAccountForClient(Client client) throws BankOperationException;
	
	void payInCashToAccount(String accountNumber, BigDecimal amount) throws BankOperationException;
	
	void payOutCashFromAccount(String accountNumber, BigDecimal amount) throws BankOperationException;

	void transferCash(String fromAccountNumber, String toAccountNumber, BigDecimal amount) throws BankOperationException;
	
}
package pl.training.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {

    private static final long serialVersionUID = -6779387392995352860L;

    private String number;
    private BigDecimal balance = BigDecimal.ZERO;
    private List<Client> clients = new ArrayList<>();

    public Account() {
    }

    public Account(String number) {
        this.number = number;
    }

    public void payIn(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void payOut(BigDecimal amount) throws InsufficientFundsException {
        throwExceptionIfAmountIsGreaterThanBalance(amount);
        balance = balance.subtract(amount);
    }

    private void throwExceptionIfAmountIsGreaterThanBalance(BigDecimal amount) throws InsufficientFundsException {
        if (amount.compareTo(balance) > 0) {
            throw new InsufficientFundsException();
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((balance == null) ? 0 : balance.hashCode());
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Account other = (Account) obj;
        if (balance == null) {
            if (other.balance != null) {
                return false;
            }
        } else if (!balance.equals(other.balance)) {
            return false;
        }
        if (number == null) {
            if (other.number != null) {
                return false;
            }
        } else if (!number.equals(other.number)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account [number=" + number + ", balance=" + balance + "]";
    }

}

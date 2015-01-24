package pl.training.service.persistence.generator;

public class SynchronizedAccountNumberGenerator implements AccountNumberGenerator {

    private static final String ACCOUNT_NUMBER_FORMAT = "%026d";

    private long lastAccountNumber;

    @Override
    public synchronized String getNext() {
        return String.format(ACCOUNT_NUMBER_FORMAT, ++lastAccountNumber);
    }

}

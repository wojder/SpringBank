package pl.training.service.persistence;

import java.util.List;

import pl.training.domain.Account;

public interface AccountRepository {

    void save(Account account);

    Account read(String accountNumber);

    List<Account> read(int startIndex, int pageSize);

    void update(Account account);

}

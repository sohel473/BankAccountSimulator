import java.util.Collection;

public interface AccountRepository {

    void save(Account account);
    Account findByAccountNumber(String accountNumber);
    Collection<Account> findAll();
}

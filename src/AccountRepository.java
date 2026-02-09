public interface AccountRepository {

    void save(Account account);
    Account findByAccountNumber(String accountNumber);
}

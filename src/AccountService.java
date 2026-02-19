import java.util.List;

public class AccountService {

    private final AccountRepository accountRepository;

    // Constructor dependency injection
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(String accountNumber, double initialBalance) {
        Account account = new Account(accountNumber, initialBalance);
        accountRepository.save(account);
    }

    private Account getAccount(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null)
            throw new IllegalArgumentException("Account not found");
        return account;
    }

    public void deposit(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        account.withdraw(amount);
    }

    public double checkBalance(String accountNumber) {
        return getAccount(accountNumber).getBalance();
    }

    public List<Transaction> getLastTransactions(String accountNumber, int n) {
        Account account = getAccount(accountNumber);
        List<Transaction> tx = account.getTransactions();
        return tx.subList(Math.max(tx.size() - n, 0), tx.size());
    }

    public double getTotalBankBalance() {
        return accountRepository.findAll()
                .stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }



}

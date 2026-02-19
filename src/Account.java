import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {

    private final String accountNumber;
    private double balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        validateAmount(amount);
        balance += amount;
        transactions.add(new Transaction(accountNumber, amount, "DEPOSIT"));
    }

    public void withdraw(double amount) {
        validateAmount(amount);
        if (amount > balance)
            throw new InsufficientFundsException(balance, amount);
        balance -= amount;
        transactions.add(new Transaction(accountNumber, -amount, "WITHDRAW"));
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    private void validateAmount(double amount) {
        if (amount <= 0)
            throw new InvalidTransactionException("Amount must be positive");
    }


    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

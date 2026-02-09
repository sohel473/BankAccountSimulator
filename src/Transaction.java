import java.time.LocalDateTime;

public class Transaction {

    private final String accountNumber;
    private final double amount;
    private final LocalDateTime timestamp;
    private final String type;

    public Transaction(String accountNumber, double amount, String type) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }


}

public class InsufficientFundsException  extends RuntimeException {
    public InsufficientFundsException(double balance, double attempted) {
        super("Insufficient funds. Balance: " + balance + ", Attempted: " + attempted);
    }

}

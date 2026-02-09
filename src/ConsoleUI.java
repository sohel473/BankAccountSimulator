import java.util.Scanner;

public class ConsoleUI {

    private final AccountService accountService;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(AccountService accountService) {
        this.accountService = accountService;
    }

    public void start() {
        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1 -> createAccount();
                    case 2 -> deposit();
                    case 3 -> withdraw();
                    case 4 -> checkBalance();
                    case 0 -> System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void createAccount() {
        System.out.print("Account number: ");
        String acc = scanner.next();
        System.out.print("Initial balance: ");
        double bal = scanner.nextDouble();
        accountService.createAccount(acc, bal);
        System.out.println("Account created successfully");
    }

    private void deposit() {
        System.out.print("Account number: ");
        String acc = scanner.next();
        System.out.print("Amount: ");
        double amt = scanner.nextDouble();
        accountService.deposit(acc, amt);
        System.out.println("Deposit successful");
        System.out.println("Account number: " + acc + ", New balance: " + accountService.checkBalance(acc));
    }

    private void withdraw() {
        System.out.print("Account number: ");
        String acc = scanner.next();
        System.out.print("Amount: ");
        double amt = scanner.nextDouble();
        accountService.withdraw(acc, amt);
        System.out.println("Withdrawal successful");
        System.out.println("Account number: " + acc + ", New balance: " + accountService.checkBalance(acc));
    }

    private void checkBalance() {
        System.out.print("Account number: ");
        String acc = scanner.next();
        double balance = accountService.checkBalance(acc);
        System.out.println("Balance: " + balance);
    }
}

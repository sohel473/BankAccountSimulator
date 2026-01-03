import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int accountId = 0;
    static String accountHolder = "";
    static double balance = 0.0;
    static boolean accountCreated = false;

    static void printMenu() {
        System.out.println("\n=== BANK ACCOUNT SIMULATOR ===");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. Exit");
    }

    static int readInt(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Try again: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    static double readDouble(String message) {
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Try again: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    static void createAccount() {
        if (accountCreated) {
            System.out.println("Account already exists.");
            return;
        }

        accountId = readInt("Enter Account ID: ");
        scanner.nextLine(); // consume newline
        System.out.print("Enter Account Holder Name: ");
        accountHolder = scanner.nextLine(); // read string input

        if (accountId <= 0 || accountHolder.isBlank()) {
            System.out.println("Invalid account details.");
            return;
        }

        balance = 0.0;
        accountCreated = true;
        System.out.println("Account created successfully.");
    }


    static void deposit() {
        if (!accountCreated) {
            System.out.println("Please create an account first.");
            return;
        }

        double amount = readDouble("Enter deposit amount: ");

        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }

        balance += amount;
        System.out.println("Deposit successful.");
    }


    static void withdraw() {
        if (!accountCreated) {
            System.out.println("Please create an account first.");
            return;
        }

        double amount = readDouble("Enter withdrawal amount: ");

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawal successful.");
    }

    // Todo: Implement checkBalance method
    // Todo: Implement exit method



    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> System.out.println("Check Balance functionality is not implemented yet.");
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
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



    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> System.out.println("Deposit functionality is not implemented yet.");
                case 3 -> System.out.println("Withdraw functionality is not implemented yet.");
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
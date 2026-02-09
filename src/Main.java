
public class Main {

    public static void main(String[] args) {
        AccountRepository accountRepository = new InMemoryAccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        ConsoleUI consoleUI = new ConsoleUI(accountService);
        consoleUI.start();
        }
    }
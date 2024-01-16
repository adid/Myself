package Finance;

import Login.User;
import Login.UserInfoPrint;
import MainMenu.MainMenu;
import MainMenu.ClearConsole;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FinancialManagement {
    private TransactionsManager transactionsManager;
    private double balance;
    private Scanner scanner;
    private User user;

    public FinancialManagement(User user) {
        this.user = user;
        this.transactionsManager = new TransactionsManager(user);
        this.balance = transactionsManager.getBalance();
        this.scanner = new Scanner(System.in);
    }

    public void addIncome(Transaction transaction) throws IOException {
        transaction.setTransactionType("Income");
        transactionsManager.addTransaction(transaction);
        balance+=transaction.getAmount();
        transactionsManager.saveBalanceToFile(balance);
    }

    public void addExpense(Transaction transaction) throws IOException {
        transaction.setTransactionType("Expense");
        if(balance<transaction.getAmount()) {
            System.out.println("Transaction not Possible!");
            return;
        }
        transactionsManager.addTransaction(transaction);
        balance -= transaction.getAmount();
        transactionsManager.saveBalanceToFile(balance);
    }

    public void viewTransactions() {
        String path = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Transactions\\Transaction_no.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        boolean running = true;
        double amount;
        Transaction newTransaction;
        String description;

        while (running) {
            System.out.println("Manage your finance with Myself");
            System.out.println("1. View Balance");
            System.out.println("2. View Transactions");
            System.out.println("3. Add Income");
            System.out.println("30. Automatically Add Monthly Income");
            System.out.println("4. Add Expense");
            System.out.println("5. View Loan Balance");
            System.out.println("6. Manage Loans");
            System.out.println("-------------------------------");
            System.out.println("9. Back to Main Menu");
            System.out.println("10. Quit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline character
                switch (choice) {
                    case 1:
                        System.out.print("Current Balance: " + balance + "\n");
                        break;
                    case 2:
                        viewTransactions();
                        break;
                    case 3:
                        System.out.print("Enter transaction description: ");
                        description = scanner.nextLine();
                        System.out.print("Enter transaction amount: ");
                        amount = scanner.nextDouble();

                        scanner.nextLine(); // consume the newline character
                        newTransaction = new Transaction(description, amount, "Income");

                        addIncome(newTransaction);
                        break;
                    case 30:
                        UserInfoPrint userInfoPrint = new UserInfoPrint(user);
                        userInfoPrint.loadUserInfo();
                        description = userInfoPrint.getUserInfo().get(11);
                        amount = Double.parseDouble(description);
                        newTransaction = new Transaction("Monthly Income", amount, "Income");
                        addIncome(newTransaction);
                        break;
                    case 4:
                        System.out.print("Enter transaction description: ");
                        description = scanner.nextLine();
                        System.out.print("Enter transaction amount: ");
                        amount = scanner.nextDouble();

                        scanner.nextLine(); // consume the newline character
                        newTransaction = new Transaction(description, amount, "Expense");

                        addExpense(newTransaction);
                        break;
                    case 5:
                        System.out.print("Loan Balance: " + transactionsManager.getLoanBalance() + "\n");
                        break;
                    case 6:
                        LoanManagement loanManagement = new LoanManagement(user);
                        loanManagement.run();
                        break;
                    case 9:
                        MainMenu mainMenu = new MainMenu(user);
                        mainMenu.run();
                        break;
                    case 10:
                        System.out.println("Exiting Myself App...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid information.");
                scanner.nextLine(); // consume the invalid input
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Finance Manager closed.");
    }
}

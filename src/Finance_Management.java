import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Finance_Management
{
    private ArrayList<Transaction> transactions;
    private double balance;
    private Scanner scanner;

    public Finance_Management()
    {
        transactions = new ArrayList<>();
        balance = 0.0;
        scanner = new Scanner(System.in);
    }

    public double addTransaction(String description, double amount)
    {
        Transaction transaction = new Transaction(description, amount);
        transactions.add(transaction);
        balance += amount;
        System.out.println("Transaction added: " + transaction);
        return balance;
    }
    public double getTransactionCount() {
            return transactions.size();
    }
    public void viewTransactions()
    {
        if (transactions.isEmpty())
        {
            System.out.println("No transactions found.");
        }

        else
        {
            System.out.println("Transactions:");
            for (Transaction transaction : transactions) {
                            System.out.println("Description: " + transaction.getDescription());
                            System.out.println("Amount: " + transaction.getAmount());
                            System.out.println();
            }
        }

        System.out.println("Current balance: " + balance);
    }

     public void run()
        {
            boolean running = true;
            while (running)
            {
                System.out.println("Manage your finance with Myself");
                System.out.println("1. Add Transaction");
                System.out.println("2. View Transactions");
                System.out.println("3. Quit");
                System.out.print("Enter your choice: ");

                try {
                    int choice = scanner.nextInt(); //gets int value
                    scanner.nextLine(); // consume the newline character
                    switch (choice)
                    {
                        case 1:
                            System.out.print("Enter transaction description: ");
                            String description = scanner.nextLine();
                            System.out.print("Enter transaction amount: $");
                            double amount = scanner.nextDouble();
                            scanner.nextLine(); // consume the newline character
                            addTransaction(description, amount);
                            break;
                        case 2:
                            viewTransactions();
                            break;
                        case 3:
                            running = false;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
                catch (InputMismatchException e)
                {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.nextLine(); // consume the invalid input
                }
            }
            System.out.println("Finance Manager closed.");
        }

    public static void main(String[] args)
    {
        Finance_Management financeManager = new Finance_Management();
        financeManager.run();
        financeManager.scanner.close();
    }
}
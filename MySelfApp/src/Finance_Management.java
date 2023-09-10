import java.util.ArrayList;
import java.util.Scanner;
class Transaction
{
    private String description;
    private double amount;

    public Transaction(String description, double amount)
    {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription()
    {
        return description;
    }

    public double getAmount()
    {
        return amount;
    }

    @Override
    public String toString()
    {
        return description + ": $" + amount;
    }
}

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

    public void addTransaction(String description, double amount)
    {
        Transaction transaction = new Transaction(description, amount);
        transactions.add(transaction);
        balance += amount;
        System.out.println("Transaction added: " + transaction);
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
            for (Transaction transaction : transactions)
            {
                System.out.println(transaction);
            }
        }

        System.out.println("Current balance: " + balance);
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("Manage you finance wi");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt(); //gets int value
            scanner.nextLine();  // newline

            switch (choice) {
                case 1:
                    System.out.print("Enter transaction description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter transaction amount: $");
                    double amount = scanner.nextDouble();
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
        System.out.println("Finance Manager closed.");
    }

    public static void main(String[] args) {
        Finance_Management financeManager = new Finance_Management();
        financeManager.run();
    }
}
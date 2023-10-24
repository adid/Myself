import Login.LoginSystem;
import Login.User;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Finance_Management {
    private Transaction transaction;
    private ArrayList<Transaction> transactions;
    private double balance;
    private Scanner scanner;
    private User user;
    List<String> lines;

    public Finance_Management(User user) {
        this.user= user;
        transaction=new Transaction("a",12,"b");
        transactions = new ArrayList<>();
        balance = 0.0;
        scanner = new Scanner(System.in);
        lines = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) throws IOException {
        transactions.add(transaction);
        balance += transaction.getAmount();
        System.out.println("Transaction added: " + transaction.getAmount() + " x " + transaction.getDateTime() + " x " + transaction.getDescription());
        addTransactionToFile(transaction);
    }

    public void addTransactionToFile(Transaction transaction) throws IOException {
        String path = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Transactions\\Transaction_no.txt";

        FileWriter myWriter = new FileWriter(path,true);
        String transactionWrite= "Transaction Type: "+ transaction.getTransactionType()+ "  Date: "+ transaction.getDateTime()+
                "   Amount: "+transaction.getAmount()+" Description: "+ transaction.getDescription()+ "\n";
        myWriter.append(transactionWrite);
        myWriter.close();
    }

    public double getTransactionCount() {
        return transactions.size();
    }

    public User getUser(){
        return user;
    }

    public void viewTransactions() {
        String path = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Transactions\\Transaction_no.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while (br.readLine() != null) {
                line = br.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("Manage your finance with Myself");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt(); //gets int value
                scanner.nextLine(); // consume the newline character
                switch (choice) {
                    case 1:
                        System.out.print("Enter transaction description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter transaction amount: ");
                        double amount = scanner.nextDouble();
                        System.out.print("Enter transaction type: ");
                        String transactionType = scanner.nextLine();

                        scanner.nextLine(); // consume the newline character
                        Transaction newTransaction = new Transaction(description, amount, transactionType);
                        addTransaction(newTransaction);
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
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid information.");
                scanner.nextLine(); // consume the invalid input
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Finance Manager closed.");
    }
}
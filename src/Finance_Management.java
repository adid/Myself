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
    private double loanBalance;
    private Scanner scanner;
    private User user;
    List<String> lines;

    public Finance_Management(User user) {
        this.user= user;
        transaction=new Transaction("a",12,"b");
        transactions = new ArrayList<>();
        balance = setBalance();
        loanBalance= setLoanBalance();
        scanner = new Scanner(System.in);
        lines = new ArrayList<>();
    }

    public double setBalance()
    {
        String fileName = "C:\\SPL\\Data\\" + user.getUsername() + "\\Current_Balance.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            reader.close();

            balance= Double.parseDouble(line);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return balance;
    }

    public double setLoanBalance()
    {
        String fileName = "C:\\SPL\\Data\\" + user.getUsername() + "\\Loan_Balance.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            reader.close();

            loanBalance= Double.parseDouble(line);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return loanBalance;
    }
    public void addTransaction(Transaction transaction) throws IOException {
        transactions.add(transaction);
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

    public void saveBalanceToFile(Double balance) throws IOException {
        String path = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Current_Balance.txt";
        File balanceFile= new File(path);

        FileWriter myWriter = new FileWriter(balanceFile);
        myWriter.write(Double.toString(balance));
        myWriter.close();
    }
    public void saveLoanBalanceToFile(Double balance) throws IOException {
        String path = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Loan_Balance.txt";
        File balanceFile= new File(path);

        FileWriter myWriter = new FileWriter(balanceFile);
        myWriter.write(Double.toString(balance));
        myWriter.close();
    }

    public double addMoney(Transaction transaction) throws IOException {
        transaction.setTransactionType("Income");
        addTransaction(transaction);
        balance+=transaction.getAmount();
        saveBalanceToFile(balance);
        return balance;
    }

    public double deductMoney(Transaction transaction) throws IOException {
        transaction.setTransactionType("Expense");
        if(balance<transaction.getAmount()) {
            System.out.println("Transaction not Possible!");
        }
        addTransaction(transaction);
        balance -= transaction.getAmount();
        saveBalanceToFile(balance);
        return balance;
    }

    public double getLoan(Transaction transaction) throws IOException {
        transaction.setTransactionType("Borrow");
        addTransaction(transaction);
        loanBalance+=transaction.getAmount();
        balance+=transaction.getAmount();
        saveBalanceToFile(balance);
        saveLoanBalanceToFile(loanBalance);
        return loanBalance;
    }

    public double giveLoan(Transaction transaction) throws IOException {
        transaction.setTransactionType("Expense");
        if(balance<transaction.getAmount()) {
            System.out.println("Transaction not Possible!");
        }
        addTransaction(transaction);
        loanBalance-=transaction.getAmount();
        balance -= transaction.getAmount();
        saveBalanceToFile(balance);
        saveLoanBalanceToFile(loanBalance);
        return balance;
    }

    public double getBalance(){
        return balance;
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
            System.out.println("0. View Balance");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Add Income");
            System.out.println("4. Add Expense");
            System.out.println("5. Take Loan");
            System.out.println("6. Give Loan");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt(); //gets int value
                scanner.nextLine(); // consume the newline character
                switch (choice) {
                    case 0:
                        System.out.print(getBalance() + "\n");
                        break;
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
                        System.out.print("Enter transaction description: ");
                        description = scanner.nextLine();
                        System.out.print("Enter transaction amount: ");
                        amount = scanner.nextDouble();
                        System.out.print("Enter transaction type: ");
                        transactionType = scanner.nextLine();

                        scanner.nextLine(); // consume the newline character
                        newTransaction = new Transaction(description, amount, transactionType);
                        addMoney(newTransaction);
                        break;
                    case 4:
                        System.out.print("Enter transaction description: ");
                        description = scanner.nextLine();
                        System.out.print("Enter transaction amount: ");
                        amount = scanner.nextDouble();
                        System.out.print("Enter transaction type: ");
                        transactionType = scanner.nextLine();

                        scanner.nextLine(); // consume the newline character
                        newTransaction = new Transaction(description, amount, transactionType);
                        deductMoney(newTransaction);
                        break;
                    case 5:
                        System.out.print("Enter transaction description: ");
                        description = scanner.nextLine();
                        System.out.print("Enter transaction amount: ");
                        amount = scanner.nextDouble();
                        System.out.print("Enter transaction type: ");
                        transactionType = scanner.nextLine();

                        scanner.nextLine(); // consume the newline character
                        newTransaction = new Transaction(description, amount, transactionType);
                        getLoan(newTransaction);
                        break;
                    case 6:
                        System.out.print("Enter transaction description: ");
                        description = scanner.nextLine();
                        System.out.print("Enter transaction amount: ");
                        amount = scanner.nextDouble();
                        System.out.print("Enter transaction type: ");
                        transactionType = scanner.nextLine();

                        scanner.nextLine(); // consume the newline character
                        newTransaction = new Transaction(description, amount, transactionType);
                        giveLoan(newTransaction);
                        break;
                    case 7:
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
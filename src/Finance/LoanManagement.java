package Finance;

import Login.User;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoanManagement {
    private TransactionsManager transactionsManager;
    private Scanner scanner;
    private double balance;
    private double loanBalance;
    private User user;
    private ArrayList<String> borrowArray = new ArrayList<>();
    private ArrayList<String> lendArray = new ArrayList<>();

    public LoanManagement(User user) {
        this.user = user;
        this.transactionsManager = new TransactionsManager(user);
        this.scanner = new Scanner(System.in);
        this.balance = transactionsManager.setBalance();
        this.loanBalance = transactionsManager.setLoanBalance();
    }

    void addTransactionToArray(Transaction transaction,ArrayList<String> array)
    {
        LocalDateTime transactionDateTime = transaction.getDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = transactionDateTime.format(formatter);

        String transactionWrite= "Date: "+ formattedDateTime+ "; Amount: "+transaction.getAmount()+
                "; Description: "+ transaction.getDescription();

        array.add(transactionWrite);
    }

    void returnBorrowedMoney() throws IOException {
        for(int i=0;i<borrowArray.size();i++)
        {
            System.out.println(i + ". " + borrowArray.get(i));
        }

        System.out.println("Select index of Borrow list to return: ");
        int select = scanner.nextInt();

        if (select < 0 || select >= borrowArray.size()) {
            System.out.println("Invalid index selected. Please try again.");
            return;
        }

        System.out.println("Amount to return: ");
        double amount = scanner.nextDouble();

        Pattern amountPattern = Pattern.compile("Amount: (\\d+\\.\\d+)");
        Matcher matcher = amountPattern.matcher(borrowArray.get(select));
        double extractAmount;

        if (!matcher.find()) {
            System.out.println("Error!");
            run();
            return;
        }

        String amountString = matcher.group(1);
        extractAmount = Double.parseDouble(amountString);

        if(extractAmount<amount)
        {
            borrowArray.clear();
            lendArray.clear();
            System.out.println("Error! You can not return more amount than borrowed");
            run();
            return;
        }

        else if(extractAmount==amount)
        {
            borrowArray.remove(select);
        }

        else
        {
            borrowArray.set(select,borrowArray.get(select).replace(amountString, String.valueOf(extractAmount-amount)));
        }

        scanner.nextLine();

        loanBalance-= amount;
        balance-= amount;

        transactionsManager.saveBalanceToFile(balance);
        transactionsManager.saveLoanBalanceToFile(loanBalance);

        LoanFileHandler.writeToFile(user,borrowArray,"Borrow");
    }

    void takeBackLentMoney() throws IOException {
        for(int i=0;i<lendArray.size();i++)
        {
            System.out.println(i + ". " + lendArray.get(i));
        }

        System.out.println("Select index of Lend list which you got: ");
        int select = scanner.nextInt();

        if (select < 0 || select >= lendArray.size()) {
            System.out.println("Invalid index selected. Please try again.");
            return;
        }

        System.out.println("Amount to take: ");
        double amount = scanner.nextDouble();

        Pattern amountPattern = Pattern.compile("Amount: (\\d+\\.\\d+)");
        Matcher matcher = amountPattern.matcher(lendArray.get(select));
        double extractAmount;

        if (!matcher.find()) {
            System.out.println("Error!");
            run();
            return;
        }

        String amountString = matcher.group(1);
        extractAmount = Double.parseDouble(amountString);

        if(extractAmount<amount)
        {
            lendArray.clear();
            borrowArray.clear();
            System.out.println("Error! You can not get more amount than lent");
            run();
            return;
        }

        else if(extractAmount==amount)
        {
            lendArray.remove(select);
        }

        else
        {
            lendArray.set(select,lendArray.get(select).replace(amountString, String.valueOf(extractAmount-amount)));
        }

        scanner.nextLine();

        loanBalance+= amount;
        balance+= amount;

        transactionsManager.saveBalanceToFile(balance);
        transactionsManager.saveLoanBalanceToFile(loanBalance);

        LoanFileHandler.writeToFile(user,lendArray,"Lend");
    }

    void borrowMoney(Transaction transaction) throws IOException {
        transaction.setTransactionType("Borrow");
        transactionsManager.addTransaction(transaction);
        balance+=transaction.getAmount();
        loanBalance+=transaction.getAmount();
        transactionsManager.saveBalanceToFile(balance);
        transactionsManager.saveLoanBalanceToFile(loanBalance);

        addTransactionToArray(transaction,borrowArray);
        LoanFileHandler.writeToFile(user,borrowArray,"Borrow");
    }

    void lendMoney(Transaction transaction) throws IOException {
        transaction.setTransactionType("Lend");
        if(balance<transaction.getAmount()) {
            System.out.println("Finance.Transaction not Possible!");
        }
        transactionsManager.addTransaction(transaction);
        loanBalance-=transaction.getAmount();
        balance -= transaction.getAmount();
        transactionsManager.saveBalanceToFile(balance);
        transactionsManager.saveLoanBalanceToFile(loanBalance);

        addTransactionToArray(transaction,lendArray);
        LoanFileHandler.writeToFile(user,lendArray,"Lend");
    }

    void viewLoanTransactions()
    {
        System.out.println("Borrowed");

        for(String element : borrowArray)
        {
            System.out.println(element);
        }

        System.out.println("Lent");

        for(String element : lendArray)
        {
            System.out.println(element);
        }
    }

    public void run() throws IOException {
        LoanFileHandler.loadFileToArray(user,borrowArray,"Borrow");
        LoanFileHandler.loadFileToArray(user,lendArray,"Lend");
        String description;
        double amount;
        Transaction transaction;

        boolean running = true;
        while (running) {
            System.out.println("Manage Loans");
            System.out.println("1. Borrow Money");
            System.out.println("2. Return Borrowed Money");
            System.out.println("3. Lend Money");
            System.out.println("4. Take back Lent Money");
            System.out.println("5. View Loan Balance");
            System.out.println("6. View Loan Transactions");
            System.out.println("-------------------------------");
            System.out.println("9. Back to Finance Menu");
            System.out.println("10. Quit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline character
                switch (choice) {
                    case 1:
                        System.out.print("Enter transaction description: ");

                        description = scanner.nextLine();
                        System.out.print("Enter transaction amount: ");

                        amount = scanner.nextDouble();

                        scanner.nextLine(); // consume the newline character

                        transaction = new Transaction(description,amount,"Borrow");
                        borrowMoney(transaction);
                        break;
                    case 2:
                        returnBorrowedMoney();
                        break;
                    case 3:
                        System.out.print("Enter transaction description: ");
                         description = scanner.nextLine();
                        System.out.print("Enter transaction amount: ");
                         amount = scanner.nextDouble();

                        scanner.nextLine(); // consume the newline character

                        transaction = new Transaction(description,amount,"Lend");
                        lendMoney(transaction);
                        break;
                    case 4:
                        takeBackLentMoney();
                        break;
                    case 5:
                        System.out.print(loanBalance + "\n");
                        break;
                    case 6:
                        viewLoanTransactions();
                        break;
                    case 9:
                        FinancialManagement financialManagement = new FinancialManagement(user);
                        financialManagement.run();
                        return;
                    case 10:
                        System.out.println("Exiting Myself App...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid information.");
                scanner.nextLine(); // consume the invalid input
            }
        }
        System.out.println("Loan Management closed.");
    }

    public TransactionsManager getTransactionsManager() {
        return transactionsManager;
    }
}


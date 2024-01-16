package Finance;

import Login.User;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransactionsManager {
    private ArrayList<Transaction> transactions;
    private double balance;
    private double loanBalance;
    private User user;

    public TransactionsManager(User user) {
        this.user = user;
        this.transactions = new ArrayList<>();
        this.balance = setBalance();
        this.loanBalance = setLoanBalance();
    }

    public double getBalance() {
        return balance;
    }

    public double getLoanBalance() {
        return loanBalance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) throws IOException {
        transactions.add(transaction);

        LocalDateTime transactionDateTime = transaction.getDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = transactionDateTime.format(formatter);

        System.out.println(transaction.getTransactionType() +" added: \nAmount:" + transaction.getAmount() + "; Date and Time: " + formattedDateTime + "; Description: " + transaction.getDescription());
        addTransactionToFile(transaction);
    }

    public void addTransactionToFile(Transaction transaction) throws IOException {
        String path = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Transactions\\Transaction_no.txt";

        LocalDateTime transactionDateTime = transaction.getDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = transactionDateTime.format(formatter);

        FileWriter myWriter = new FileWriter(path,true);
        String transactionWrite= "Transaction Type: "+ transaction.getTransactionType()+ "; Date: "+ formattedDateTime+
                "; Amount: "+transaction.getAmount()+"; Description: "+ transaction.getDescription()+ "\n";
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

    public void saveLoanBalanceToFile(Double loanBalance) throws IOException {
        String path = "C:\\SPL\\Data\\"+ user.getUsername()+"\\Loan_Balance.txt";
        File balanceFile= new File(path);

        FileWriter myWriter = new FileWriter(balanceFile);
        myWriter.write(Double.toString(loanBalance));
        myWriter.close();
    }

    double setBalance() {
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

    double setLoanBalance() {
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
}

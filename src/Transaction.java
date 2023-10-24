import java.time.LocalDateTime;
import java.util.Date;

class Transaction
{
    private String description;
    private double amount;
    private LocalDateTime dateTime;
    private int transaction_no;
    private String transactionType;

    public Transaction(String description, double amount, int transaction_no, String transactionType)
    {
        this.description = description;
        if (amount < 0)
        {
            throw new IllegalArgumentException("Transaction amount must be non-negative.");
        }
        this.amount = amount;
        this.transaction_no= transaction_no;
        this.transactionType= transactionType;
        this.dateTime= LocalDateTime.now();
    }

    public String getDescription()
    {
        return description;
    }

    public double getAmount()
    {
        return amount;
    }

    public String getTransactionType()
    {
        return transactionType;
    }

    public int getTransaction_no()
    {
        return transaction_no;
    }

    public LocalDateTime getDateTime()
    {
        return dateTime;
    }

}
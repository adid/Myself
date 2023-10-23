class Transaction
{
    private String description;
    private double amount;

    public Transaction(String description, double amount)
    {
        this.description = description;
        if (amount < 0)
        {
            throw new IllegalArgumentException("Transaction amount must be non-negative.");
        }
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

}
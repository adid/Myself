package Finance;

import Finance.Transaction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransactionTest
{
    void getAmount_ShouldReturn_Zero()
    {
        Transaction transaction = new Transaction("Purchase", 00.0,"Buying things");
        assertEquals(00.0,transaction.getAmount());
    }
    @Test
    void getDescription_ShouldReturn_Salary() {
        Finance.Transaction transaction1 = new Finance.Transaction("Salary", 1000.0,"Income");
        assertEquals("Salary", transaction1.getDescription());

    }

    @Test
    void getAmount_ShouldThrow_exception()
    {
        assertThrows(IllegalArgumentException.class, () -> new Finance.Transaction("Purchase", -200.0,"Buying things"));
    }
    @Test
    void getAmount_ShouldReturn_500()
    {
        Finance.Transaction transaction2 = new Finance.Transaction("Purchase", 500.0,"Buying things");
        assertEquals(500,transaction2.getAmount());
    }
    @Test
    void getDescription_ShouldReturn_CorrectDescription()
    {
        Transaction transaction = new Transaction("Purchase", 50.0, "Buying things");
        assertEquals("Purchase", transaction.getDescription());
    }

    @Test
    void getDescription_ShouldReturn_EmptyDescription()
    {
        Transaction transaction = new Transaction("", 50.0, "Purchase" );
        assertEquals("", transaction.getDescription());
    }

    @Test
    void setDescription_ShouldUpdateDescription() {
        Transaction transaction = new Transaction("Rent", 1000.0, "Housing");
        transaction.setTransactionType("Monthly Rent Payment");
        assertEquals("Monthly Rent Payment", transaction.getTransactionType());
    }
}
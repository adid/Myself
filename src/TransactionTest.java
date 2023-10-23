import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransactionTest
{
    void getAmount_ShouldReturn_Zero()
    {
        Transaction transaction = new Transaction("Purchase", 00.0);
        assertEquals(00.0,transaction.getAmount());
    }
    @Test
    void getDescription_ShouldReturn_Salary() {
        Transaction transaction1 = new Transaction("Salary", 1000.0);
        assertEquals("Salary", transaction1.getDescription());

    }

    @Test
    void getAmount_ShouldThrow_exception()
    {
        assertThrows(IllegalArgumentException.class, () -> new Transaction("Purchase", -200.0));
    }
    @Test
    void getAmount_ShouldReturn_500()
    {
        Transaction transaction2 = new Transaction("Purchase", 500.0);
        assertEquals(500,transaction2.getAmount());
    }
}

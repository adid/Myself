//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//class TransactionTest
//{
//    void getAmount_ShouldReturn_Zero()
//    {
//        Finance.Transaction transaction = new Finance.Transaction("Purchase", 00.0);
//        assertEquals(00.0,transaction.getAmount());
//    }
//    @Test
//    void getDescription_ShouldReturn_Salary() {
//        Finance.Transaction transaction1 = new Finance.Transaction("Salary", 1000.0);
//        assertEquals("Salary", transaction1.getDescription());
//
//    }
//
//    @Test
//    void getAmount_ShouldThrow_exception()
//    {
//        assertThrows(IllegalArgumentException.class, () -> new Finance.Transaction("Purchase", -200.0));
//    }
//    @Test
//    void getAmount_ShouldReturn_500()
//    {
//        Finance.Transaction transaction2 = new Finance.Transaction("Purchase", 500.0);
//        assertEquals(500,transaction2.getAmount());
//    }
//}

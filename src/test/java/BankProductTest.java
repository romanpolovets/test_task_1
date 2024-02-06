import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankProductTest {

    @Test
    public void testDeposit_PositiveAmount_ShouldIncreaseBalance() {
        DebitCard product = new DebitCard("Debit Card", "RUB", BigDecimal.valueOf(1000.0));
        product.deposit(BigDecimal.valueOf(300.0));
        assertEquals(BigDecimal.valueOf(1300.0), product.getBalance());
    }

    @Test
    void testDeposit_NegativeAmount_ShouldThrowIllegalArgumentException() {
        CreditCard product = new CreditCard("Credit Card", "EUR", BigDecimal.valueOf(300.0), BigDecimal.valueOf(0.1));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            product.deposit(new BigDecimal("-50"));
        });
        assertEquals("Amount cannot be negative", exception.getMessage());
        assertEquals(BigDecimal.valueOf(300.0), product.getBalance());
    }

    @Test
    void testDeposit_ZeroAmount_ShouldNotChangeBalance() {
        ForeignDebitCard product = new ForeignDebitCard("Debit Card", "USD", BigDecimal.valueOf(0));
        product.deposit(BigDecimal.ZERO);
        assertEquals(BigDecimal.ZERO, product.getBalance());
    }

    @Test
    public void testWithdraw_PositiveAmount_ShouldIncreaseBalance() {
        DebitCard product = new DebitCard("Debit Card", "RUB", BigDecimal.valueOf(10000.0));
        product.deposit(BigDecimal.valueOf(300.0));
        assertEquals(BigDecimal.valueOf(10300.0), product.getBalance());
    }

    @Test
    void testWithdraw_NegativeAmount_ShouldThrowIllegalArgumentException() {
        DebitCard product = new DebitCard("Debit Card", "USD", BigDecimal.valueOf(300.0));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            product.deposit(new BigDecimal("-50"));
        });
        assertEquals("Amount cannot be negative", exception.getMessage());
        assertEquals(BigDecimal.valueOf(300.0), product.getBalance());
    }

    @Test
    void testWithdraw_ZeroAmount_ShouldNotChangeBalance() {
        Deposit product = new Deposit("Debit Card", "EUR", BigDecimal.valueOf(0));
        product.deposit(BigDecimal.ZERO);
        assertEquals(BigDecimal.ZERO, product.getBalance());
    }
}
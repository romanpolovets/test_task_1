import java.math.BigDecimal;

public class Deposit extends BankProduct {
    public Deposit (String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }

    public void closeDeposit() {
    }
}

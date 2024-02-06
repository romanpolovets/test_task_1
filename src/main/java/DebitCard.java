import java.math.BigDecimal;

public class DebitCard extends BankProduct {
    public DebitCard(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }
}

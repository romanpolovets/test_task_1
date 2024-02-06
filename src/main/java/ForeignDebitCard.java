import java.math.BigDecimal;

public class ForeignDebitCard extends BankProduct {
    public ForeignDebitCard(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }
}

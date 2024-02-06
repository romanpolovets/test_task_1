import java.math.BigDecimal;

public class CreditCard extends BankProduct {

    private BigDecimal interestRate;

    public CreditCard(String name, String currency, BigDecimal balance, BigDecimal interestRate) {
        super(name, currency, balance);
        this.interestRate = interestRate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public BigDecimal getDebt() {
        return getBalance().compareTo(BigDecimal.ZERO) < 0 ? getBalance() : BigDecimal.ZERO;
    }
}

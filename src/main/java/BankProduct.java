import java.math.BigDecimal;

public abstract class BankProduct {
    private String name;
    private String currency;
    private BigDecimal balance;

    public BankProduct (String name, String currency, BigDecimal balance) {
        this.name = name;
        this.currency = currency;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        BigDecimal result = balance.add(amount);
        balance = result;
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        BigDecimal result =  balance.subtract(amount);
        balance = result;
    }
}

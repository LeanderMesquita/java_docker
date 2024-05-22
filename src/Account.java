import java.math.BigDecimal;

public class Account {

    private final Client client;

    private BigDecimal balance;

    public Account(Client client, BigDecimal initialBalance) {
        this.balance = initialBalance;
        this.client = client;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void debitBalance(BigDecimal value) {
        this.balance = this.balance.subtract(value);
    }
}
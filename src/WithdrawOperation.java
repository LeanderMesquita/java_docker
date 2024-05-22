import java.math.BigDecimal;

public class WithdrawOperation implements Runnable{

    private final Account account;
    private final BigDecimal value;

    public WithdrawOperation(Account account, BigDecimal value) {
        this.account = account;
        this.value = value;
    }

    public synchronized void execute() {
        System.out.println("Iniciando operação de saque.");
        var currentBalance = account.getBalance();

        if (currentBalance.compareTo(value) >= 0) {
            System.out.println("Debitando valor da conta");
            account.debitBalance(value);
            System.out.println("Saldo atual: " +account.getBalance());
        }
        System.out.println("Finalizando operação de saque.");
    }

    @Override
    public void run() {
        try {
            
            execute();
            System.out.println(Thread.currentThread().getName());

        } catch (Exception e) {
            throw e;
        }
        
    }
}
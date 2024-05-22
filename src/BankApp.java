
import java.math.BigDecimal;

public class BankApp {
    public static void main(String[] args) {
        
        var client = new Client("Marcos");
        var account = new Account(client, new BigDecimal("550"));
        var operation = new WithdrawOperation(account, new BigDecimal("550"));

        Thread marcosWithdraw = new Thread(operation);
        Thread mariaWithdraw = new Thread(operation);
        
        System.out.println("Thread atual:"+Thread.currentThread().getName());
        
        marcosWithdraw.start();
        mariaWithdraw.start();


        try {
            marcosWithdraw.join();
            mariaWithdraw.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Saldo atual: "+account.getBalance());
    }
}
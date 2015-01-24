package pl.training;

import java.math.BigDecimal;
import java.text.NumberFormat;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import pl.training.facade.BankOperationException;

//@Aspect
public class ConsoleTransactionLogger {
    
    private static final String SEPARATOR = "##############################################";
    
//    @Pointcut("execution(* pl.training.facade.Bank.*Cash*(..))")
    public void financialOperations(){};
    
    private String formatCurrency (BigDecimal value){
        return NumberFormat.getCurrencyInstance().format(value);
    }
    
//    @Before("execution(* pl.training.facade.Bank.payInCashToAccount(..)) && args(accountNumber, amount)")
    public void beforePayInCashTransaction(String accountNumber, BigDecimal amount) {
    
        System.out.println(SEPARATOR);
        System.out.println(accountNumber + " <=== " + formatCurrency(amount));
    }
    
//    @Before("execution(* pl.training.facade.Bank.payOutCashToAccount(..)) && args(accountNumber, amount)")
    public void beforePayOutCashTransaction(String accountNumber, BigDecimal amount) {
    
        System.out.println(SEPARATOR);
        System.out.println(accountNumber + " ===> " + formatCurrency(amount));
    }
    
//    @Before("execution(* pl.training.facade.Bank.beforeTransferCash(..)) && args(fromAccountNumber, amount, toAccountNumber)")
    public void beforeTransferCash(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
    
        System.out.println(SEPARATOR);
        System.out.println(fromAccountNumber + " ===> " + formatCurrency(amount) + " ===> " + toAccountNumber);
    }
    
    @AfterReturning(pointcut = "financialOperations()")
    public void inSucces(){
        System.out.println("Operacja zakonczona sukcesem");
        System.out.println(SEPARATOR);
    }
    
    @AfterThrowing(value = "financialOperations()", throwing = "ex")
    public void onFailure(BankOperationException ex) {
        System.out.println("Operacja zakończona błędem");
    }
}

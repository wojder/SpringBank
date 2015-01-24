package pl.training;

import static pl.training.domain.AddressType.HOME;

import java.math.BigDecimal;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.training.domain.Account;
import pl.training.domain.Address;
import pl.training.domain.Client;
import pl.training.facade.Bank;

public class App {

    public static void main(String[] args) {
        AbstractApplicationContext context = 
                new AnnotationConfigApplicationContext(BeansConfig.class);
        context.registerShutdownHook();
        Bank bank = context.getBean(Bank.class);

        Client client1 = bank.addClient(new Client("Jan", "Kowalski",
                new Address("Dobra", "31a", "61-333", "Poznań", HOME)));
        Client client2 = bank.addClient(new Client("Maria", "Nowak",
                new Address("Miła", "11", "12-444", "Warszawa", HOME)));
        Account account1 = bank.createAccountForClient(client1);
        Account account2 = bank.createAccountForClient(client2);

        bank.payInCashToAccount(account1.getNumber(), new BigDecimal(200));
        bank.payInCashToAccount(account2.getNumber(), new BigDecimal(500));
        bank.transferCash(account1.getNumber(), account2.getNumber(), new BigDecimal(100));
    }

}

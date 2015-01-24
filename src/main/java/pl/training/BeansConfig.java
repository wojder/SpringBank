package pl.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import pl.training.facade.Bank;
import pl.training.facade.BankImpl;
import pl.training.service.persistence.AccountRepository;
import pl.training.service.persistence.ClientRepository;
import pl.training.service.persistence.SynchronizedMapAccountRepository;
import pl.training.service.persistence.SynchronizedMapClientRepository;
import pl.training.service.persistence.generator.AccountNumberGenerator;
import pl.training.service.persistence.generator.SynchronizedAccountNumberGenerator;

@ImportResource("ctx.xml")
//@EnableAspectJAutoProxy
@Configuration
public class BeansConfig {
  
    @Bean
    public AccountNumberGenerator accountNumberGenerator() {
        return new SynchronizedAccountNumberGenerator();
    }
    
    @Bean
    public AccountRepository accountRepository() {
        return new SynchronizedMapAccountRepository();
    }
    
    @Bean
    public ClientRepository clientRepository() {
        return new SynchronizedMapClientRepository();
    }

    @Bean
    public Bank bank(AccountNumberGenerator accountNumberGenerator,
            AccountRepository accountRepository, ClientRepository clientRepository) {
        return new BankImpl(accountNumberGenerator, accountRepository, clientRepository);
    }
    
    @Bean
    public ConsoleTransactionLogger consoleTransactionLogger(){
            return new ConsoleTransactionLogger();
    }
}

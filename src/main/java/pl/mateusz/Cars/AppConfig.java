package pl.mateusz.Cars;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "pl.mateusz.Cars")
@EnableJpaRepositories(basePackages = "pl.mateusz.Cars.repository")
@EnableTransactionManagement
public class AppConfig {
}

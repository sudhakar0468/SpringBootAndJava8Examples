package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Config;

import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configurable
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Repo.Employe",
        entityManagerFactoryRef = "," ,
        transactionManagerRef = ""

)
public class UserDataBaseConfiguration {

    @Bean
    public PhysicalNamingStrategy physicalNamingStrategy() {
        return new PhysicalNamingStrategyStandardImpl();
    }


}

package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Config;

import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Repo.Employe.EmployeRepository;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Repo.Employe",
        entityManagerFactoryRef = "employeEntityManagerFactory",
        transactionManagerRef = "employTransactionManager"
       // basePackageClasses = EmployeRepository.class

)
public class EmployeDataBaseConfiguration {

    @Bean
    public PhysicalNamingStrategy physicalNamingStrategy() {
        return new PhysicalNamingStrategyStandardImpl();
    }

    @Bean(name = "employProperties")
    @ConfigurationProperties("spring.firstdatabase.datasource")
    @Primary
    public DataSourceProperties createDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = "employeProperies")
    @Primary
    @ConfigurationProperties("spring.firstdatabase.datasource")
    public DataSource createEmployeDataSource(@Qualifier("employProperties") final DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
    @Bean(name = "employeEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean createEntityManagerBean(final EntityManagerFactoryBuilder builder,@Qualifier("employProperties") final DataSourceProperties dataSourceProperties) {
        return builder
                .dataSource(createEmployeDataSource(dataSourceProperties))
                .packages("com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Entity.Employe")
                .build();
    }

    @Bean(name = "employTransactionManager")
    @Primary
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager createPlatformTransactionManager(@Qualifier("employeEntityManagerFactory") final EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }

}

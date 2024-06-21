package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
//@PropertySource({""}) for different application properties
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "deviceEntityManager",
        transactionManagerRef = "deviceTransactionManager",
        basePackages = "com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Repo.SecondDatabseRepo")
public class DeviceDataBaseConfiguration {

    @Bean(name = "deviceProperties")
    @ConfigurationProperties(prefix = "spring.seconddatabase.datasource")
    public DataSourceProperties createDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "deviceDataSource")
    @ConfigurationProperties(prefix = "spring.seconddatabase.datasource")
    public DataSource createDeviceDataSource(@Qualifier("deviceProperties") final DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean("deviceEntityManager")
    public LocalContainerEntityManagerFactoryBean secondDataBaseEntityManagerFactoryBean(final EntityManagerFactoryBuilder builder, @Qualifier("deviceProperties") final DataSourceProperties dataSourceProperties) {
        return builder
                .dataSource(createDeviceDataSource(dataSourceProperties))
                .packages("com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Entity.Device")
                .persistenceUnit("device")
                .build();
    }

    @Bean("deviceTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager createPlatformTransactionManager(@Qualifier("deviceEntityManager") final EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }

}

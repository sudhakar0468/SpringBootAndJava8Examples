package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
//@PropertySource({""}) for different application properties
@EnableJpaRepositories(basePackages = "com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Repo.SecondDatabseRepo")
public class SecondDataBaseConfiguration {

@Autowired
private Environment env;


}

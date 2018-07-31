package com.scgj.sdms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import com.scgj.sdms.configuration.*;
@Configuration
@SpringBootApplication
@ComponentScan({"com.scgj.sdms"})
@EnableJpaRepositories(basePackages = "com.scgj.sdms.interfaces", entityManagerFactoryRef="entityManagerFactory")
@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
@EnableConfigurationProperties({
		FlieStorageProperties.class
})
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class SdmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdmsApplication.class, args);
	}
}

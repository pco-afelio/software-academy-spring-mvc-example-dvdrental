package be.afelio.software_academy.spring_mvc.example.dvdrental.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.dialect.PostgreSQL82Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("be.afelio.software_academy.spring_mvc.example.dvdrental.persistence")
@EnableJpaRepositories("be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.repositories")
@PropertySource("classpath:database.properties")
public class PersistenceConfig {

    @Autowired
    Environment environment;

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl(environment.getProperty("database.url"));
        datasource.setUsername(environment.getProperty("database.user"));
        datasource.setPassword(environment.getProperty("database.password"));
        datasource.setDriverClassName(environment.getProperty("database.driver"));
        return datasource;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setPackagesToScan("be.afelio.software_academy.spring_mvc.example.dvdrental.persistence.entities");
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", PostgreSQL82Dialect.class.getName());
        properties.setProperty("hibernate.show_sql", "true");
        // properties.setProperty("hibernate.format_sql", "true");
        emf.setJpaProperties(properties);
        return emf;
    }

    @Bean
    JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}

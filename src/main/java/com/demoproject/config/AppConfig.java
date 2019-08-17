package com.demoproject.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.demoproject")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {

    // set up a variable to hold the properties
    @Autowired
    private Environment env;

    // logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // security datasource
    @Bean
    public DataSource createDataSource() {

        // create connection pool
        ComboPooledDataSource newDataSource = new ComboPooledDataSource();

        // set the jdbc driver pool
        try {
            newDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        // log the connection pool
        logger.info(">>> jdbc.url" + env.getProperty("jdbc.url"));
        logger.info(">>> jdbc.user" + env.getProperty("jdbc.user"));

        // set database connection props
        newDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        newDataSource.setUser(env.getProperty("jdbc.user"));
        newDataSource.setPassword(env.getProperty("jdbc.password"));

        // set connection pool props
        newDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        newDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        newDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        newDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return newDataSource;
    }

    // convert String property values to int
    private int getIntProperty(String propName) {

        String propValue = env.getProperty(propName);
        return Integer.parseInt(propValue);
    }

    private Properties getHibernateProperties() {

        // set hibernate properties
        Properties props = new Properties();

        props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

        return props;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){

        // create session factories
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        // set the properties
        sessionFactory.setDataSource(createDataSource());
        sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());

        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

        // setup transaction manager based on session factory
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }


}

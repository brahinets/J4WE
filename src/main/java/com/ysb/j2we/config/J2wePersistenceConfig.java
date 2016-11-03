package com.ysb.j2we.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class J2wePersistenceConfig {

    @Value("${jdbc.driverClassName}")
    private String jdbcDriverClassName;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    @Value("${hibernate.show_sql}")
    private boolean hibernateShowSql;

    @Value("${hibernate.format_sql}")
    private boolean hibernateFormatSql;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName(jdbcDriverClassName);
        ds.setUrl(jdbcUrl);
        ds.setUsername(jdbcUsername);
        ds.setPassword(jdbcPassword);

        return ds;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

        sessionFactoryBean.setHibernateProperties(getHibernateProperties());
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.ysb.j2we.model.entity");

        return sessionFactoryBean;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();

        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.format_sql", hibernateFormatSql);

        return properties;
    }
}

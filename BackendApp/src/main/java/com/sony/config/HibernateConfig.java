/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sony.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.sony"})
@EnableTransactionManagement
public class HibernateConfig {
    
    
    
    private final static String DATABASE_URL = "jdbc:mysql://localhost/corej";
    private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private final static String DATABASE_USER = "root";
    private final static String DATABASE_PASSWORD = "mysql";
    private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USER);
        dataSource.setPassword(DATABASE_PASSWORD);
        return dataSource;

    }

    @Bean
    public SessionFactory getSessionFactory() {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(getDataSource());
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", DATABASE_DIALECT);
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        builder.addProperties(hibernateProperties);
        builder.scanPackages("com.sony.domain");

        return builder.buildSessionFactory();
    }
    /*
    @Bean
    public DataSourceTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
    DataSourceTransactionManager manager = new DataSourceTransactionManager(getDataSource());
    return manager;
    }*/

}

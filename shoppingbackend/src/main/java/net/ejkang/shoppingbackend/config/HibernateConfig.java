package net.ejkang.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
// import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "net.ejkang.shoppingbackend.dto" })
@EnableTransactionManagement
// @PropertySource("classpath:connection1.properties")
public class HibernateConfig {

    // @Value("${jdbc.url}")
    private String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";

    // @Value("${jdbc.drive}")
    private String DATABASE_DRIVE = "org.h2.Driver";

    // @Value("${jdbc.dialeck}")
    private String DATABASE_DIALECK = "org.hibernate.dialect.H2Dialect";

    // @Value("${jdbc.username}")
    private String DATABASE_USERNAME = "sa";

    // @Value("${jdbc.password}")
    private String DATABASE_PASSWORD = "";

    @Bean
    public DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(DATABASE_URL);
        ds.setDriverClassName(DATABASE_DRIVE);
        ds.setUsername(DATABASE_USERNAME);
        ds.setPassword(DATABASE_PASSWORD);
        return ds;
    }

    @Bean
    public SessionFactory getSessionFactory(DataSource ds) {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(ds);
        builder.addProperties(getHibernateProperties());
        builder.scanPackages("net.ejkang.shoppingbackend.dto");

        return builder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties prop = new Properties();

        prop.put("hibernate.dialect", DATABASE_DIALECK);
        prop.put("hibernate.show_sql", "true") ;
        prop.put("hibernate.format_sql", "true");

        return prop;
    }

    @Bean
    public HibernateTransactionManager getTransactionManger(SessionFactory sessionFactory) {
        HibernateTransactionManager htm = new HibernateTransactionManager(sessionFactory);
        return htm;
    }
}
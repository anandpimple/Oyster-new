package gov.tfl.oyster.restservices;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;
/**
 * Created by dev on 18/10/16.
 */
@Configuration
@ComponentScan(basePackages = {"com.oma.services","com.oma.controllers"})
@EnableJpaRepositories("com.oma.repositories")
public class BeanConfigurations {
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
//        dataSource.setDriverClassName("com.oracle.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://127.0.0.1:1521/INVENTORY?profileSQL=true");
        dataSource.setUsername("INVENTORY");
        dataSource.setPassword("omkar@060707");
        return dataSource;
    }
    @Autowired
    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory getEntityManagerFactory(DataSource dataSource) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.oma.domains");
        factory.setDataSource(dataSource);


        Properties jpaProps = new Properties();
//        jpaProps.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        jpaProps.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
        jpaProps.put("hibernate.hbm2ddl.show-sql","true");
        jpaProps.put("hibernate.hbm2ddl.auto","create-drop");
        factory.setJpaProperties(jpaProps);

        factory.afterPropertiesSet();
        return factory.getObject();
    }
}

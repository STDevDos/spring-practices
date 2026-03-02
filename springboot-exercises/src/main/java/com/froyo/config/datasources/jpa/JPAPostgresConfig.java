package com.froyo.config.datasources.jpa;

import com.froyo.service.model.entity.DomainPackagesJPA;
import com.froyo.service.repository.postgres.RepositoryPackagePostgres;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "postgresEntityManagerFactory",
        transactionManagerRef = "postgresTransactionManager",
        basePackageClasses = RepositoryPackagePostgres.class
)
@EnableJpaAuditing
public class JPAPostgresConfig {

    private final Environment env;
    private final DataSource datasourcePostgres;

    public JPAPostgresConfig(Environment env, DataSource datasourcePostgres) {
        this.env = env;
        this.datasourcePostgres = datasourcePostgres;
    }

    @Bean(name = "postgresEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory() {

        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(datasourcePostgres);
        entityManagerFactoryBean.setPackagesToScan(DomainPackagesJPA.class.getPackageName());
        //entityManagerFactoryBean.setJpaVendorAdapter(this.vendorAdaptor());

        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPersistenceUnitName("postgres");

        entityManagerFactoryBean.setJpaProperties(this.jpaHibernateProperties());
        //entityManagerFactoryBean.afterPropertiesSet();

        return entityManagerFactoryBean;
    }

    @Bean(name = "postgresTransactionManager")
    public PlatformTransactionManager postgresTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(postgresEntityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties jpaHibernateProperties() {
        final Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", env.getProperty("postgresql.jpa.show-sql"));
        properties.setProperty("hibernate.dialect", env.getProperty("postgresql.jpa.properties.hibernate.dialect"));
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("postgresql.jpa.properties.hibernate.ddl-auto"));
        return properties;
    }

}

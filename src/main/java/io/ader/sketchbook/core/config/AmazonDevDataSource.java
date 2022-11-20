package io.ader.sketchbook.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@EnableJpaRepositories(
        basePackages = "io.ader.sketchbook.core.repository.amazon.dev",
        entityManagerFactoryRef = "AmazonDevEntityManager",
        transactionManagerRef = "AmazonDevTransactionManager"
)
@Configuration
public class AmazonDevDataSource {
    @Bean("AmazonDevEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] {"io.ader.sketchbook.core.domain.entity.amazon"});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean("AmazonDevDataSource")
    @ConfigurationProperties(prefix = "spring.datasource-amazon-dev")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("AmazonDevTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager().getObject());
        return transactionManager;
    }
}

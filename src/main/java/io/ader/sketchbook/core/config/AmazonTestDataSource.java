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
        basePackages = "io.ader.sketchbook.core.repository.amazon.test",
        entityManagerFactoryRef = "AmazonTestEntityManager",
        transactionManagerRef = "AmazonTestTransactionManager"
)
@Configuration
public class AmazonTestDataSource {
    @Bean("AmazonTestEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] {"io.ader.sketchbook.core.domain.entity.amazon"});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean("AmazonTestDataSource")
    @ConfigurationProperties(prefix = "spring.datasource-amazon-test")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("AmazonTestTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager().getObject());
        return transactionManager;
    }
}

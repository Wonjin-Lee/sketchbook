package io.ader.sketchbook.sample.config;

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
        basePackages = "io.ader.sketchbook.repository.alpha.test",
        entityManagerFactoryRef = "alphaTestEntityManager",
        transactionManagerRef = "alphaTestTransactionManager"
)
@Configuration
public class AlphaTestDataSourceConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean alphaTestEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(alphaTestDataSource());
        em.setPackagesToScan(new String[] {"io.ader.sketchbook.domain.alpha"});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource-alpha-test")
    public DataSource alphaTestDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public PlatformTransactionManager alphaTestTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(alphaTestEntityManager().getObject());
        return transactionManager;
    }
}

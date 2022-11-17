package io.ader.sketchbook.config;

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
        basePackages = "io.ader.sketchbook.repository.alpha.dev",
        entityManagerFactoryRef = "alphaDevEntityManager",
        transactionManagerRef = "alphaDevTransactionManager"
)
@Configuration
public class AlphaDevDataSourceConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean alphaDevEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(alphaDevDataSource());
        em.setPackagesToScan(new String[] {"io.ader.sketchbook.domain.alpha"});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource-alpha-dev")
    public DataSource alphaDevDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public PlatformTransactionManager alphaDevTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(alphaDevEntityManager().getObject());
        return transactionManager;
    }
}

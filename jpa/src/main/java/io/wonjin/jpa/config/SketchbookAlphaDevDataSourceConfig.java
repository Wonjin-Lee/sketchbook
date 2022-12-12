package io.wonjin.jpa.config;

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
        basePackages = "io.wonjin.jpa.repository.user.dev",
        entityManagerFactoryRef = "sketchbookAlphaDevEntityManager",
        transactionManagerRef = "sketchbookAlphaDevTransactionManager"
)
@Configuration
public class SketchbookAlphaDevDataSourceConfig {
    @Bean("sketchbookAlphaDevEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] {"io.wonjin.jpa.domain.user"});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean("sketchbookAlphaDevDataSource")
    @ConfigurationProperties(prefix = "spring.datasource-sketchbook-alpha-dev")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("sketchbookAlphaDevTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager().getObject());
        return transactionManager;
    }
}
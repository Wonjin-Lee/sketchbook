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
        basePackages = "io.ader.sketchbook.core.repository.facebook.dev",
        entityManagerFactoryRef = "facebookDevEntityManager",
        transactionManagerRef = "facebookDevTransactionManager"
)
@Configuration
public class FacebookDevDataSource {
    @Bean
    public LocalContainerEntityManagerFactoryBean facebookDevEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] {"io.ader.sketchbook.core.domain.entity.facebook"});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean("FacebookDevDataSource")
    @ConfigurationProperties(prefix = "spring.datasource-facebook-dev")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public PlatformTransactionManager facebookDevTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(facebookDevEntityManager().getObject());
        return transactionManager;
    }
}

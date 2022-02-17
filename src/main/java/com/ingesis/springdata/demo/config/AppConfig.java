package com.ingesis.springdata.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static org.eclipse.persistence.config.PersistenceUnitProperties.SCHEMA_GENERATION_CREATE_ACTION;
import static org.eclipse.persistence.config.PersistenceUnitProperties.SCHEMA_GENERATION_CREATE_SCRIPT_SOURCE;
import static org.eclipse.persistence.config.PersistenceUnitProperties.SCHEMA_GENERATION_CREATE_SOURCE;
import static org.eclipse.persistence.config.PersistenceUnitProperties.SCHEMA_GENERATION_DATABASE_ACTION;
import static org.eclipse.persistence.config.PersistenceUnitProperties.SCHEMA_GENERATION_SCRIPT_SOURCE;
import static org.eclipse.persistence.config.PersistenceUnitProperties.SCHEMA_GENERATION_SQL_LOAD_SCRIPT_SOURCE;

@Configuration
public class AppConfig {

    @Bean
    public static DataSource dataSource(AppProps appProps) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(appProps.getDbUrl());
        dataSource.setDriverClassName(appProps.getDatabaseDriverClass());
        dataSource.setAutoCommit(false);
        dataSource.setUsername(appProps.getDbAppUsername());
        dataSource.setPassword(appProps.getDbAppPassword());
        return dataSource;
    }

    @Bean
    public static PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    @Primary
    public static JpaProperties properties() {
        final JpaProperties jpaProperties = new JpaProperties();
        jpaProperties.setShowSql(true);
        jpaProperties.setDatabasePlatform("org.eclipse.persistence.platform.database.H2Platform");
        return jpaProperties;
    }

    private static Map<String, ?> initJpaProperties() {
        final Map<String, Object> props = new HashMap<>();
        // Add any JpaProperty you are interested in and is supported by your Database and JPA implementation
        props.put(PersistenceUnitProperties.WEAVING, "false");
        return props;
    }

    @Bean
    public AppProps appProps() {
        return new AppProps();
    }

    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactory(
            EntityManagerFactoryBuilder builder, DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.ingesis.springdata.demo")
                .persistenceUnit("spring-data-demo-pu")
                .properties(initJpaProperties()).build();
    }

}

package com.ingesis.springdata.demo.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class AppProps {
    @Value("${database.url}")
    private String dbUrl;

    @Value("${database.app.username}")
    private String dbAppUsername;

    @Value("${database.app.password}")
    private String dbAppPassword;

    @Value("${database.driver.class:org.h2.Driver}")
    private String databaseDriverClass;

}

package com.employee.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

@Configuration
public class DatabaseConfig {

    private static final Logger logger = Logger.getLogger(DatabaseConfig.class.getName());

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public Connection getConnection() throws SQLException {
        logger.info("enter=getConnection() msg=DBConnection status=success");
        return DriverManager.getConnection(url, username, password);
    }
}
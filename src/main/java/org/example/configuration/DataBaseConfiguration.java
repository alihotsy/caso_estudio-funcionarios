package org.example.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DataBaseConfiguration {
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/info_funcionarios");
        config.setUsername("root");
        config.setPassword("root");
        return new HikariDataSource(config);
    }
}

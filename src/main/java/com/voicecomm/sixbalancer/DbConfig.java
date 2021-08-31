package com.voicecomm.sixbalancer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Bean(name = "postgresDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getCachePostgresDataSource() {
        System.out.println("--- Postgres data source ---");
        //SqlComponent sql ;
        return DataSourceBuilder.create().build();
    }

}

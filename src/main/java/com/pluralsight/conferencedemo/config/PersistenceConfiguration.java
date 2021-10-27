package com.pluralsight.conferencedemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    @Bean//spring will look at data source context and replace it with
    public DataSource dataSource(){//a data source is a Java object for storing data - it can be complex data bases or simple tables.
        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.username(System.getenv("DB_USER"));
//        builder.password(System.getenv("DB_PASS"));
//        builder.url(System.getenv("DB_URL"));
        builder.username("postgres");
        builder.password("myPassword");
        builder.url("jdbc:postgresql://localhost:5432/postgres");
        System.out.println("Custom datasource bean has been initialized and set.");
        return builder.build();
    }


}

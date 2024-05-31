package com.example.managestudentjooq.config;

import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JooqConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    public DefaultDSLContext dslContext() {
        return new DefaultDSLContext(dataSource, SQLDialect.MYSQL);
    }
}

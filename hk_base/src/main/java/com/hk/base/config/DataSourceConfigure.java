package com.hk.base.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfigure {
    @Bean
    @RefreshScope
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(DataSourceProperties properties){
        System.out.println("执行了重新获取数据源");
        return DataSourceBuilder.create(properties.getClassLoader())
                .type(HikariDataSource.class)
                .driverClassName(properties.determineDriverClassName())
                .url(properties.determineUrl())
                .username(properties.determineUsername())
                .password(properties.determinePassword())
                .build();
    }
}

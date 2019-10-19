package com.csxkaka.springbootstudy.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * 配置beetlsql数据源 默认是HikariDataSource
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "datasource")
    public DataSource dataSource(Environment env) {
        DataSource dataSource =  DataSourceBuilder.create().url(env.getProperty("spring.datasource.url"))
                .username(env.getProperty("spring.datasource.username"))
                .password(env.getProperty("spring.datasource.username")).build();
        return dataSource;
    }
}

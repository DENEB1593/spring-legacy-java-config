package com.sinsa.palletpang.common.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource(
        value = "classpath:${spring.profiles.active}.properties",
        ignoreResourceNotFound = true)
@MapperScan(basePackages = "com.sinsa.palletpang.domain")
public class RootConfig {

        @Value("${spring.datasource.hikari.jdbc-url}")
        private String jdbcUrl;

        @Value("${spring.datasource.hikari.username}")
        private String username;

        @Value("${spring.datasource.hikari.password}")
        private String password;

        @Value("${spring.datasource.hikari.driver-class-name}")
        private String driverClassName;

        @Bean
        public DataSource dataSource() {
                HikariConfig hikariConfig = new HikariConfig();
                hikariConfig.setJdbcUrl(jdbcUrl);
                hikariConfig.setDriverClassName(driverClassName);
                hikariConfig.setUsername(username);
                hikariConfig.setPassword(password);

                return new HikariDataSource(hikariConfig);
        }


        @Bean
        public SqlSessionFactory sqlSessionFactory() throws Exception {
                SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
                sqlSessionFactory.setDataSource(dataSource());
                return sqlSessionFactory.getObject();
        }
}

package com.sinsa.palletpang.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.sinsa.palletpang.domain")
public class RootConfig {

        private DataSource dataSource;

        @Autowired
        public RootConfig(DataSource dataSource) {
                this.dataSource = dataSource;
        }

        @Bean
        public SqlSessionFactory sqlSessionFactory() throws Exception {
                SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
                sqlSessionFactory.setDataSource(dataSource);
                sqlSessionFactory.setMapperLocations(
                        new PathMatchingResourcePatternResolver().getResources("classpath:sql/*.xml"));
                return sqlSessionFactory.getObject();
        }
}

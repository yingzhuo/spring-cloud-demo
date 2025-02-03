package com.github.yingzhuo.scd.provider2;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author 应卓
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.github.yingzhuo.scd.provider2.mapper"})
@RequiredArgsConstructor
public class ApplicationBootDatabase {

    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        return new JdbcTransactionManager(dataSource);
    }

}

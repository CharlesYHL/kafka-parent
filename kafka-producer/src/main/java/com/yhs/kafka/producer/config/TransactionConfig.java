package com.yhs.kafka.producer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * @author Charles
 * @Title: TransactionConfig
 * @Package com.zw.walton.api.config
 * @Description: TODO
 * @date 2017/11/13 13:44
 */
@Configuration
@ComponentScan
public class TransactionConfig implements TransactionManagementConfigurer {
    @Autowired
    private DataSource dataSource;

    @Bean(name = "transactionManager")
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
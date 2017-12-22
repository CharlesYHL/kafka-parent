package com.yhs.kafka.consumer.confg;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.beans.PropertyVetoException;

/**
 * @author Charles
 * @Title: DBconfig
 * @Package com.zw.walton.api.config
 * @Description: TODO
 * @date 2017/11/13 13:33
 */
@Configuration
public class DBconfig {
    @Autowired
    private Environment env;

    @Bean(name="dataSource")
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(env.getProperty("zw.db.driverClassName"));
        dataSource.setJdbcUrl(env.getProperty("zw.db.url"));
        dataSource.setUser(env.getProperty("zw.db.username"));
        dataSource.setPassword(env.getProperty("zw.db.password"));
        dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("zw.db.maxPoolSize")));
        dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("zw.db.minPoolSize")));
        dataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("zw.db.initialPoolSize")));
        dataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("zw.db.maxIdleTime")));
        dataSource.setAcquireIncrement(Integer.parseInt(env.getProperty("zw.db.acquireIncrement")));
        dataSource.setIdleConnectionTestPeriod(Integer.parseInt(env.getProperty("zw.db.idleConnectionTestPeriod")));

        return dataSource;
    }
}

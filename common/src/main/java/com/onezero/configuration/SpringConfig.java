package com.onezero.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:druid.properties")
public class SpringConfig {

    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url")
    private String url;
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.initialSize}")
    private Integer initialSize;
    @Value("${jdbc.maxActive}")
    private Integer maxActive;
    @Value("${jdbc.maxWait}")
    private Integer maxWait;


    public DruidDataSource ds() {

        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(driverClassName);
        ds.setInitialSize(initialSize);
        ds.setMaxActive(maxActive);
        ds.setMaxWait(maxWait);
        return ds;
    }

}

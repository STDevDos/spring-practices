package com.froyo.service.config.databases;

import com.froyo.config.datasources.DataSourceMysqlConfig;
import com.froyo.config.datasources.jpa.JPAMysqlConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourceMysqlConfig.class, JPAMysqlConfig.class})
public class MysqlConfig {
}

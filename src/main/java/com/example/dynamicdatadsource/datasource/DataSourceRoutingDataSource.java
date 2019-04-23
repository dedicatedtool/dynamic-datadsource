package com.example.dynamicdatadsource.datasource;

/**
 * @author
 * @description
 * @create
 */

import com.example.dynamicdatadsource.context.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @description 动态数据源配置类，继承AbstractRoutingDataSource
 */
@Slf4j
public class DataSourceRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        log.info("Current DataSource is " + DynamicDataSourceContextHolder.getDataSourceKey());
        return DynamicDataSourceContextHolder.getDataSourceKey();
    }
}

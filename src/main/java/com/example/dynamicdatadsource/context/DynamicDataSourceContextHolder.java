package com.example.dynamicdatadsource.context;

import com.example.dynamicdatadsource.datasource.DataSourceKey;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @description
 * @create
 */
@Slf4j
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>() {

        /** 将 driverOrderWrite 数据源的 key 作为默认数据源的 key */
        @Override
        protected String initialValue() {
            return DataSourceKey.master.name();
        }
    };

    // 存放所有数据源key
    public static List<Object> dataSourceKeys = new ArrayList<>();

    // 设置数据源
    public static void setDataSourceKey(String key) {
        contextHolder.set(key);
    }

    // 获取数据源
    public static String getDataSourceKey() {
        return contextHolder.get();
    }

    // 清空数据源
    public static void clearDataSourceKey() {
        contextHolder.remove();
    }

    // 判断某个数据源是否存在
    public static boolean containDataSourceKey(String key) {
        return dataSourceKeys.contains(key);
    }
}
package com.example.dynamicdatadsource.aspect;

/**
 * @author
 * @description
 * @create
 */

import com.example.dynamicdatadsource.context.DynamicDataSourceContextHolder;
import com.example.dynamicdatadsource.datasource.TargetDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @description 在数据操作之前切换数据源，完成操作后将数据源重置为默认数据源
 */
@Slf4j // 打印日志不用再写声明Logger变量，使用lombok的注解@Slf4j即可
@Aspect
@Order(-1) // 在 transaction 执行前执行
@Component
public class DynamicDataSourceAspect {

    // 选择数据源
    @Before("@annotation(targetDataSource))")
    public void switchDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        // 数据源是否存在，存在则切换，反之使用默认
        if (!DynamicDataSourceContextHolder.containDataSourceKey(targetDataSource.value())) {
            log.info("DataSource [" + targetDataSource.value() + "] doesn't exist, use default DataSource [" + point.getSignature() + "] ");
        } else {
            // 切换数据源
            DynamicDataSourceContextHolder.setDataSourceKey(targetDataSource.value());
            log.info("Switch DataSource to [" + DynamicDataSourceContextHolder.getDataSourceKey() + "] in Method [" + point.getSignature() +"] ");
        }
    }

    // 执行完数据操作后，重置到默认数据源
    @After("@annotation(targetDataSource))")
    public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        // 将数据源置为默认数据源
        DynamicDataSourceContextHolder.clearDataSourceKey();
        log.info("Restore DataSource to [" + DynamicDataSourceContextHolder.getDataSourceKey() + "] in Method [" + point.getSignature() + "] ");
    }
}
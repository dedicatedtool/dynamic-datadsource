package com.example.dynamicdatadsource.service;

import com.example.dynamicdatadsource.dao.OrderDao;
import com.example.dynamicdatadsource.datasource.TargetDataSource;
import com.example.dynamicdatadsource.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @description
 * @create
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderDao orderDao;

    @TargetDataSource(value = "orderWrite")
    @Override
    public void insert(Order order) {
        orderDao.insert(order);
    }

    @TargetDataSource(value = "orderRead")
    @Override
    public List<Order> orderList() {
        return orderDao.orderList();
    }
}

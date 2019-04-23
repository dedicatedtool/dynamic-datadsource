package com.example.dynamicdatadsource.dao;

import com.example.dynamicdatadsource.entity.Order;

import java.util.List;

/**
 * @author
 * @description
 * @create
 */
public interface OrderDao {

    void insert(Order order);

    List<Order> orderList();
}

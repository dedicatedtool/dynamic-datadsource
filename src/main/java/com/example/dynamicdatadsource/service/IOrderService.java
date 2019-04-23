package com.example.dynamicdatadsource.service;

import com.example.dynamicdatadsource.entity.Order;

import java.util.List;

/**
 * @author
 * @description
 * @create
 */
public interface IOrderService {

    void insert(Order order);

    List<Order> orderList();
}

package com.example.dynamicdatadsource.controller;


import com.example.dynamicdatadsource.entity.Order;
import com.example.dynamicdatadsource.service.IOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @description
 * @create
 */
@RestController
@RequestMapping("/dynamicDS")
@Slf4j
public class OrderController {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private IOrderService orderService;

    @PostMapping(value = "/queryOrderList")
    public List queryOrderList(){
        List<Order> orderList = null;
        try {
            orderList = orderService.orderList();
            String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(orderList);
        } catch (Exception e) {
//            log.info("query order data exception!", e);
        }
        return orderList;
    }

    @PostMapping(value = "/insertOrder")
    public void insertOrder() {
        Order order = new Order();
        order.setOrderNo("20170512101112");
        order.setUserId("12345");
        order.setMoney(200.0);
        order.setCreateTime(sdf.format(new Date()));
        try {
            orderService.insert(order);
        } catch (Exception e) {
//            log.error("insert data exception!", e);
        }
    }
}
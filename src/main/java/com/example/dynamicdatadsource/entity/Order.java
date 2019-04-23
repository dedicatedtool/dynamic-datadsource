package com.example.dynamicdatadsource.entity;

import lombok.Data;

/**
 * @author
 * @description
 * @create
 */
// 类中不用在提供 get set 方法，使用lombok的注解 @Getter @Setter 即可
@Data
public class Order {

    private String orderNo; // 订单号
    private String userId; // 用户id
    private Double money; // 金额
    private String createTime; // 创建时间
}

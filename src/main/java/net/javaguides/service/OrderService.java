package net.javaguides.service;

import net.javaguides.entity.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    List<Order> findByMemberId(Long memberId);

    List<Order> findpayId(Long payId);
}

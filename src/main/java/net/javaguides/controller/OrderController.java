package net.javaguides.controller;

import net.javaguides.entity.Card;
import net.javaguides.entity.Member;
import net.javaguides.entity.Order;
import net.javaguides.entity.Pay;
import net.javaguides.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/VueTestApi/api/VueTest")
@RestController
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService=orderService;
    }

    @PostMapping("/createorder")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/orderlist")
    public ResponseEntity<List<Order>> searchMemberOrder(@RequestParam("memberId") Long memberId ){
        List<Order> members=orderService.findByMemberId(memberId);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }
    @GetMapping("/findorder")
    public ResponseEntity<List<Order>> findorder(@RequestParam("payId") Long payId) {
        List<Order> orders=orderService.findpayId(payId);
        return  new ResponseEntity<>(orders, HttpStatus.OK);
    }

//    @GetMapping("/findcard")
//    public Map<String,Object> findcard(@RequestParam("orderId") Long orderId) {
//        Map<String, Object> resultMap = new HashMap<>();
//        if(orderId!=null) {
//            Card card = orderService.findcard(orderId);
//            resultMap.put("card", card);
//            resultMap.put("Message", "查詢成功");
//        } else {
//            resultMap.put("Message", "查詢失敗");
//        }
//        return resultMap;
//    }
}

package net.javaguides.controller;

import net.javaguides.entity.Pay;
import net.javaguides.service.PayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/VueTestApi/api/VueTest")
public class PayController {

    private PayService payService;

    public PayController(PayService payService) {
        this.payService=payService;
    }

    @PostMapping("/createpay")
    public Pay createPay(@RequestBody Pay pay) {
        return payService.createPay(pay);
    }



}

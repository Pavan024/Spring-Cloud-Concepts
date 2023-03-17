package com.example.demo.common.common.controller;

import com.example.demo.common.common.Payment;
import com.example.demo.common.common.TransactionRequest;
import com.example.demo.common.common.TransactionResponse;
import com.example.demo.common.common.entity.Order;
import com.example.demo.common.common.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;
    
    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) throws JsonProcessingException {
        return service.saveOrder(request);
    }
//    @PostMapping("/bookOrder")
//    public Order bookOrder(@RequestBody Order request) throws JsonProcessingException {
//        return service.saveOrder(request);
//    }
}

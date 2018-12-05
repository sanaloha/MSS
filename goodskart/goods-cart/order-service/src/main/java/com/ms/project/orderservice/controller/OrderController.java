package com.ms.project.orderservice.controller;

import com.ms.project.orderservice.model.OrderRequest;
import com.ms.project.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createOrder(@RequestBody OrderRequest orderRequest){
        if(orderService.createOrder(orderRequest)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            throw new OrderNotCreatedException();
        }
    }

    private class OrderNotCreatedException extends RuntimeException {
    }
}

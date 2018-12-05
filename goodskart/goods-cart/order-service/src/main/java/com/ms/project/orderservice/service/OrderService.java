package com.ms.project.orderservice.service;

import com.ms.project.orderservice.client.ProductClient;
import com.ms.project.orderservice.model.Order;
import com.ms.project.orderservice.model.OrderRequest;
import com.ms.project.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    RestTemplate restTemplate;

    //@Autowired
    ProductClient productClient;


    public boolean createOrder(OrderRequest orderRequest){
        Order orderToBeSaved = OrderTransformer.transform(orderRequest);
        ResponseEntity<Boolean> forEntity = null;
        try{
            forEntity = restTemplate.getForEntity("http://product-service/product?id=" + orderRequest.getProductDetail().getCode(), Boolean.class);
        }catch(Exception e){
           throw new ProductServiceNotReachableException();
        }


        Order saved = null;
        if(forEntity.getBody()){
            saved = orderRepository.save(orderToBeSaved);
        }
        return saved != null;
    }

    public boolean createOrderWithFeign(OrderRequest orderRequest){
        Order orderToBeSaved = OrderTransformer.transform(orderRequest);
        ResponseEntity<Boolean> forEntity = productClient.isProductInInventory(orderRequest.getProductDetail().getCode());
        Order saved = null;
        if(forEntity.getBody()){
            saved = orderRepository.save(orderToBeSaved);
        }
        return saved != null;
    }

    private static class OrderTransformer {
        public static Order transform(OrderRequest orderRequest) {
            return Order.builder()
                    .id(orderRequest.getId())
                    .userId(orderRequest.getUserId())
                    .quantity(orderRequest.getQuantity())
                    .address(orderRequest.getAddress())
                    .productDetail(Order.ProductDetail.builder()
                            .code(orderRequest.getProductDetail().getCode())
                            .description(orderRequest.getProductDetail().getDescription())
                            .name(orderRequest.getProductDetail().getName())
                            .build())
                    .build();
        }
    }

    public static class ProductServiceNotReachableException extends RuntimeException {
    }
}

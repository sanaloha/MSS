package com.ms.project.orderservice.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("product-service")
@RibbonClient("product-service")
public interface ProductClient {

    @GetMapping
    public ResponseEntity<Boolean> isProductInInventory(@RequestParam("id") int id);
}

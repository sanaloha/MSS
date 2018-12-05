package com.ms.project.productservice.controller;

import com.ms.project.productservice.model.Product;
import com.ms.project.productservice.model.ProductRequest;
import com.ms.project.productservice.repository.ProductRepository;
import com.ms.project.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    ProductService productService;

   @PostMapping
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity saveProduct(@RequestBody ProductRequest productRequest){
        boolean saved = productService.save(productRequest);
        if(saved)
            return ResponseEntity.status(HttpStatus.CREATED).build();
        else
            throw new ProductNotCreatedException();
    }

    @GetMapping
    ResponseEntity<Boolean> isProductInventory(@RequestParam int id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.existsById(id));

    }

    public static class  ProductNotCreatedException extends RuntimeException{

    }
}

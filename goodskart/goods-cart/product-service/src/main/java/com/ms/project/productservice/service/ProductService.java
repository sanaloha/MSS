package com.ms.project.productservice.service;

import com.ms.project.productservice.model.Product;
import com.ms.project.productservice.model.ProductRequest;
import com.ms.project.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public boolean save(ProductRequest productRequest){
        //TODO: Change ProductRequest into Product
        Product tobeSavedProduct = new ProductMapper().map(productRequest);
        Product saved = productRepository.save(tobeSavedProduct);
        return saved !=null;
    }

    public boolean existsById(int id){
        return productRepository.existsById(id);
    }

    private class ProductMapper{
        public Product map(ProductRequest productRequest){
            return Product.builder().id(productRequest.getId())
                    .name(productRequest.getName())
                    .description(productRequest.getDescription()).build();


        }
    }
}

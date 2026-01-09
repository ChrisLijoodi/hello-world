package com.chris.hello.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();
    Product getProduct(String name);
    void createProduct(Product newProduct);

}

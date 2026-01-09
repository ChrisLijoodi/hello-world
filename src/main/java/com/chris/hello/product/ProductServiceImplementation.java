package com.chris.hello.product;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImplementation implements ProductService{
    private final ProductsRepository repository;

    public ProductServiceImplementation(ProductsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Products> foundProduct = repository.findAll();
        List<Product> result = foundProduct.stream()
                .map(p -> new Product(
                        p.getName(),
                        p.getDescription()
                )).toList();

        return result;
    }

    @Override
    public Product getProduct(String name) {
        Products foundProduct = repository.findByName(name);
        return new Product(foundProduct.getName(), foundProduct.getDescription());
    }

    @Override
    public void createProduct(Product newProduct) {
        Products newProducts = Products.builder()
                .name(newProduct.name())
                .description(newProduct.description())
                .build();
        repository.save(newProducts);
    }
}

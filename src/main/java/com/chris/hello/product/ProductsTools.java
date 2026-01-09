package com.chris.hello.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductsTools {
    private static final Logger log = LoggerFactory.getLogger(ProductsTools.class);
    private final ProductService productService;

    public ProductsTools(ProductService productService) {
        this.productService = productService;
    }

    @McpTool(name = "products", description = "various insurance products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @McpTool(name = "product", description = "an insurance product")
    public Product getProduct(@McpToolParam(description = "the name of the product")
                                    String name) {
        return productService.getProduct(name);
    }

    @McpTool(name = "create product", description = "creates a new insurance product")
    public String createProduct(@McpToolParam(description = "record of product")
                              Product newProduct) {
        productService.createProduct(newProduct);

        return """
                A new product has been created!!!
                """;
    }

}

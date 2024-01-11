package net.javaguides.service;

import java.util.List;

import net.javaguides.entity.Product;

public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}

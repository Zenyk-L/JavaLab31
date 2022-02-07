package com.epam.project.spring.repository;

import com.epam.project.spring.model.Product;

import java.util.List;

public interface ProductRepository {

    Product getProduct(Integer id);

    List<Product> listProduct();

    Product createProduct(Product productDto);

    Product updateProduct(Integer id, Product productDto);

    void deleteProduct(Integer id);

}

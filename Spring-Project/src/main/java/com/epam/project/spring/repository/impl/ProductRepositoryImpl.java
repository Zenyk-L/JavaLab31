package com.epam.project.spring.repository.impl;

import com.epam.project.spring.model.Product;
import com.epam.project.spring.repository.ProductRepository;
import com.epam.project.spring.service.exeption.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> listProduct = new ArrayList<>();

    private static int idCount = 1;

    @Override
    public Product getProduct(Integer id) {
        return listProduct.stream()
                .filter(product -> product.getId()
                        .equals(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Product", String.valueOf(id)));
    }

    @Override
    public List<Product> listProduct() {
        return listProduct;
    }

    @Override
    public Product createProduct(Product product) {
        product.setId(idCount++);
        listProduct.add(product);
        return product;
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        return listProduct.stream()
                .filter(p -> p.getId()
                        .equals(id))
                .findFirst()
                .map(p -> {
                    listProduct.remove(p);
                    product.setId(id);
                    listProduct.add(product);
                    return product;
                })
                .orElseThrow(() -> new EntityNotFoundException("Product", String.valueOf(id)));
    }

    @Override
    public void deleteProduct(Integer id) {
        listProduct.removeIf(product -> product.getId()
                .equals(id));
    }

}

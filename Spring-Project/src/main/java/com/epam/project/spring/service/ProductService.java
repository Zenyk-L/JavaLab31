package com.epam.project.spring.service;

import com.epam.project.spring.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getProduct(Integer id);

    List<ProductDto> listProduct();

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(Integer id, ProductDto productDto);

    void deleteProduct(Integer id);
}

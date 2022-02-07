package com.epam.project.spring.service.impl;

import com.epam.project.spring.dto.ProductDto;
import com.epam.project.spring.mapper.ProductMapper;
import com.epam.project.spring.model.Product;
import com.epam.project.spring.repository.ProductRepository;
import com.epam.project.spring.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public ProductDto getProduct(Integer id) {
        log.info("Get product with id {}", id);
        Product product = productRepository.getProduct(id);
        return ProductMapper.INSTANCE.productToProductDto(product);
    }

    @Override
    public List<ProductDto> listProduct() {
        log.info("Get All products");
        return productRepository.listProduct().stream().map(product -> ProductMapper.INSTANCE.productToProductDto(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.INSTANCE.productDtoToProduct(productDto);
        product = productRepository.createProduct(product);
        log.info("Create product with id {}", product.getId());
        return ProductMapper.INSTANCE.productToProductDto(product);
    }

    @Override
    public ProductDto updateProduct(Integer id, ProductDto productDto) {
        log.info("Update product with id {}", id);
        Product product = ProductMapper.INSTANCE.productDtoToProduct(productDto);
        product = productRepository.updateProduct(id, product);
        product.setId(id);
        return ProductMapper.INSTANCE.productToProductDto(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        log.info("Delete product with id {}", id);
        productRepository.deleteProduct(id);
    }
}

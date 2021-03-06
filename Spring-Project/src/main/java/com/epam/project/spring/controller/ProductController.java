package com.epam.project.spring.controller;

import com.epam.project.spring.dto.ProductDto;
import com.epam.project.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ProductDto> getAllProduct() {
        return productService.listProduct();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

}

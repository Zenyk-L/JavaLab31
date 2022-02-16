package com.epam.project.spring.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ProductDto {

    private Integer id;

    private String name;

    private String image;

    private String category;

    private Integer quantity;

    private String description;

    private String color;

    private String scale;

    private Double price;

    private Date addingDate;

    private boolean deleted;
}

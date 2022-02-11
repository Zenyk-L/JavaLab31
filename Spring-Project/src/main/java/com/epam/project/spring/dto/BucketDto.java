package com.epam.project.spring.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BucketDto {

    private Integer id;

    private Integer userId;

    private Integer productId;

    private Integer quantity;

    private Date purchaseDate;

    private boolean deleted;

    private String status;

}

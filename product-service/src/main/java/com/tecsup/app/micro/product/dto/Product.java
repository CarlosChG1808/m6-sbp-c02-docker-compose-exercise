package com.tecsup.app.micro.product.dto;

import com.tecsup.app.micro.product.client.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String category;
    //private Long createdBy;

    //Para que me figure los datos del usuario qye ingreso el producto
    private User createdbyUser;
}

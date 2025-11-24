package com.Inventory.Management.System.demo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    @NotBlank(message = "Product name must not be empty")
    private String productName;

    @NotBlank(message = "Category must not be empty")
    private String category;

    @Positive(message = "Price must be greater than zero")
    private Double price;

    @PositiveOrZero(message = "Quantity cannot be negative")
    private Integer availableQuantity;

    private Date createdDate;
    private Date updatedDate;
    private Boolean activeStatus;

}

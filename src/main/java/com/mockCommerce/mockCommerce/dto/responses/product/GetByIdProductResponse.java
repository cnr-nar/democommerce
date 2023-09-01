package com.mockCommerce.mockCommerce.dto.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdProductResponse {
    private int productId;

    private String productName;

    private double productPrice;

    private String productDesc;
}

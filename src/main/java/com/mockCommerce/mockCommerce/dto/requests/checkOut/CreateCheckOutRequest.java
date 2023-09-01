package com.mockCommerce.mockCommerce.dto.requests.checkOut;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCheckOutRequest {
    private int productId;
    private int userId;
    private int checkoutQuantity;
    private double checkoutPrice;
}

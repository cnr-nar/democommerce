package com.mockCommerce.mockCommerce.dto.responses.checkOut;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCheckOut {
    private int productId;
    private int userId;
    private int checkoutQuantity;
    private double checkoutPrice;
    private Date checkoutDate;
}

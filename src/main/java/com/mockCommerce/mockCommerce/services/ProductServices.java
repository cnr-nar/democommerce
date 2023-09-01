package com.mockCommerce.mockCommerce.services;

import com.mockCommerce.mockCommerce.dto.responses.product.GetAllProductResponse;
import com.mockCommerce.mockCommerce.dto.responses.product.GetByIdProductResponse;

import java.util.List;

public interface ProductServices {
    List<GetAllProductResponse> getAll();
    GetByIdProductResponse getById(int productId);

}

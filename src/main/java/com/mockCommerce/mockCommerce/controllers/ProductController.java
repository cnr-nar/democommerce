package com.mockCommerce.mockCommerce.controllers;

import com.mockCommerce.mockCommerce.services.ProductServices;
import com.mockCommerce.mockCommerce.dto.responses.product.GetAllProductResponse;
import com.mockCommerce.mockCommerce.dto.responses.product.GetByIdProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductController {
    private ProductServices productServices;

    @GetMapping()
    public List<GetAllProductResponse> getAll() {
        return productServices.getAll();
    }

    @GetMapping("/{productId}")
    public GetByIdProductResponse getById(@PathVariable int productId){
        return productServices.getById(productId);
    }
}

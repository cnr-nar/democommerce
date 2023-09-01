package com.mockCommerce.mockCommerce.services.managers;

import com.mockCommerce.mockCommerce.util.mappers.product.ProductMapperService;
import com.mockCommerce.mockCommerce.repository.ProductRepository;
import com.mockCommerce.mockCommerce.entites.Product;
import com.mockCommerce.mockCommerce.services.ProductServices;
import com.mockCommerce.mockCommerce.dto.responses.product.GetAllProductResponse;
import com.mockCommerce.mockCommerce.dto.responses.product.GetByIdProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductManager implements ProductServices {

    private ProductRepository productRepository;
    private ProductMapperService productMapperService;

    @Override
    public List<GetAllProductResponse> getAll() {
        List<Product> products = productRepository.findAll();
        List<GetAllProductResponse> productResponses = products.stream().
                map(product -> this.productMapperService.forResponse().map(product, GetAllProductResponse.class))
                .collect(Collectors.toList());

        return  productResponses;
    }

    @Override
    public GetByIdProductResponse getById(int productId) {

        Product product =this.productRepository.findById(productId).orElseThrow();
        GetByIdProductResponse response = this.productMapperService.forResponse().map(product, GetByIdProductResponse.class);

        return response;
    }
}

package com.mockCommerce.mockCommerce.util.mappers.product;

import org.modelmapper.ModelMapper;

public interface ProductMapperService {

    ModelMapper forResponse();
    ModelMapper forRequest();
}

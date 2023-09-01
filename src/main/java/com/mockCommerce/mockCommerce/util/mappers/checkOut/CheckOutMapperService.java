package com.mockCommerce.mockCommerce.util.mappers.checkOut;

import org.modelmapper.ModelMapper;

public interface CheckOutMapperService {

    ModelMapper forResponse();
    ModelMapper forRequest();
}

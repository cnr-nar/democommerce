package com.mockCommerce.mockCommerce.util.mappers.user;

import org.modelmapper.ModelMapper;

public interface UserMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}

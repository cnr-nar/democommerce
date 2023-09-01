package com.mockCommerce.mockCommerce.services;

import com.mockCommerce.mockCommerce.dto.requests.checkOut.CreateCheckOutRequest;
import com.mockCommerce.mockCommerce.dto.responses.checkOut.GetAllCheckOut;

import java.util.List;

public interface CheckOutServices {

    List<GetAllCheckOut> getAll();
    void add(CreateCheckOutRequest createCheckOutRequest);



}

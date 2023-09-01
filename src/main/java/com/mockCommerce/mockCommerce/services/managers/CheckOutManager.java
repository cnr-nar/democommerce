package com.mockCommerce.mockCommerce.services.managers;

import com.mockCommerce.mockCommerce.util.mappers.checkOut.CheckOutMapperService;
import com.mockCommerce.mockCommerce.repository.CheckOutRepository;
import com.mockCommerce.mockCommerce.entites.CheckOut;
import com.mockCommerce.mockCommerce.services.CheckOutServices;
import com.mockCommerce.mockCommerce.dto.requests.checkOut.CreateCheckOutRequest;
import com.mockCommerce.mockCommerce.dto.responses.checkOut.GetAllCheckOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CheckOutManager implements CheckOutServices {

    private CheckOutRepository checkOutRepository;
    private CheckOutMapperService checkOutMapperService;
    @Override
    public List<GetAllCheckOut> getAll() {
        List<CheckOut> checkOuts = checkOutRepository.findAll();
        return checkOuts.stream()
                .map(checkOut -> this.checkOutMapperService.forResponse().map(checkOut, GetAllCheckOut.class))
                .toList();
    }

    @Override
    public void add(CreateCheckOutRequest createCheckOutRequest) {
        CheckOut checkOut = this.checkOutMapperService.forRequest().map(createCheckOutRequest, CheckOut.class);
         this.checkOutRepository.save(checkOut);
    }
}

package com.mockCommerce.mockCommerce.controllers;

import com.mockCommerce.mockCommerce.services.CheckOutServices;
import com.mockCommerce.mockCommerce.dto.requests.checkOut.CreateCheckOutRequest;
import com.mockCommerce.mockCommerce.dto.responses.checkOut.GetAllCheckOut;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/checkout")
@AllArgsConstructor
public class CheckOutController {
    private CheckOutServices checkOutServices;

    @GetMapping()
    public List<GetAllCheckOut> getAll(){
        return checkOutServices.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addCheckout(@RequestBody CreateCheckOutRequest createCheckOutRequest){
        this.checkOutServices.add(createCheckOutRequest);
    }
}

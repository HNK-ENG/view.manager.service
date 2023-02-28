package com.example.view.manager.service.controller.customerprofilemanagement;

import com.example.view.manager.service.dto.common.AdaptorResponse;
import com.example.view.manager.service.repository.model.CustomerDetails;
import com.example.view.manager.service.serviceinterface.CustomerServiceInterface;
import com.example.view.manager.service.util.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/vms/customer")
public class CustomerDetailsController {

    @Autowired
    CustomerServiceInterface customerServiceInterface;

    @GetMapping("/{customerId}")
    ResponseEntity<AdaptorResponse<CustomerDetails>> getCustomer(@PathVariable String customerId, HttpServletRequest httpServletRequest) throws BaseException, BaseException {
        AdaptorResponse<CustomerDetails> adaptorResponse = customerServiceInterface.getCustomer(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(adaptorResponse);
    }









}

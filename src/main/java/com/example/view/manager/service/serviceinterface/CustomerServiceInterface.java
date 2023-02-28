package com.example.view.manager.service.serviceinterface;


import com.example.view.manager.service.dto.common.AdaptorResponse;
import com.example.view.manager.service.repository.model.CustomerDetails;
import com.example.view.manager.service.util.exception.BaseException;

public interface CustomerServiceInterface {
    AdaptorResponse<CustomerDetails> getCustomer(String customerId)  throws BaseException;
}

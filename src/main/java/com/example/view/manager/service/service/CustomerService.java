package com.example.view.manager.service.service;



import com.example.view.manager.service.dto.common.AdaptorResponse;
import com.example.view.manager.service.dto.common.Result;
import com.example.view.manager.service.repository.CustomerDetailsRepository;
import com.example.view.manager.service.repository.model.CustomerDetails;
import com.example.view.manager.service.serviceinterface.CustomerServiceInterface;
import com.example.view.manager.service.util.constants.Constants;
import com.example.view.manager.service.util.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements CustomerServiceInterface {

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;


    @Override
    public AdaptorResponse<CustomerDetails> getCustomer(String customerId) throws BaseException {
        try{
            Optional<CustomerDetails> customerDetailsOptional = customerDetailsRepository.findById(Long.valueOf(customerId));
            if(!customerDetailsOptional.isPresent())
                throw new BaseException(Constants.CUSTOMER_ID_NOT_FOUND, Constants.CUSTOMER_ID_NOT_FOUND, HttpStatus.NOT_FOUND, Constants.CLIENT_ERROR_CODE, null);
            Result result = Result.builder().resultCode(Constants.SUCCESS_CODE).resultDescription(Constants.SUCCESS_DESCRIPTION).build();
            return AdaptorResponse.<CustomerDetails>builder().data(customerDetailsOptional.get()).result(result).build();

        }catch (BaseException ex){
            throw new BaseException(ex.getMessage(), ex.getMessage(), ex.getHttpStatus(), ex.getResultCode(), ex.getStackTraceElement());

        }catch (Exception ex){
            throw new BaseException(ex.getMessage(), Constants.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR, Constants.INTERNAL_SERVER_ERROR_CODE, null);
        }
    }
}

package com.example.view.manager.service.service;


import com.example.view.manager.service.dto.common.AdaptorResponse;
import com.example.view.manager.service.dto.common.Result;
import com.example.view.manager.service.dto.customer.OrderDetailsPage;
import com.example.view.manager.service.dto.customer.ViewCustomerOrderHistoryResponse;
import com.example.view.manager.service.repository.CustomerDetailsRepository;
import com.example.view.manager.service.repository.OrderDetailsRepository;
import com.example.view.manager.service.repository.model.CustomerDetails;
import com.example.view.manager.service.repository.model.OrderDetails;
import com.example.view.manager.service.serviceinterface.SalesOrderInterface;
import com.example.view.manager.service.util.constants.Constants;
import com.example.view.manager.service.util.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderService implements SalesOrderInterface {
    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;
    @Override
    public AdaptorResponse<ViewCustomerOrderHistoryResponse> viewHistory(int pageNumber, int itemsPerPage, String customerId, String status) throws BaseException {
        try{
            String customerId_ = null;
            String status_ = null;
            if(customerId!=null) {
                List<CustomerDetails> customerDetails = customerDetailsRepository.selectByUserId(Long.valueOf(customerId));
                customerId_ = String.valueOf(customerDetails.get(0).getId());

            }

            if(!status.equalsIgnoreCase(Constants.ALL)) status_ = status;


            int pageNumber_ = pageNumber != 0 ? pageNumber-1 : 0;
            List<OrderDetailsPage> orderDetailsPageList = orderDetailsRepository.findByCustomerId(customerId_, pageNumber_, itemsPerPage, status_);




            ViewCustomerOrderHistoryResponse viewCustomerOrderHistoryResponse = new ViewCustomerOrderHistoryResponse();
            viewCustomerOrderHistoryResponse.setData(orderDetailsPageList);
            viewCustomerOrderHistoryResponse.setPageNumber(pageNumber);
            viewCustomerOrderHistoryResponse.setItemsPerPage(itemsPerPage);
            viewCustomerOrderHistoryResponse.setTotalRecords(orderDetailsPageList!=null && !orderDetailsPageList.isEmpty() ? orderDetailsPageList.get(0).getTotalRecord() : 0);

            Result result = Result.builder().resultCode(Constants.SUCCESS_CODE).resultDescription(Constants.SUCCESS_DESCRIPTION).build();
            return AdaptorResponse.<ViewCustomerOrderHistoryResponse>builder().data(viewCustomerOrderHistoryResponse).result(result).build();

        } catch (Exception ex){
            throw new BaseException(ex.getMessage(), Constants.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR, Constants.INTERNAL_SERVER_ERROR_CODE, null);
        }
    }


}

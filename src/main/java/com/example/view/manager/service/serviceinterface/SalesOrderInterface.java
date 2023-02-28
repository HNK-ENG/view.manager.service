package com.example.view.manager.service.serviceinterface;


import com.example.view.manager.service.dto.common.AdaptorResponse;
import com.example.view.manager.service.dto.customer.ViewCustomerOrderHistoryResponse;
import com.example.view.manager.service.util.exception.BaseException;

public interface SalesOrderInterface {

    AdaptorResponse<ViewCustomerOrderHistoryResponse> viewHistory(int pageNumber, int itemsPerPage, String customerId, String status) throws BaseException;
}

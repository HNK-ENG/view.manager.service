package com.example.view.manager.service.controller.salesordermanagement;


import com.example.view.manager.service.dto.common.AdaptorResponse;
import com.example.view.manager.service.dto.customer.ViewCustomerOrderHistoryResponse;
import com.example.view.manager.service.serviceinterface.SalesOrderInterface;
import com.example.view.manager.service.util.constants.Constants;
import com.example.view.manager.service.util.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/vms/sales-order")
public class SalesOrderController {


    @Autowired
    SalesOrderInterface salesOrderInterface;

    @GetMapping("/order-history")
    ResponseEntity<AdaptorResponse<ViewCustomerOrderHistoryResponse>> viewHistory(@RequestParam(name = Constants.PAGE_NUMBER) int pageNumber, @RequestParam(name = Constants.ITEMS_PER_PAGE) int itemsPerPage, @RequestParam(name = Constants.CUSTOMER_ID, required = false) String customerId, @RequestParam(name = Constants.STATUS) String status, HttpServletRequest httpServletRequest) throws BaseException, BaseException {
        AdaptorResponse<ViewCustomerOrderHistoryResponse> adaptorResponse = salesOrderInterface.viewHistory(pageNumber, itemsPerPage, customerId, status);
        return ResponseEntity.status(HttpStatus.OK).body(adaptorResponse);
    }



}

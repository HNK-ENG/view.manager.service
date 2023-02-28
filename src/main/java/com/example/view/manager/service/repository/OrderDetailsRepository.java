package com.example.view.manager.service.repository;


import com.example.view.manager.service.dto.customer.OrderDetailsPage;
import com.example.view.manager.service.repository.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long>, JpaSpecificationExecutor<OrderDetails> {


    @Query(nativeQuery = true, name = "searchSalesOrder")
    List<OrderDetailsPage> findByCustomerId(String customerId, int offset, int limit, String status);
}


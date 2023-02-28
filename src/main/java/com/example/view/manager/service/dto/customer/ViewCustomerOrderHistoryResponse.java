package com.example.view.manager.service.dto.customer;


import com.example.view.manager.service.repository.model.OrderDetails;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ViewCustomerOrderHistoryResponse {
    public int pageNumber;
    public int itemsPerPage;
    public Long totalRecords;
    public List<OrderDetailsPage> data;
}

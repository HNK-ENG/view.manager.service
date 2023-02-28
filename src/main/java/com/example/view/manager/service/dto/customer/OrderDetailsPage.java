package com.example.view.manager.service.dto.customer;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsPage {
    private Long totalRecord;
    private String orderId;
    private String status;
    private String customerId;
    private String itemName;
    private String quantity;
    private String totalCost;
    private String createdDatetime;
}

package com.example.view.manager.service.repository.model;


import com.example.view.manager.service.dto.customer.OrderDetailsPage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "order_details")
@NamedNativeQuery(
        name = "searchSalesOrder",
        resultSetMapping = "searchSalesOrderMapping",
        query = "select\n" +
                "\tcount(*) over() as totalRecords,\n" +
                "\tod.order_id as orderId,\n" +
                "\tod.status as status,\n" +
                "\tod.customer_id as customerId,\n" +
                "\tod.item_name as itemName,\n" +
                "\tod.quantity as quantity,\n" +
                "\tod.total_cost as totalCost,\n" +
                "\tod.created_datetime as createdDatetime\n" +
                "from\n" +
                "\tpublic.order_details od\n" +
                "where (od.customer_id = :customerId or :customerId is null) and (od.status = :status or :status is null) order by createdDatetime desc limit :limit offset :offset"

        )
@SqlResultSetMapping(
        name = "searchSalesOrderMapping",
        classes = {
                @ConstructorResult(
                        targetClass = OrderDetailsPage.class,
                        columns = {
                                @ColumnResult(name = "totalRecords", type = Long.class),
                                @ColumnResult(name = "orderId", type = String.class),
                                @ColumnResult(name = "status"),
                                @ColumnResult(name = "customerId"),
                                @ColumnResult(name = "itemName"),
                                @ColumnResult(name = "quantity"),
                                @ColumnResult(name = "totalCost"),
                                @ColumnResult(name = "createdDatetime", type = String.class)

                        })
        }

)
public class OrderDetails {
    @Id
    @SequenceGenerator(name="pk_sequence", sequenceName="entity_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator="pk_sequence")
    @Column(name = "order_id")
    private Long id;

    private String customerId;

    private String item_name;

    private String quantity;

    private String totalCost;

    private String status;

    @CreationTimestamp
    private Timestamp createdDatetime;

}

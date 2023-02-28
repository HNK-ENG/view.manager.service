package com.example.view.manager.service.repository.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "items_details")
public class ItemDetails {
    @Id
    @SequenceGenerator(name="pk_sequence_2", sequenceName="entity_id_seq_2", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator="pk_sequence_2")
    @Column(name = "item_id")
    private Long id;

    @Column(name="item_name",columnDefinition = "VARCHAR(225)")
    private String itemName;

    private Long itemsPerCost;
}

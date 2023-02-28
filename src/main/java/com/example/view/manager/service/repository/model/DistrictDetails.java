package com.example.view.manager.service.repository.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "district_details")
public class DistrictDetails {

    @Id
    @SequenceGenerator(name="pk_sequence_3", sequenceName="entity_id_seq_3", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator="pk_sequence_3")
    @Column(name = "district_id")
    private Long id;

    private String districtName;



}

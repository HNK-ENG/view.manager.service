package com.example.view.manager.service.repository.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "city_details")
public class CityDetails {
    @Id
    @SequenceGenerator(name="pk_sequence_4", sequenceName="entity_id_seq_4", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator="pk_sequence_4")
    @Column(name = "city_id")
    private Long id;

    private String cityName;

    private Long districtId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "district_super_id", referencedColumnName = "district_id")
    private DistrictDetails district;
}

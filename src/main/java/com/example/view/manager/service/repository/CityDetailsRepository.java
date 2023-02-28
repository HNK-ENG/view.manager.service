package com.example.view.manager.service.repository;


import com.example.view.manager.service.repository.model.CityDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityDetailsRepository extends JpaRepository<CityDetails, Long> {

    @Query(nativeQuery = true, value = "select * from city_details cd where cd.district_id = :districtId")
    List<CityDetails> findByDistrictId(Long districtId);
}

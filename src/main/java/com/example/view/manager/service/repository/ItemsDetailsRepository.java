package com.example.view.manager.service.repository;


import com.example.view.manager.service.repository.model.ItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsDetailsRepository extends JpaRepository<ItemDetails, Long> {
}

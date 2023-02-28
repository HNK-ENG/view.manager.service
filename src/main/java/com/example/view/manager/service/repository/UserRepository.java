package com.example.view.manager.service.repository;

import com.example.view.manager.service.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "select * from user_login ul where ul.user_name = :userName")
    List<User> findByName(String userName);
}

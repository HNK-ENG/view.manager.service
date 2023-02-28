package com.example.view.manager.service.repository.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;


@Getter
@Setter
@ToString
@Entity
@Table(name = "user_login")
public class User {
    @Id
    @SequenceGenerator(name="pk_sequence", sequenceName="entity_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator="pk_sequence")
    private Long id;

    private String userName;

    private String password;

    private String role;

}


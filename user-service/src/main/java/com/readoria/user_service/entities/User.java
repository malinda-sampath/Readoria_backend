package com.readoria.user_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String id;

    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
}

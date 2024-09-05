package com.thl.ToDo.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table( name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    @ManyToMany
    private Set<Role> roles = new HashSet<>();
    public User(String username, String email , String password) {
        this.username = username;
        this.email = email;
    this.password = password;

    }
}
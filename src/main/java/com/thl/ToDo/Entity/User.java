package com.thl.ToDo.Entity;

import java.util.HashSet;
import java.util.Set;

import com.thl.ToDo.Enums.ERole;
import jakarta.persistence.*;
import lombok.*;


@Table( name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String lastName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private ERole role;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String encode) {
    }
}
package com.thl.ToDo.Request;

import jakarta.persistence.Entity;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginResponse {

    private String jwt;
    private String username;
    private String email;
}

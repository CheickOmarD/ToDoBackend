package com.thl.ToDo.Request;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginRequest {

    private String email;
    private String username;
    private String password;
}

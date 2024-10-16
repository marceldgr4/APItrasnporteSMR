package com.iOS.TranporteApp.Dto;

import lombok.*;


import java.sql.Timestamp;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id_user;
    private String fullname;
    private String email;
    private String password;
    private int phone;
    private String Rol;
    private Timestamp created_at;

}

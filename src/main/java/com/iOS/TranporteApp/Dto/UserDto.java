package com.iOS.TranporteApp.Dto;

import lombok.*;


import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id_User;
    private String full_name;
    private String email;
    private String password;
    private String phone;
    private String Rol;
    private Timestamp created_at;

}

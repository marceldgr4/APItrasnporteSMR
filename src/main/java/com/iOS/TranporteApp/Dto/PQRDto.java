package com.iOS.TranporteApp.Dto;

import lombok.*;

import java.time.LocalDateTime;
@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PQRDto {
    private Long id_pqr;
    private Long id_user;
    private String Comments;
    private LocalDateTime Data_Register;
}

package com.iOS.TranporteApp.Dto;

import com.iOS.TranporteApp.Emun.Shift;
import lombok.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConductorDto {
    private Long id_conductor;
    private String Code;
    private String full_name;
    private String phone;
    private Shift shift;
}

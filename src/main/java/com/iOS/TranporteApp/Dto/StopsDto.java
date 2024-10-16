package com.iOS.TranporteApp.Dto;

import lombok.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StopsDto {
    private Long id_stop;
    private Long id_ruta;
    private String stop_name;
    private String Location;
}

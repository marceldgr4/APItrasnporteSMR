package com.iOS.TranporteApp.Dto;

import lombok.*;

import java.sql.Time;
@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RutaDto {
    private Long id_ruta;
    private String route_name;
    private String route_origen;
    private String route_destination;
    private String route_type;
    private String route_status;
    private Time Start_Time;
    private Time End_Time;
}

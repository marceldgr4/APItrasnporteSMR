package com.iOS.TranporteApp.Dto;

import lombok.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StopsDto {
    private Long id_Stop;
    private String stop_name;
    private String Location;
}

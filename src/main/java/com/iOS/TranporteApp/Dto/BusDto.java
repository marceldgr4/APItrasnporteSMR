package com.iOS.TranporteApp.Dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusDto {
    private Long id_Bus;
    private String plate;
    private String status;
    private String type;
    private String model;
    private Integer Capacity;
    private String Brand;
}

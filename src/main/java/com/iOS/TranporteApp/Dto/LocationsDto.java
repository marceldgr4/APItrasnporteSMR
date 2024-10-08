package com.iOS.TranporteApp.Dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationsDto {
    private Long id_Location;
    private String name_Location;
    private String address;

}

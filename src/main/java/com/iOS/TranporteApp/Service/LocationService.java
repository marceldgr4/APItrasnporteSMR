package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.LocationsDto;

import java.util.List;

public interface LocationService {
    LocationsDto createLocation(LocationsDto locationsDto);
    LocationsDto updateLocation(Long id_Location,LocationsDto locationsDto);
    void  deleteLocation(Long id_Location);
    LocationsDto getLocationById(Long id_Location);
    List<LocationsDto> getAllLocation();
    List<LocationsDto> getLocationByName(String name_Location);
}

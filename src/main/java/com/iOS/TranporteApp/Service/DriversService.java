package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.ConductorDto;

import java.util.List;

public interface DriversService {
    ConductorDto createDriver(ConductorDto conductorDto);
    ConductorDto updateDriver(Long id_Driver, ConductorDto conductorDto);
    ConductorDto getDriverById(Long id_Driver);
    List<ConductorDto> getAllDrivers();
    void deleteDriver(Long id_drivers);


}

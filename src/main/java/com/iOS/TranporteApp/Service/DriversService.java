package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.DriverDto;

import java.util.List;

public interface DriversService {
    DriverDto createDriver(DriverDto driverDto);
    DriverDto updateDriver(Long id_Driver,DriverDto driverDto);
    DriverDto getDriverById(Long id_Driver);
    List<DriverDto> getAllDrivers();
    void deleteDriver(Long id_drivers);


}

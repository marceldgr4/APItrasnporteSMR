package com.iOS.TranporteApp.Impl;

import com.iOS.TranporteApp.Dto.DriverDto;
import com.iOS.TranporteApp.Entity.Drivers;
import com.iOS.TranporteApp.Repository.DriverRepository;
import com.iOS.TranporteApp.Service.DriversService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;



@Service
public class DriverServiceImpl implements DriversService {
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DriverDto createDriver(DriverDto driverDto) {
        Drivers driver = modelMapper.map(driverDto, Drivers.class);
        Drivers driverSaved = driverRepository.save(driver);
        return modelMapper.map(driverSaved, DriverDto.class);
    }
    @Override
    public DriverDto updateDriver(Long id_Drivers, DriverDto driverDto) {
        Drivers driver = driverRepository.findById(id_Drivers)
                .orElseThrow(()-> new RuntimeException("driver not found"));
        driver.setId_Driver(driverDto.getId_Driver());
        driver.setCode(driverDto.getCode());
        Drivers updatedDriver = driverRepository.save(driver);
        return modelMapper.map(updatedDriver, DriverDto.class);
    }
    @Override
    public void deleteDriver(Long id_Driver){
        driverRepository.deleteById(id_Driver);
    }
    @Override
    public List<DriverDto> getAllDrivers() {
        List<Drivers> drivers = driverRepository.findAll();
        return drivers.stream().map(driver->modelMapper.map(driver,DriverDto.class))
        .collect(Collectors.toList());
    }
    @Override
    public DriverDto getDriverById(Long id_Driver) {
        Drivers drivers = driverRepository.findById(id_Driver)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
        return modelMapper.map(drivers,DriverDto.class);
    }

}

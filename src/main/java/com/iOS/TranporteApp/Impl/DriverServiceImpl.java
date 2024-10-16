package com.iOS.TranporteApp.Impl;

import com.iOS.TranporteApp.Dto.ConductorDto;
import com.iOS.TranporteApp.Entity.Conductor;
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
    public ConductorDto createDriver(ConductorDto conductorDto) {
        Conductor driver = modelMapper.map(conductorDto, Conductor.class);
        Conductor driverSaved = driverRepository.save(driver);
        return modelMapper.map(driverSaved, ConductorDto.class);
    }
    @Override
    public ConductorDto updateDriver(Long id_conductor, ConductorDto conductorDto) {
        Conductor driver = driverRepository.findById(id_conductor)
                .orElseThrow(()-> new RuntimeException("driver not found"));
        driver.setId_conductor(conductorDto.getId_conductor());
        driver.setCode(conductorDto.getCode());
        Conductor updatedDriver = driverRepository.save(driver);
        return modelMapper.map(updatedDriver, ConductorDto.class);
    }
    @Override
    public void deleteDriver(Long id_Driver){
        driverRepository.deleteById(id_Driver);
    }
    @Override
    public List<ConductorDto> getAllDrivers() {
        List<Conductor> drivers = driverRepository.findAll();
        return drivers.stream().map(driver->modelMapper.map(driver, ConductorDto.class))
        .collect(Collectors.toList());
    }
    @Override
    public ConductorDto getDriverById(Long id_Driver) {
        Conductor conductor = driverRepository.findById(id_Driver)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
        return modelMapper.map(conductor, ConductorDto.class);
    }

}

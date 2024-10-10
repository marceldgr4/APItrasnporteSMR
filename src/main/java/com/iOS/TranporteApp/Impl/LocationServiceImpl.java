package com.iOS.TranporteApp.Impl;

import com.iOS.TranporteApp.Dto.LocationsDto;
import com.iOS.TranporteApp.Entity.Locations;
import com.iOS.TranporteApp.Repository.LocationRepository;
import com.iOS.TranporteApp.Service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LocationsDto createLocation(LocationsDto locationsDto) {
        Locations locations = modelMapper.map(locationsDto, Locations.class);
        locations = locationRepository.save(locations);
        return modelMapper.map(locations, LocationsDto.class);
    }
    @Override
    public void deleteLocation(Long id_location){
        locationRepository.deleteById(id_location);
    }
    @Override
    public List<LocationsDto> getAllLocation() {
        List<Locations> locations = locationRepository.findAll();
        return locations.stream().map(location -> modelMapper.
                map(location, LocationsDto.class)).collect(Collectors.toList());
    }
    @Override
    public LocationsDto getLocationById(Long id_location) {
        Locations location = locationRepository.findById(id_location).orElseThrow(()-> new RuntimeException("location not found"));
        return modelMapper.map(location, LocationsDto.class);
    }
    @Override
    public List<LocationsDto> getLocationByName(String name) {
        List<Locations> locations = locationRepository.findByName(name);
        return locations.stream().map(location -> modelMapper.map(location, LocationsDto.class)).collect(Collectors.toList());
    }
    @Override
    public LocationsDto updateLocation(Long id_location, LocationsDto locationsDto) {
        Locations locations = locationRepository.findById(id_location).orElseThrow(()-> new RuntimeException("location not found"));
        locations.setAddress(locationsDto.getAddress());
        locations.setName_Location(locationsDto.getName_Location());
        Locations updatedLocation = locationRepository.save(locations);
        return modelMapper.map(updatedLocation, LocationsDto.class);

    }
}

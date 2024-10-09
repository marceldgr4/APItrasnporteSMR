package com.iOS.TranporteApp.Impl;

import com.iOS.TranporteApp.Dto.BusDto;
import com.iOS.TranporteApp.Entity.Bus;
import com.iOS.TranporteApp.Repository.BusRepository;

import com.iOS.TranporteApp.Service.BusService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class BusServiceImpl  implements BusService {
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BusDto CreateBus(BusDto busDto){
        Bus bus = modelMapper.map(busDto,Bus.class);
        bus = busRepository.save(bus);
        return modelMapper.map(bus,BusDto.class);
    }
    @Override
    public BusDto UpdateBus(Long id_Bus, BusDto busDto){
        Bus bus = busRepository.findById(id_Bus).orElseThrow(()-> new EntityNotFoundException("Bus Not Found"));

        bus.setStatus(busDto.getStatus());
        Bus UpdatedBus = busRepository.save(bus);
        return modelMapper.map(UpdatedBus,BusDto.class);
    }

    @Override
    public List<BusDto> getAllBuses(){
        List<Bus> buses = busRepository.findAll();
        return buses.stream().map(bus-> modelMapper.map(bus,BusDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<BusDto> getBusByBus_Plate(String plate){
        List<Bus> buses= busRepository.findByBus_Plate(plate);
        return buses.stream().map(bus-> modelMapper.map(bus,BusDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public BusDto getBusById(Long id_Bus){
        Bus bus = busRepository.findById(id_Bus).orElseThrow(()-> new EntityNotFoundException("Bus Not Found"));
        return modelMapper.map(bus,BusDto.class);
    }

    @Override
    public void deleteBus(Long id_Bus){
        busRepository.deleteById(id_Bus);
    }

}

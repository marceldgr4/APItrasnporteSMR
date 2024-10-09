package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.BusDto;

import com.iOS.TranporteApp.Entity.Bus;
import com.iOS.TranporteApp.Repository.BusRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusServcice {
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private ModelMapper modelMapper;

     public List<BusDto> getAllBus(){
         List<Bus> buses = busRepository.findAll();
         return buses.stream().map(bus-> modelMapper.map(bus,BusDto.class))
                 .collect(Collectors.toList());
     }
     public BusDto getBusById(Long id_Bus){
         Bus bus = busRepository.findById(id_Bus).orElseThrow(()-> new EntityNotFoundException("Bus Not Found"));
         return modelMapper.map(bus,BusDto.class);
     }
     public BusDto createBus(BusDto busDto){
         Bus bus = modelMapper.map(busDto,Bus.class);
         Bus savedBus = busRepository.save(bus);
         return modelMapper.map(savedBus,BusDto.class);
     }
     public BusDto updateBus(Long id_Bus, BusDto busDto){
         Bus bus = busRepository.findById(id_Bus).orElseThrow(()-> new EntityNotFoundException("Bus Not Found"));
         bus.setStatus(busDto.getStatus());
         Bus UpdatedBus = busRepository.save(bus);
         return modelMapper.map(UpdatedBus,BusDto.class);
     }



}

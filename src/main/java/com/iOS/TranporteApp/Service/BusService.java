package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.BusDto;
import com.iOS.TranporteApp.Entity.Bus;

import java.util.List;



public interface BusService {
    BusDto createBus(BusDto busDto);
    BusDto updateBus(Long id_Bus, BusDto busDto);
    BusDto getBusById(Long id_Bus);
    List<BusDto> getAllBuses();
    List<BusDto> getBusByPlate(String plate);


}


package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.BusDto;

import java.util.List;



public interface BusService {
    BusDto CreateBus(BusDto busDto);

    BusDto UpdateBus(Long id_Bus, BusDto busDto);

    List<BusDto> getAllBuses();

    List<BusDto> getBusByBus_Plate(String plate);

    BusDto getBusById(Long id);

    void deleteBus(Long busId);

}


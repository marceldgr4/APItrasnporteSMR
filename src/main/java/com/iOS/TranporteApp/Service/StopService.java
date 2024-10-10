package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.StopsDto;

import java.util.List;

public interface StopService {
    StopsDto createStop(StopsDto stopsDto);
    StopsDto updateStop(Long id_Stop,StopsDto stopsDto);
    void deleteStop(Long id_Stop);
    List<StopsDto> getAllStops();
    StopsDto getStopsById(Long id_Stop);


}

package com.iOS.TranporteApp.Impl;

import com.iOS.TranporteApp.Dto.StopsDto;
import com.iOS.TranporteApp.Entity.Stops;
import com.iOS.TranporteApp.Repository.StopsRepository;
import com.iOS.TranporteApp.Service.StopService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StopServiceImpl implements StopService {
    @Autowired
    private StopsRepository stopsRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StopsDto createStop(StopsDto stopsDto) {
        Stops stops = modelMapper.map(stopsDto, Stops.class);
        stopsRepository.save(stops);
        return modelMapper.map(stops, StopsDto.class);
    }
    @Override
    public StopsDto updateStop(Long id, StopsDto stopsDto) {
        Stops stops = stopsRepository.findById(id).orElseThrow(()-> new RuntimeException("Stop not found"));
        stops.setStop_name(stopsDto.getStop_name());
        stops.setLocation(stopsDto.getLocation());
        Stops updateStops = stopsRepository.save(stops);
        return modelMapper.map(updateStops, StopsDto.class);
    }
    @Override
    public List<StopsDto> getAllStops() {
        List<Stops> stops = stopsRepository.findAll();
        return stops.stream().map(stop-> modelMapper.map(stop,StopsDto.class)).collect(Collectors.toList());
    }
    @Override
    public StopsDto getStopsById(Long id_Stop) {
        Stops stops = stopsRepository.findById(id_Stop).orElseThrow(()-> new RuntimeException("Stop not found"));
        return modelMapper.map(stops, StopsDto.class);
    }
    @Override
    public void deleteStop(Long id_Stop){
        stopsRepository.deleteById(id_Stop);
    }
}

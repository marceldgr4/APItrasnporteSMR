package com.iOS.TranporteApp.Impl;

import com.iOS.TranporteApp.Dto.RutaDto;
import com.iOS.TranporteApp.Entity.Ruta;
import com.iOS.TranporteApp.Repository.RoutesRepository;
import com.iOS.TranporteApp.Service.RouteService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RoutesRepository routesRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RutaDto UpdateRoute(Long id_Ruta, RutaDto rutaDto){
        Ruta ruta = routesRepository.findById(id_Ruta).orElseThrow(()-> new EntityNotFoundException("Routes not found"));
        ruta.setEnd_Time(rutaDto.getEnd_Time());
        Ruta updatedRuta =routesRepository.save(ruta);
        return modelMapper.map(updatedRuta, RutaDto.class);
    }
    @Override
    public List<RutaDto> getAllRoute(){
        return routesRepository.findAllBy().stream().map(route->modelMapper.map(route, RutaDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public RutaDto getRouteById(Long id){
        Ruta ruta =routesRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Routes not found"));
        return modelMapper.map(ruta, RutaDto.class);
    }
    @Override
    public RutaDto CreateRoute(RutaDto rutaDto){
        Ruta ruta =modelMapper.map(rutaDto, Ruta.class);
        Ruta savedRuta =routesRepository.save(ruta);
        return modelMapper.map(savedRuta, RutaDto.class);
    }
    @Override
    public void DeleteRoute(Long id_Ruta){
        routesRepository.deleteById(id_Ruta);
    }
}

package com.iOS.TranporteApp.Impl;

import com.iOS.TranporteApp.Dto.RutaDto;
import com.iOS.TranporteApp.Entity.Ruta;
import com.iOS.TranporteApp.Repository.RutaRepository;
import com.iOS.TranporteApp.Service.RutaService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RutaServiceImpl implements RutaService {
    @Autowired
    private RutaRepository rutaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RutaDto updateRoute(Long id_Ruta, RutaDto rutaDto){
        Ruta ruta = rutaRepository.findById(id_Ruta).orElseThrow(()-> new EntityNotFoundException("Routes not found"));
        ruta.setEnd_Time(rutaDto.getEnd_Time());
        Ruta updatedRuta = rutaRepository.save(ruta);
        return modelMapper.map(updatedRuta, RutaDto.class);
    }
    @Override
    public List<RutaDto> getAllRoutes(){
        return rutaRepository.findAllBy().stream().map(route->modelMapper.map(route, RutaDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public RutaDto getRouteById(Long id){
        Ruta ruta = rutaRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Routes not found"));
        return modelMapper.map(ruta, RutaDto.class);
    }
    @Override
    public RutaDto createRoute(RutaDto rutaDto){
        Ruta ruta =modelMapper.map(rutaDto, Ruta.class);
        Ruta savedRuta = rutaRepository.save(ruta);
        return modelMapper.map(savedRuta, RutaDto.class);
    }
    @Override
    public void deleteRoute(Long id_Ruta){
        rutaRepository.deleteById(id_Ruta);
    }
}

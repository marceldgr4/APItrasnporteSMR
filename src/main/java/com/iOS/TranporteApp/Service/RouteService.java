package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.RouteDto;
import com.iOS.TranporteApp.Entity.Routes;
import com.iOS.TranporteApp.Repository.RoutesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {
    @Autowired
    private RoutesRepository routesRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<RouteDto>getAllRoute(){
        return routesRepository.findAllBy().stream().map(route->modelMapper.map(route,RouteDto.class))
                .collect(Collectors.toList());
    }
    public RouteDto getRouteById(Long id){
        Routes routes=routesRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Routes not found"));
        return modelMapper.map(routes,RouteDto.class);
    }
    public RouteDto createRoute(RouteDto routeDto){
        Routes routes=modelMapper.map(routeDto,Routes.class);
        Routes savedRoutes=routesRepository.save(routes);
        return modelMapper.map(savedRoutes,RouteDto.class);
    }
    public RouteDto updateRoute(Long id, RouteDto routeDto){
        Routes routes = routesRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Routes not found"));

        routes.setEnd_Time(routeDto.getEnd_Time());
        Routes updatedRoutes=routesRepository.save(routes);
        return modelMapper.map(updatedRoutes,RouteDto.class);
    }
    public void deleteRoute(Long id){
        routesRepository.deleteById(id);
    }
}

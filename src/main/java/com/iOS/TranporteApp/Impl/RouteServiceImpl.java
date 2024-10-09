package com.iOS.TranporteApp.Impl;

import com.iOS.TranporteApp.Dto.RouteDto;
import com.iOS.TranporteApp.Entity.Routes;
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
    public RouteDto UpdateRoute(Long id_Route, RouteDto routeDto){
        Routes routes = routesRepository.findById(id_Route).orElseThrow(()-> new EntityNotFoundException("Routes not found"));
        routes.setEnd_Time(routeDto.getEnd_Time());
        Routes UpdatedRoutes=routesRepository.save(routes);
        return modelMapper.map(UpdatedRoutes,RouteDto.class);
    }
    @Override
    public List<RouteDto> getAllRoute(){
        return routesRepository.findAllBy().stream().map(route->modelMapper.map(route,RouteDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public RouteDto getRouteById(Long id){
        Routes routes=routesRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Routes not found"));
        return modelMapper.map(routes,RouteDto.class);
    }
    @Override
    public RouteDto CreateRoute(RouteDto routeDto){
        Routes routes=modelMapper.map(routeDto,Routes.class);
        Routes savedRoutes=routesRepository.save(routes);
        return modelMapper.map(savedRoutes,RouteDto.class);
    }
    @Override
    public void DeleteRoute(Long id){
        routesRepository.deleteById(id);
    }
}

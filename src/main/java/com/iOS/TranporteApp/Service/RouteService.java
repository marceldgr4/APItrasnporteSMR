package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.RouteDto;

import java.util.List;

public interface RouteService {
    RouteDto CreateRoute(RouteDto routeDto);
    RouteDto UpdateRoute(Long id_Route,RouteDto routeDto);
    void DeleteRoute(Long id_Route);
    List<RouteDto> getAllRoute();
    RouteDto getRouteById(Long id_Route);

}

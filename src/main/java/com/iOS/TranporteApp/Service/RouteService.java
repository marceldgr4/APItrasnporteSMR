package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.RutaDto;

import java.util.List;

public interface RouteService {
    RutaDto CreateRoute(RutaDto rutaDto);
    RutaDto UpdateRoute(Long id_Ruta, RutaDto rutaDto);
    void DeleteRoute(Long id_Ruta);
    List<RutaDto> getAllRoute();
    RutaDto getRouteById(Long id_Ruta);

}

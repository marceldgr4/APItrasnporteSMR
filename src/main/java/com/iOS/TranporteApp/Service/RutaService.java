package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.RutaDto;

import java.util.List;

public interface RutaService {
    RutaDto createRoute(RutaDto rutaDto);
    RutaDto updateRoute(Long id_Ruta, RutaDto rutaDto);
    void deleteRoute(Long id_Ruta);
    List<RutaDto> getAllRoutes();
    RutaDto getRouteById(Long id_Ruta);

}

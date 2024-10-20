package com.iOS.TranporteApp.Controller;

import com.iOS.TranporteApp.Dto.RutaDto;
import com.iOS.TranporteApp.Entity.Ruta;
import com.iOS.TranporteApp.Service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Controller/Ruta")
public class RutaController {
    @Autowired
   private RutaService rutaService;

    //crear un ruta
    @PostMapping
    public ResponseEntity<RutaDto> createRuta(@RequestBody RutaDto rutaDto) {
        RutaDto newRuta = rutaService.createRoute(rutaDto);
        return new ResponseEntity<>(newRuta, HttpStatus.CREATED);
    }
    //actulizar ruta
    @PutMapping("/{id_ruta}")
    public ResponseEntity<RutaDto> updateRuta(@RequestBody RutaDto rutaDto, @PathVariable Long id_ruta) {
        RutaDto updateRuta = rutaService.updateRoute(id_ruta,rutaDto);
        return new ResponseEntity<>(updateRuta, HttpStatus.OK);
    }
    //obtener todos las rutas
    @GetMapping
    public ResponseEntity<List<RutaDto>> getAllRuta() {
        List<RutaDto> rutaDtos = rutaService.getAllRoutes();
        return new ResponseEntity<>(rutaDtos, HttpStatus.OK);
    }
    //obtener ruta por id
    @GetMapping("/{id_ruta}")
    public ResponseEntity<RutaDto> getRutaById(@PathVariable ("id_ruta") Long id_ruta) {
        RutaDto rutaDto = rutaService.getRouteById(id_ruta);
        return new ResponseEntity<>(rutaDto, HttpStatus.OK);
    }
}

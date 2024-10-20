package com.iOS.TranporteApp.Controller;

import com.iOS.TranporteApp.Dto.ConductorDto;
import com.iOS.TranporteApp.Repository.DriverRepository;
import com.iOS.TranporteApp.Service.DriversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Controller/Conductor")
public class ConductorController {
    @Autowired
    private DriversService driversService;
    //crea un conductor
    public ResponseEntity<ConductorDto> createConductor(@RequestBody ConductorDto conductorDto) {
        ConductorDto newConductorDto = driversService.createDriver(conductorDto);
        return new ResponseEntity<>(newConductorDto, HttpStatus.CREATED);
    }

    //Actualizar conductor por id
    @PutMapping("/{id_conductor})")
    public ResponseEntity<ConductorDto> updateDriver(@PathVariable ("id_conductor")Long id_conductor, ConductorDto conductorDto) {
        ConductorDto updateConductorDto = driversService.updateDriver(id_conductor, conductorDto);
        return new ResponseEntity<>(updateConductorDto, HttpStatus.OK);

    }
    // Obtener todos los conductores
    @GetMapping
    public ResponseEntity<List<ConductorDto>> getAllConductor() {
        List<ConductorDto> conductorDtos = driversService.getAllDrivers();
        return new ResponseEntity<>(conductorDtos, HttpStatus.OK);
    }
    // Eliminar conductor por id
    @DeleteMapping("/{id_conductor}")
    public ResponseEntity<ConductorDto> deleteConductor(@PathVariable("id_conductor") Long id_conductor) {
        driversService.deleteDriver(id_conductor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

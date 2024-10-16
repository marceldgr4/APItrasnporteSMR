package com.iOS.TranporteApp.Controller;


import com.iOS.TranporteApp.Dto.BusDto;

import com.iOS.TranporteApp.Service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Controller/buses")
public class BusController {
    @Autowired
    private BusService busService;

    @GetMapping
    public ResponseEntity<List<BusDto>>getAllBus(){
        List<BusDto> buses = busService.getAllBuses();
        return ResponseEntity.ok(buses);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BusDto> getBusById(@PathVariable("id") Long id_bus){
        BusDto bus = busService.getBusById(id_bus);
        return ResponseEntity.ok(bus);
    }

    @PostMapping
    public ResponseEntity<BusDto> createBus(@RequestBody BusDto bus){
        BusDto newBus= busService.createBus(bus);
        return ResponseEntity.ok(newBus);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BusDto> updateBus(@PathVariable("id") Long id_bus, @RequestBody BusDto bus){
        busService.updateBus(id_bus, bus);
        return ResponseEntity.ok(bus);
    }
}

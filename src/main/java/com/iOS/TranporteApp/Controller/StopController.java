package com.iOS.TranporteApp.Controller;


import com.iOS.TranporteApp.Dto.StopsDto;
import com.iOS.TranporteApp.Service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Contoller/Stop")
public class StopController {
    @Autowired
    private StopService stopService;

    //crear un parada
    @PostMapping
    public ResponseEntity<StopsDto> createStop(@RequestBody StopsDto stopsDto) {
        StopsDto newStopsDto = stopService.createStop(stopsDto);
        return new ResponseEntity<>(newStopsDto, HttpStatus.CREATED);
    }
    //obtener toda las paradas
    @GetMapping
    public ResponseEntity<List<StopsDto>> getAllStops() {
        List<StopsDto> stopsDtoList = stopService.getAllStops();
        return new ResponseEntity<>(stopsDtoList, HttpStatus.OK);
    }
    //obtener por id
    @GetMapping("/{id_stop}")
    public ResponseEntity<StopsDto> getStopById(@PathVariable("id_stop") Long id_stop) {
        StopsDto stopsDto = stopService.getStopsById(id_stop);
        return new ResponseEntity<>(stopsDto, HttpStatus.OK);
    }
    @PutMapping("/{id_stop}")
    public ResponseEntity<StopsDto> updateStop(@PathVariable("id_stop") Long id_stop, @RequestBody StopsDto stopsDto) {
        StopsDto newStopsDto = stopService.updateStop(id_stop, stopsDto);
        return new ResponseEntity<>(newStopsDto, HttpStatus.OK);
    }
    @DeleteMapping("/{id_stop}")
    public ResponseEntity<Void> deleteStop(@PathVariable ("id_stop") Long id_stop) {
        stopService.deleteStop(id_stop);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);

    }


}

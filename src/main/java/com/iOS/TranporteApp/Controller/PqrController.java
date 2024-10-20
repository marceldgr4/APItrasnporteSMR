package com.iOS.TranporteApp.Controller;

import com.iOS.TranporteApp.Dto.PQRDto;
import com.iOS.TranporteApp.Dto.PaymentsDto;
import com.iOS.TranporteApp.Service.PQRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Contoller/PQR")
public class PqrController {
    @Autowired
    private PQRService pqrService;

    //crear un PQR
    @PostMapping
    public ResponseEntity<PQRDto> createPQR(@RequestBody PQRDto pqrDto) {
        PQRDto newPqr = pqrService.createPQR(pqrDto);
        return new ResponseEntity<>(newPqr, HttpStatus.CREATED);

    }
    //obtener todos lo pqr
    @GetMapping
    public ResponseEntity<List<PQRDto>> getAllPQR() {
        List<PQRDto> pqrDtos = pqrService.getAllPQR();
        return new ResponseEntity<>(pqrDtos, HttpStatus.OK);
    }
    //obtener pqr por id
    @GetMapping("/{id_pqr}")
    private ResponseEntity<PQRDto> getPQRById(@PathVariable Long id_pqr) {
        PQRDto pqrDto = pqrService.getPQRById(id_pqr);
        return new ResponseEntity<>(pqrDto, HttpStatus.OK);
    }

}

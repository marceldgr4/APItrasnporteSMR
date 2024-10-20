package com.iOS.TranporteApp.Controller;

import com.iOS.TranporteApp.Dto.TransaccionDto;
import com.iOS.TranporteApp.Service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Controller/transaccion")
public class TransaccionController {
    @Autowired
    private TransaccionService transaccionService;

    @PostMapping
    public ResponseEntity<TransaccionDto> createTransaction(@RequestBody TransaccionDto transaccionDto) {
        TransaccionDto newTransaccion = transaccionService.createTransaction(transaccionDto);
        return new ResponseEntity<>(newTransaccion, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<TransaccionDto>> getAllTransactions() {
        List<TransaccionDto> transaccionDtos = transaccionService.getAllTransaction();
        return new ResponseEntity<>(transaccionDtos, HttpStatus.OK);
    }
    @GetMapping("/{id_transaction}")
    public ResponseEntity<TransaccionDto> getTransaction(@PathVariable("id_transaction") Long id_transaction) {
        TransaccionDto transaccionDto = transaccionService.getTransactionById(id_transaction);
        return new ResponseEntity<>(transaccionDto, HttpStatus.OK);
    }

}

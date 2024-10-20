package com.iOS.TranporteApp.Controller;

import com.iOS.TranporteApp.Dto.HistoryDto;
import com.iOS.TranporteApp.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Controller/History")
public class HistoryController {
    @Autowired
    HistoryService historyService;

    //crear una historial
    @PostMapping
    public ResponseEntity<HistoryDto>createHistory(@RequestBody HistoryDto historyDto){
        HistoryDto newHistory = historyService.CreateHistory(historyDto);
        return new ResponseEntity<>(newHistory, HttpStatus.CREATED);
    }
    //obtener toda las historia
    @GetMapping
    public ResponseEntity<List<HistoryDto>> getAllHistory(){
        List<HistoryDto> historyList = historyService.getAllHistory();
        return new ResponseEntity<>(historyList, HttpStatus.OK);
    }
    //obtener historial por id
    @GetMapping("/{id_Histrory}")
    public ResponseEntity<HistoryDto> getHistoryById(@PathVariable("id_History") Long id_Histrory){
        HistoryDto historyDto = historyService.getHistoryById(id_Histrory);
        return new ResponseEntity<>(historyDto, HttpStatus.OK);
    }

}

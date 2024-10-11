package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.PQRDto;

import java.util.List;

public interface PQRService {
    PQRDto createPQR(PQRDto pqrDto);
    List<PQRDto> getAllPQR();
    PQRDto getPQRById(Long id_pqr);

}

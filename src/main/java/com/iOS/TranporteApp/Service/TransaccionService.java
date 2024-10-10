package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.TransaccionDto;

import java.util.List;

public interface TransaccionService {
    TransaccionDto createTransaction(TransaccionDto transaccionDto);
    List<TransaccionDto> getAllTransaction();
    TransaccionDto getTransactionById(Long id_transaction);


}

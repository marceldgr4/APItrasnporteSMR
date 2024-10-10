package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.Payments_CardDto;


import java.time.LocalDateTime;
import java.util.List;

public interface Payment_CardService {
    Payments_CardDto createPayments(Payments_CardDto payments_cardDto);
    List<Payments_CardDto> getAllPayments();
    Payments_CardDto getPaymentById(Long id_payment);
    List<Payments_CardDto> getAllPaymentsByDate(LocalDateTime date);


}

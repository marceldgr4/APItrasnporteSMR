package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.PaymentsDto;


import java.time.LocalDateTime;
import java.util.List;

public interface PaymentService {
    PaymentsDto createPayments(PaymentsDto payments_Dto_);
    List<PaymentsDto> getAllPayments();
    PaymentsDto getPaymentById(Long id_payment);
    List<PaymentsDto> getAllPaymentsByDate(LocalDateTime date);


}

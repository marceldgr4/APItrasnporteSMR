package com.iOS.TranporteApp.Dto;

import lombok.*;

import java.time.LocalDateTime;
@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentsDto {
    private Long id_payment;
    private Long id_user;
    private Long id_bus;
    private Long id_transaction;
    private Double amount;
    private LocalDateTime date;
}

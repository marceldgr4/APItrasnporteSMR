package com.iOS.TranporteApp.Dto;

import lombok.*;

import java.time.LocalDateTime;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payments_CardDto {
    private Long id_payment;
    private Double amount;
    private LocalDateTime date;
}

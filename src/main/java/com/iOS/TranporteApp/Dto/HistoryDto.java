package com.iOS.TranporteApp.Dto;

import lombok.*;

import java.time.LocalDateTime;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryDto {
    private Long id_history;
    private Long id_User;
    private  Long id_payment;
    private Long id_transaction;
    private LocalDateTime date_History;
}

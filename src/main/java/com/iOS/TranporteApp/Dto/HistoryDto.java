package com.iOS.TranporteApp.Dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryDto {
    private Long id_History;
    private Long id_User;
    private  Long id_Payment;
    private Long id_Transaction;
    private LocalDateTime date_History;
}

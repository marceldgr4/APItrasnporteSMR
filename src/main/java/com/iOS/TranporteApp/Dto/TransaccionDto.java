package com.iOS.TranporteApp.Dto;

import com.iOS.TranporteApp.Emun.TypeTransaction;
import lombok.*;

import java.time.LocalDateTime;
@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransaccionDto {
    private Long id_transaction;
    private Long id_user;
    private TypeTransaction typeTransaction;
    private LocalDateTime date_transaction;
    private Double amount;
}

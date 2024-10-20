package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.HistoryDto;

import java.util.List;

public interface HistoryService {
    HistoryDto CreateHistory(HistoryDto historyDto);
    List<HistoryDto> getAllHistory();
    HistoryDto getHistoryById(Long id_history);
}

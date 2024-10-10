package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.HistoryDto;

import java.util.List;

public interface HistoryService {
    HistoryDto CreateHistory(HistoryDto historyDto);

    List<HistoryDto> getAllHistory();
    List<HistoryDto> getHistoryByUserId(Long userId);
    List<HistoryDto> getHistoryByUserName(String userName);
    void deleteHistoryByUserId(Long id_user);
    HistoryDto getHistoryById(Long id_History);
}

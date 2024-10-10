package com.iOS.TranporteApp.Impl;

import com.iOS.TranporteApp.Dto.HistoryDto;
import com.iOS.TranporteApp.Entity.History;
import com.iOS.TranporteApp.Repository.HistoryRepository;
import com.iOS.TranporteApp.Service.HistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryServiceImp implements HistoryService {
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public HistoryDto CreateHistory(HistoryDto historyDto) {
        History history = modelMapper.map(historyDto, History.class);
        history = historyRepository.save(history);
        return modelMapper.map(history, HistoryDto.class);
    }
   @Override
    public List<HistoryDto> getAllHistory() {
        List<History> historyList = historyRepository.findAll();
        return historyList.stream().map(history -> modelMapper.map(history,HistoryDto.class)).collect(Collectors.toList());
   }
   @Override
    public List<HistoryDto>getHistoryByUserId(Long id_User){
        List<History> historyList= historyRepository.findByUserId(id_User);
        return historyList.stream().map(history -> modelMapper.map(history,HistoryDto.class)).collect(Collectors.toList());

   }
   @Override
    public List<HistoryDto> getHistoryByUserName(String username) {
        List<History> historyList= historyRepository.findByUsername(username);
        return historyList.stream().map(history -> modelMapper.map(history,HistoryDto.class)).collect(Collectors.toList());

   }
   @Override
    public HistoryDto getHistoryById(Long id_History) {
        History history = historyRepository.findById(id_History).orElseThrow(()-> new RuntimeException("history not found"));
        return modelMapper.map(history,HistoryDto.class);
   }

   @Override
    public void deleteHistoryByUserId(Long id_User) {
        historyRepository.deleteById(id_User);
   }

}

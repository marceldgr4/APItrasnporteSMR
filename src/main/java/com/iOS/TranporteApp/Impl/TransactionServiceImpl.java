package com.iOS.TranporteApp.Impl;

import com.iOS.TranporteApp.Dto.TransaccionDto;
import com.iOS.TranporteApp.Entity.Transaction;
import com.iOS.TranporteApp.Repository.TransaccionRepository;
import com.iOS.TranporteApp.Service.TransaccionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransaccionService {
    @Autowired
    private TransaccionRepository transaccionRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TransaccionDto createTransaction(TransaccionDto transaccionDto) {
        Transaction transaction = modelMapper.map(transaccionDto, Transaction.class);
        transaction = transaccionRepository.save(transaction);
        return modelMapper.map(transaction, TransaccionDto.class);
    }
    @Override
    public List<TransaccionDto> getAllTransaction() {
        List<Transaction> transactions = transaccionRepository.findAll();
        return transactions.stream().map(transaction -> modelMapper.map(transaction, TransaccionDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public TransaccionDto  getTransactionById(Long id_transaction) {
        Transaction transaction = transaccionRepository.findById(id_transaction).orElseThrow(()-> new RuntimeException("transaction not found"));
        return modelMapper.map(transaction, TransaccionDto.class);
    }
}

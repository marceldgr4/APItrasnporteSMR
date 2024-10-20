package com.iOS.TranporteApp.Impl;

import com.iOS.TranporteApp.Dto.PaymentsDto;
import com.iOS.TranporteApp.Entity.Payments;
import com.iOS.TranporteApp.Repository.PaymentsCardRepository;
import com.iOS.TranporteApp.Service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentsCardRepository PaymentsCardRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PaymentsDto createPayments(PaymentsDto payments_Dto_) {
        Payments payments_ = modelMapper.map(payments_Dto_, Payments.class);
        payments_ = PaymentsCardRepository.save(payments_);
        return modelMapper.map(payments_, PaymentsDto.class);
    }
    @Override
    public PaymentsDto getPaymentById(Long id_payment) {
        Payments payments_ = PaymentsCardRepository
                .findById(id_payment).orElseThrow(()-> new RuntimeException("payment not found"));
        return modelMapper.map(payments_, PaymentsDto.class);
    }
    @Override
    public List<PaymentsDto> getAllPayments(){
        List<Payments> payments_s = PaymentsCardRepository.findAll();
        return payments_s.stream().map(paymentsCard -> modelMapper.map(paymentsCard, PaymentsDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<PaymentsDto>getAllPaymentsByDate(LocalDateTime date){
        List<Payments> payments_s = PaymentsCardRepository.findByDate(date);
        return payments_s.stream().map(paymentsCard -> modelMapper.map(paymentsCard, PaymentsDto.class))
                .collect(Collectors.toList());
    }
}

package com.iOS.TranporteApp.Impl;

import com.iOS.TranporteApp.Dto.Payments_CardDto;
import com.iOS.TranporteApp.Entity.Payments_Card;
import com.iOS.TranporteApp.Repository.PaymentsCardRepository;
import com.iOS.TranporteApp.Service.Payment_CardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements Payment_CardService {
    @Autowired
    private PaymentsCardRepository PaymentsCardRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Payments_CardDto createPayments(Payments_CardDto payments_cardDto) {
        Payments_Card payments_card = modelMapper.map(payments_cardDto, Payments_Card.class);
        payments_card = PaymentsCardRepository.save(payments_card);
        return modelMapper.map(payments_card, Payments_CardDto.class);
    }
    @Override
    public Payments_CardDto getPaymentById(Long id_payment) {
        Payments_Card payments_card = PaymentsCardRepository
                .findById(id_payment).orElseThrow(()-> new RuntimeException("payment not found"));
        return modelMapper.map(payments_card, Payments_CardDto.class);
    }
    @Override
    public List<Payments_CardDto> getAllPayments(){
        List<Payments_Card> payments_cards = PaymentsCardRepository.findAll();
        return payments_cards.stream().map(paymentsCard -> modelMapper.map(paymentsCard,Payments_CardDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<Payments_CardDto>getAllPaymentsByDate(LocalDateTime date){
        List<Payments_Card> payments_cards = PaymentsCardRepository.findByDate(date);
        return payments_cards.stream().map(paymentsCard -> modelMapper.map(paymentsCard,Payments_CardDto.class))
                .collect(Collectors.toList());
    }
}

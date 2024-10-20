package com.iOS.TranporteApp.Controller;

import com.iOS.TranporteApp.Dto.PaymentsDto;
import com.iOS.TranporteApp.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Controller/Payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;


    //Crear un pago
    @PostMapping
    public ResponseEntity<PaymentsDto> createPayment(@RequestBody PaymentsDto paymentsDto) {
        PaymentsDto newPayment = paymentService.createPayments(paymentsDto);
        return new ResponseEntity<>(newPayment, HttpStatus.CREATED);
    }
    //obtener todos los pagos
    @GetMapping
    public ResponseEntity<List<PaymentsDto>> getAllPayments() {
        List<PaymentsDto> payments = paymentService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }
    //obtener un pago por id
    @GetMapping("/{id_payment}")
    public ResponseEntity<PaymentsDto> getPaymentById(@PathVariable Long id_payment) {
        PaymentsDto payment = paymentService.getPaymentById(id_payment);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}

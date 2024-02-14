package com.ecommerce.paymentservice.controllers;

import com.ecommerce.paymentservice.dtos.GeneratePaymentURLRequestDTO;
import com.ecommerce.paymentservice.services.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public String generatePaymentUrl(@RequestBody GeneratePaymentURLRequestDTO requestDTO){
        String orderId = requestDTO.getOrderId();
        String phoneNumber = requestDTO.getPhoneNumber();
        long amount = requestDTO.getAmount();
        String response = "Something went wrong";

        try {
            response = paymentService.generatePaymentLink(orderId, amount, phoneNumber);
        }catch (StripeException exception){
            System.out.println(exception.getMessage());
        }
        return response;
    }
}

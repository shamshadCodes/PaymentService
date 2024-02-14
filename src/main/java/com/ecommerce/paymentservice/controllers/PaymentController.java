package com.ecommerce.paymentservice.controllers;

import com.ecommerce.paymentservice.dtos.GeneratePaymentLinkResponseDTO;
import com.ecommerce.paymentservice.dtos.GeneratePaymentURLRequestDTO;
import com.ecommerce.paymentservice.services.PaymentService;
import com.razorpay.RazorpayException;
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
    public GeneratePaymentLinkResponseDTO generatePaymentUrl(@RequestBody GeneratePaymentURLRequestDTO requestDTO){
        String orderId = requestDTO.getOrderId();
        String phoneNumber = requestDTO.getPhoneNumber();
        long amount = requestDTO.getAmount();
        String paymentGateway = requestDTO.getPaymentGateway();

        GeneratePaymentLinkResponseDTO responseDTO = new GeneratePaymentLinkResponseDTO();

        try {
            responseDTO.setPaymentLink(paymentService.generatePaymentLink(orderId, amount, phoneNumber, paymentGateway));
        }catch (StripeException | RazorpayException exception){
            responseDTO.setMessage(exception.getMessage());
            responseDTO.setStatus(
                    exception instanceof StripeException
                            ? ((StripeException) exception).getCode()
                            : exception.getLocalizedMessage()
            );
        }
        return responseDTO;
    }
}

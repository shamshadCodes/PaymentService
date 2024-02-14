package com.ecommerce.paymentservice.services;

import com.ecommerce.paymentservice.paymentGateways.PaymentGateway;
import com.ecommerce.paymentservice.paymentGateways.StripePaymentGateway;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    PaymentGateway paymentGateway;

    public PaymentService(StripePaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String generatePaymentLink(String orderId, long amount, String phoneNumber) throws StripeException {
        return paymentGateway.initiatePayment(orderId, amount, phoneNumber);
    }

}

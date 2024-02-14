package com.ecommerce.paymentservice.services;

import com.ecommerce.paymentservice.paymentGateways.PaymentGateway;
import com.ecommerce.paymentservice.paymentGateways.PaymentGatewayFactory;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    PaymentGatewayFactory paymentGatewayFactory;

    public PaymentService(PaymentGatewayFactory paymentGatewayFactory) {
        this.paymentGatewayFactory = paymentGatewayFactory;
    }

    public String generatePaymentLink(String orderId, long amount, String phoneNumber, String requestedPaymentGateway) throws StripeException, RazorpayException {
        PaymentGateway paymentGateway = paymentGatewayFactory.getPaymentGateway(requestedPaymentGateway);
        return paymentGateway.initiatePayment(orderId, amount, phoneNumber);
    }

}

package com.ecommerce.paymentservice.paymentGateways;

public interface PaymentGateway {
    String initiatePayment(long orderId, long amount, String phoneNumber);
}

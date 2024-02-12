package com.ecommerce.paymentservice.paymentGateways;

public interface PaymentGateway {
    public String initiatePayment(long orderId, long amount, String phoneNumber);
}

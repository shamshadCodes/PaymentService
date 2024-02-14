package com.ecommerce.paymentservice.paymentGateways;

import com.stripe.exception.StripeException;

public interface PaymentGateway {
    String initiatePayment(String orderId, long amount, String phoneNumber) throws StripeException;
}

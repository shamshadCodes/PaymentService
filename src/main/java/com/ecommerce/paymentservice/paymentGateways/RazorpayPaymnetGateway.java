package com.ecommerce.paymentservice.paymentGateways;

public class RazorpayPaymnetGateway implements PaymentGateway{
    @Override
    public String initiatePayment(long orderId, long amount, String phoneNumber) {
        return null;
    }
}

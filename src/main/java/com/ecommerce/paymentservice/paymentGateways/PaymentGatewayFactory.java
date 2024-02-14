package com.ecommerce.paymentservice.paymentGateways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayFactory {
    private final StripePaymentGateway stripePaymentGateway;
    private final RazorpayPaymentGateway razorpayPaymentGateway;

    @Autowired
    public PaymentGatewayFactory(StripePaymentGateway stripePaymentGateway, RazorpayPaymentGateway razorpayPaymentGateway) {
        this.stripePaymentGateway = stripePaymentGateway;
        this.razorpayPaymentGateway = razorpayPaymentGateway;
    }

    public PaymentGateway getPaymentGateway(String paymentGateway){
        //Return the PG object based on the paymentGateway attribute or razorpay PG by default
        if (paymentGateway.equalsIgnoreCase("stripe")) {
            return stripePaymentGateway;
        }
        return razorpayPaymentGateway;
    }
}

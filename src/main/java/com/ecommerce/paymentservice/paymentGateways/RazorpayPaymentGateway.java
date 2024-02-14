package com.ecommerce.paymentservice.paymentGateways;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RazorpayPaymentGateway implements PaymentGateway{
    @Value("${razorpay.api.id}")
    private String keyID;
    @Value("${razorpay.api.secret}")
    private String secret;
    @Override
    public String initiatePayment(String orderId, long amount, String phoneNumber) throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient(keyID, secret);

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",amount);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",true);
        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",1707918951);
        paymentLinkRequest.put("reference_id",orderId);
        paymentLinkRequest.put("description","Payment for policy no #23456");

        JSONObject customer = new JSONObject();
        customer.put("name","Gaurav Kumar");
        customer.put("contact", phoneNumber);
        customer.put("email","gaurav.kumar@example.com");

        paymentLinkRequest.put("customer",customer);

        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);

        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);

        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");

        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","http://localhost:8080/payment/finished");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }
}

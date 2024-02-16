package com.ecommerce.paymentservice.controllers;

import com.stripe.model.Event;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stripe-webhook")
public class StripeWebhookController {
    @PostMapping("/")
    public void webhookRequests(@RequestBody Event event){
        System.out.printf("Webhook trigger for %s\n", event.getType());
    }

    @GetMapping("/")
    public String webhookRequests(){
        return ("Webhook trigger by the browser.");
    }
}

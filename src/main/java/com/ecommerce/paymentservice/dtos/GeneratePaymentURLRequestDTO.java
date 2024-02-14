package com.ecommerce.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneratePaymentURLRequestDTO {
    private String orderId;
    private String phoneNumber;
    private long amount;
}

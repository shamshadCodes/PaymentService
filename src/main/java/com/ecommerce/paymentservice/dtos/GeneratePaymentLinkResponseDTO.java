package com.ecommerce.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneratePaymentLinkResponseDTO {
    private String paymentLink;
    private String status;
    private String message;
}

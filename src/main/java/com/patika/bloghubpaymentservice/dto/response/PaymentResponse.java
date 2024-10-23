package com.patika.bloghubpaymentservice.dto.response;

import com.patika.bloghubpaymentservice.model.enums.PaymentStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentResponse {
    private BigDecimal amount;
    private LocalDateTime createDateTime;
    private PaymentStatus paymentStatus;
    private String email;
}

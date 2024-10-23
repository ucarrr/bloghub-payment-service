package com.patika.bloghubpaymentservice.converter;


import com.patika.bloghubpaymentservice.dto.request.PaymentRequest;
import com.patika.bloghubpaymentservice.dto.response.PaymentResponse;
import com.patika.bloghubpaymentservice.model.Payment;
import com.patika.bloghubpaymentservice.model.enums.PaymentStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentConverter {
    public static Payment toEntity(PaymentRequest request, PaymentStatus paymentStatus) {
        return new Payment(request.getAmount(), LocalDateTime.now(), paymentStatus, request.getEmail());
    }

    public static PaymentResponse toResponse(Payment payment) {
        return PaymentResponse.builder()
                .amount(payment.getAmount())
                .createDateTime(payment.getCreateDateTime())
                .paymentStatus(payment.getPaymentStatus())
                .email(payment.getEmail())
                .build();
    }

    public static List<PaymentResponse>  toResponse(List<Payment> paymentList) {
        return paymentList
                .stream()
                .map(PaymentConverter::toResponse)
                .toList();

    }
}

package org.interview.payment.controller;

import lombok.RequiredArgsConstructor;
import org.interview.payment.dto.PaymentContactDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentContactDto paymentContactDto;

    @GetMapping("contact")
    public ResponseEntity<PaymentContactDto> getPaymentContact() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(paymentContactDto);
    }

}

package org.interview.order.client;

import org.interview.order.client.dto.PaymentContactDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "payment", fallback = PaymentFallback.class) // or name="payment"
public interface PaymentClient {
    @GetMapping(value = "api/payments/contact")
    ResponseEntity<PaymentContactDto> getPaymentContact();
}

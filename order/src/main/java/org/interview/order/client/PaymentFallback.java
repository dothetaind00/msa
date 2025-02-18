package org.interview.order.client;

import org.interview.order.client.dto.PaymentContactDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallback implements PaymentClient{
    @Override
    public ResponseEntity<PaymentContactDto> getPaymentContact() {
        return null;
    }
}

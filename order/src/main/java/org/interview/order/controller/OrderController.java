package org.interview.order.controller;

import lombok.RequiredArgsConstructor;
import org.interview.order.client.PaymentClient;
import org.interview.order.client.dto.PaymentContactDto;
import org.interview.order.dto.OrderContactDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderContactDTO orderContactDTO;

    private final PaymentClient paymentClient;

    @GetMapping("contact")
    public ResponseEntity<OrderContactDTO> getOrderContact() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(orderContactDTO);
    }

    @GetMapping("payment/contact")
    public ResponseEntity<PaymentContactDto> getPaymentContact() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(paymentClient.getPaymentContact().getBody());
    }

}

package org.interview.order.controller;

import lombok.RequiredArgsConstructor;
import org.interview.order.client.PaymentClient;
import org.interview.order.client.dto.PaymentContactDto;
import org.interview.order.dto.OrderContactDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderContactDTO orderContactDTO;

    private final PaymentClient paymentClient;

    @GetMapping("contact")
    public ResponseEntity<OrderContactDTO> getOrderContact() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(orderContactDTO);
    }

    @GetMapping("payment/contact")
    public ResponseEntity<PaymentContactDto> getPaymentContact(@RequestHeader("msa-correlation-id") String correlationId) {
        logger.debug("msa-correlation-id found: {} ", correlationId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(paymentClient.getPaymentContact().getBody());
    }

}

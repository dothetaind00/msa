package org.interview.order.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class PaymentContactDto {
    private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}

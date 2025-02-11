package org.interview.order.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix = "order")
public class OrderContactDTO {
    private String name;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}

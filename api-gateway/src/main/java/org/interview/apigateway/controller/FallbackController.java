package org.interview.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @GetMapping("contact-support")
    public Mono<String> contactSupport() {
        return Mono.just("An error occurred. Please try again");
    }

}

package com.mothkuri.bot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HealthController implements HealthIndicator {


    @Value("${bot.custom.message}")
    public String customMessage;


    @Override
    @GetMapping("/health")
    public Health health() {
        return Health.up()
                .status("bot working")
                .build();
    }

    @GetMapping("/custom/health")
    public Mono<Health> customHealth(){
        Health health = Health.up().status(customMessage).build();
       return Mono.just(health);
    }
}

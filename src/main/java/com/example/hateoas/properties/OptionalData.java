package com.example.hateoas.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "optionaldata")
public class OptionalData {
    String[] blog;
    String[] comment;
}

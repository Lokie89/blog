package com.example.hateoas.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "mandatorydata")
public class MandatoryData {
    String[] blog;
    String[] comment;
}

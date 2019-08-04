package com.example.hateoas.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "description")
public class Description {
    DescriptionVO blog;
    DescriptionVO comment;
}

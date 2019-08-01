package com.example.hateoas.util;

import lombok.Data;

@Data
public class CustomLink {
    private String href;
    private String rel;
    private String type;
    private String description;

}

package com.example.hateoas.vo;

import lombok.Data;

@Data
public class ReadObject {
    private String href;
    private String type;
    private String description;
}

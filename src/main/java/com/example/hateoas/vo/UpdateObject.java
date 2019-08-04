package com.example.hateoas.vo;

import lombok.Data;

@Data
public class UpdateObject {
    private String href;
    private String type;
    private String description;
    private String[] mandatoryData;
    private String[] optionalData;
}

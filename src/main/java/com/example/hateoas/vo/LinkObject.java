package com.example.hateoas.vo;

import lombok.Data;

@Data
public class LinkObject {
    CreateObject create;
    ReadObject read;
    UpdateObject update;
    DeleteObject delete;

}

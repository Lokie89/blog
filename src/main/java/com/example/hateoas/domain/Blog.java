package com.example.hateoas.domain;

import com.example.hateoas.vo.LinkObject;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;
    private String title;
    private String content;
    private Date createdDate;

    // 제외, 모든 Entity에 필요함
    @Transient
    private LinkObject _links;


}

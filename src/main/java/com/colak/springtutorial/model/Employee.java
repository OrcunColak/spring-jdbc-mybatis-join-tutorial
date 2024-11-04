package com.colak.springtutorial.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private Integer id;
    private String name;
    private Integer departmentId;
}

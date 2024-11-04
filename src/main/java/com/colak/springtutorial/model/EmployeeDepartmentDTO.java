package com.colak.springtutorial.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDepartmentDTO {
    private int employeeId;
    private String employeeName;
    private Integer departmentId;  // Nullable because of LEFT JOIN
    private String departmentName;
}


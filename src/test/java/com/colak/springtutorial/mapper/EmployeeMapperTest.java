package com.colak.springtutorial.mapper;

import com.colak.springtutorial.model.Employee;
import com.colak.springtutorial.model.EmployeeDepartmentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper mapper;

    @Test
    void getAllEmployees() {
        List<Employee> allCompanies = mapper.findAll();
        assertThat(allCompanies).isNotEmpty();
    }

    @Test
    void leftJoin() {
        List<Map<String, Object>> leftJoin = mapper.leftJoin();
        assertThat(leftJoin).isNotEmpty();

        List<Map<String, Object>> expectedMaps = Stream.of(
                new Object[]{"ID", 1, "NAME", "John Doe", "DEPARTMENT_NAME", "HR"},
                new Object[]{"ID", 2, "NAME", "Jane Smith", "DEPARTMENT_NAME", "Finance"},
                new Object[]{"ID", 3, "NAME", "Michael Johnson", "DEPARTMENT_NAME", null}, // Null allowed here
                new Object[]{"ID", 4, "NAME", "Emily Davis", "DEPARTMENT_NAME", "IT"},
                new Object[]{"ID", 5, "NAME", "William Brown", "DEPARTMENT_NAME", "HR"}
        ).map(arr -> {
            Map<String, Object> map = new HashMap<>();
            map.put((String) arr[0], arr[1]);
            map.put((String) arr[2], arr[3]);
            map.put((String) arr[4], arr[5]);
            return map;
        }).collect(Collectors.toList());

        assertThat(leftJoin).containsAnyElementsOf(expectedMaps);
    }

    @Test
    void getEmployeeWithDepartment() {
        List<EmployeeDepartmentDTO> leftJoin = mapper.getEmployeeWithDepartment();
        assertThat(leftJoin).isNotEmpty();

        List<EmployeeDepartmentDTO> expectedList = List.of(
                new EmployeeDepartmentDTO(1, "John Doe", 1, "HR"),
                new EmployeeDepartmentDTO(3, "Michael Johnson", null, null)
        );

        assertThat(leftJoin).containsAnyElementsOf(expectedList);
    }
}

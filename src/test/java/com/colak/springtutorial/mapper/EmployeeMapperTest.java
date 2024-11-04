package com.colak.springtutorial.mapper;

import com.colak.springtutorial.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

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

        List<Map<String, Object>> expectedMaps = List.of(
                Map.of("ID", 1, "NAME", "John Doe", "DEPARTMENT_NAME", "HR")
        );

        // Assert that the actual list of maps contains exactly the elements in the expected list
        assertThat(leftJoin).containsAnyElementsOf(expectedMaps);
    }
}

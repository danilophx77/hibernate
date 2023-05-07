package com.example.relationships;

import com.example.dao.EmployeeDAO;
import com.example.dao.EmployeeDAOImpl;
import com.example.entities.Employee;
import com.example.entities.Project;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ManyToManyTest {

    @Test
    void manyToManyTest() {

        Project project1 = new Project(null, "Project X 1", LocalDate.now());
        Project project2 = new Project(null, "Project X 2", LocalDate.now());
        Project project3 = new Project(null, "Project X 3", LocalDate.now());
        Project project4 = new Project(null, "Project X 4", LocalDate.now());
        Project project5 = new Project(null, "Project X 5", LocalDate.now());


        Employee employee = new Employee(null,
                "Empleado many to many",
                "Fernandez",
                "empleadoManyToMany@company.com",
                32,
                40000d,
                true,
                LocalDate.of(1990, 1, 1),
                LocalDateTime.now()
        );

        Employee employee1 = new Employee(null,
                "Empleado many to many",
                "Pruneda",
                "empleadoManyToMany@company.com",
                32,
                40000d,
                true,
                LocalDate.of(1990, 1, 1),
                LocalDateTime.now()
        );
        employee1.getProjects().add(project1);
        employee.getProjects().add(project2);
        employee1.getProjects().add(project3);
        employee.getProjects().add(project4);
        employee1.getProjects().add(project5);
        employee.getProjects().add(project1);

        EmployeeDAO dao = new EmployeeDAOImpl();
        dao.create(employee);
    }
}

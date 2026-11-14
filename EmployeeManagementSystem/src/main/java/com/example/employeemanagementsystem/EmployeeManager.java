package com.example.employeemanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    private static final List<Employee> employees =
            new ArrayList<>();

    private static int nextId = 1;

    public static void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static int getNextId() {
        return nextId++;
    }

    public static void deleteEmployee(int id) {

        employees.removeIf(
                employee -> employee.getId() == id
        );
    }
}



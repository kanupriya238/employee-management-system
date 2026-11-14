package com.example.employeemanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class DepartmentManager {

    private static final List<Department> departments =
            new ArrayList<>();

    private static int nextId = 1;

    public static void addDepartment(Department department) {
        departments.add(department);
    }

    public static List<Department> getDepartments() {
        return departments;
    }

    public static int getNextId() {
        return nextId++;
    }

    public static void deleteDepartment(int id) {

        departments.removeIf(
                department -> department.getId() == id
        );
    }
}



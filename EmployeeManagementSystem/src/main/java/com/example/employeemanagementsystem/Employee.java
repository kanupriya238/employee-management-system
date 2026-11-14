package com.example.employeemanagementsystem;

public class Employee {

    private int id;
    private String employeeName;
    private String department;
    private String hireDate;
    private String employmentStatus;
    private double salary;
    private String jobTitle;

    public Employee(int id,
                String employeeName,
                String department,
                String hireDate,
                String employmentStatus,
                double salary,
                String jobTitle) {

        this.id = id;
        this.employeeName = employeeName;
        this.department = department;
        this.hireDate = hireDate;
        this.employmentStatus = employmentStatus;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    public int getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public String getHireDate() {
        return hireDate;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public double getSalary() {
        return salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}



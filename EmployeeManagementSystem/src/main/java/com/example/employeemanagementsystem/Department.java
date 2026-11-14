package com.example.employeemanagementsystem;

public class Department {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String jobTitle;

    public Department(
            int id,
            String name,
            String email,
            String phone,
            String jobTitle) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.jobTitle = jobTitle;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return jobTitle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDescription(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}



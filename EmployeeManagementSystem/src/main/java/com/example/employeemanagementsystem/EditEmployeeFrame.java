package com.example.employeemanagementsystem;

import javax.swing.*;
import java.awt.*;

public class EditEmployeeFrame extends JFrame {

    private final Employee employee;
    private final ViewEmployeesFrame parentFrame;

    private JTextField employeeNameField;
    private JTextField departmentField;
    private JTextField hireDateField;
    private JTextField employmentStatusField;
    private JTextField salaryField;
    private JTextArea jobTitleArea;

    public EditEmployeeFrame(
            Employee employee,
            ViewEmployeesFrame parentFrame) {

        this.employee = employee;
        this.parentFrame = parentFrame;

        setTitle("Edit Employee");
        setSize(700, 600);
        setLocationRelativeTo(parentFrame);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        createUI();
        loadEmployeeData();
    }

    private void createUI() {

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(Color.WHITE);

        // Header
        JPanel headerPanel =
                new JPanel(new BorderLayout());

        headerPanel.setPreferredSize(
                new Dimension(700, 70)
        );

        headerPanel.setBackground(
                new Color(100, 125, 235)
        );

        JLabel titleLabel =
                new JLabel(
                        "Edit Employee",
                        SwingConstants.CENTER
                );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 25)
        );

        titleLabel.setForeground(Color.WHITE);

        headerPanel.add(
                titleLabel,
                BorderLayout.CENTER
        );

        mainPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );

        // Form
        JPanel formPanel =
                new JPanel(new GridBagLayout());

        formPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(8, 10, 8, 10);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        // Employee Name
        gbc.gridx = 0;
        gbc.gridy = 0;

        formPanel.add(
                createLabel("Employee Name"),
                gbc
        );

        gbc.gridx = 1;

        employeeNameField = new JTextField(25);

        formPanel.add(
                employeeNameField,
                gbc
        );

        // Department
        gbc.gridx = 0;
        gbc.gridy = 1;

        formPanel.add(
                createLabel("Department"),
                gbc
        );

        gbc.gridx = 1;

        departmentField =
                new JTextField(25);

        formPanel.add(
                departmentField,
                gbc
        );

        // Hire Date
        gbc.gridx = 0;
        gbc.gridy = 2;

        formPanel.add(
                createLabel("Hire Date"),
                gbc
        );

        gbc.gridx = 1;

        hireDateField =
                new JTextField(25);

        formPanel.add(
                hireDateField,
                gbc
        );

        // Employment Status
        gbc.gridx = 0;
        gbc.gridy = 3;

        formPanel.add(
                createLabel("Employment Status"),
                gbc
        );

        gbc.gridx = 1;

        employmentStatusField =
                new JTextField(25);

        formPanel.add(
                employmentStatusField,
                gbc
        );

        // Monthly Salary
        gbc.gridx = 0;
        gbc.gridy = 4;

        formPanel.add(
                createLabel("Monthly Salary"),
                gbc
        );

        gbc.gridx = 1;

        salaryField =
                new JTextField(25);

        formPanel.add(
                salaryField,
                gbc
        );

        // Job Title
        gbc.gridx = 0;
        gbc.gridy = 5;

        gbc.anchor =
                GridBagConstraints.NORTH;

        formPanel.add(
                createLabel("Job Title"),
                gbc
        );

        gbc.gridx = 1;

        jobTitleArea =
                new JTextArea(5, 25);

        jobTitleArea.setLineWrap(true);
        jobTitleArea.setWrapStyleWord(true);

        JScrollPane jobTitleScroll =
                new JScrollPane(
                        jobTitleArea
                );

        formPanel.add(
                jobTitleScroll,
                gbc
        );

        // Buttons
        JPanel buttonPanel =
                new JPanel();

        buttonPanel.setBackground(Color.WHITE);

        JButton updateButton =
                new JButton("Update Employee");

        JButton cancelButton =
                new JButton("Cancel");

        styleButton(updateButton);
        styleButton(cancelButton);

        buttonPanel.add(updateButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;

        gbc.anchor =
                GridBagConstraints.CENTER;

        formPanel.add(
                buttonPanel,
                gbc
        );

        mainPanel.add(
                formPanel,
                BorderLayout.CENTER
        );

        add(mainPanel);

        updateButton.addActionListener(
                e -> updateEmployee()
        );

        cancelButton.addActionListener(
                e -> dispose()
        );
    }

    // =========================
    // LOAD DATA
    // =========================

    private void loadEmployeeData() {

        employeeNameField.setText(
                employee.getEmployeeName()
        );

        departmentField.setText(
                employee.getDepartment()
        );

        hireDateField.setText(
                employee.getHireDate()
        );

        employmentStatusField.setText(
                employee.getEmploymentStatus()
        );

        salaryField.setText(
                String.valueOf(employee.getSalary())
        );

        jobTitleArea.setText(
                employee.getJobTitle()
        );
    }

    // =========================
    // UPDATE
    // =========================

    private void updateEmployee() {

        String employeeName =
                employeeNameField.getText().trim();

        String department =
                departmentField.getText().trim();

        String hireDate =
                hireDateField.getText().trim();

        String employmentStatus =
                employmentStatusField.getText().trim();

        String salaryText =
                salaryField.getText().trim();

        String jobTitle =
                jobTitleArea.getText().trim();

        if (employeeName.isEmpty()
                || department.isEmpty()
                || hireDate.isEmpty()
                || employmentStatus.isEmpty()
                || salaryText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all required fields.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        double salary;

        try {

            salary =
                    Double.parseDouble(salaryText);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid salary.",
                    "Invalid Monthly Salary",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        employee.setEmployeeName(employeeName);
        employee.setDepartment(department);
        employee.setHireDate(hireDate);
        employee.setEmploymentStatus(employmentStatus);
        employee.setSalary(salary);
        employee.setJobTitle(jobTitle);

        JOptionPane.showMessageDialog(
                this,
                "Employee updated successfully.",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );

        parentFrame.refreshTable();

        dispose();
    }

    private JLabel createLabel(String text) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        return label;
    }

    private void styleButton(JButton button) {

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        button.setBackground(
                new Color(100, 125, 235)
        );

        button.setForeground(Color.WHITE);

        button.setFocusPainted(false);
    }
}



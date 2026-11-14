package com.example.employeemanagementsystem;

import javax.swing.*;
import java.awt.*;

public class AddEmployeeFrame extends JFrame {

    private JTextField employeeNameField;
    private JTextField departmentField;
    private JTextField hireDateField;
    private JTextField employmentStatusField;
    private JTextField salaryField;
    private JTextArea jobTitleArea;

    public AddEmployeeFrame() {

        setTitle("Employee Management System - Add Employee");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        createUI();
    }

    private void createUI() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(102, 92, 190));

        // =========================
        // HEADER
        // =========================

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setPreferredSize(new Dimension(900, 80));
        headerPanel.setBackground(new Color(100, 125, 235));

        JLabel titleLabel = new JLabel(
                "Create New Employee",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 28)
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

        // =========================
        // FORM PANEL
        // =========================

        JPanel formPanel = new JPanel(
                new GridBagLayout()
        );

        formPanel.setBackground(Color.WHITE);

        formPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25, 50, 25, 50
                )
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Employee Name
        gbc.gridx = 0;
        gbc.gridy = 0;

        formPanel.add(
                createLabel("Employee Name"),
                gbc
        );

        gbc.gridx = 1;

        employeeNameField = new JTextField();
        employeeNameField.setPreferredSize(
                new Dimension(400, 35)
        );

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

        departmentField = new JTextField();
        departmentField.setPreferredSize(
                new Dimension(400, 35)
        );

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

        hireDateField = new JTextField();
        hireDateField.setPreferredSize(
                new Dimension(400, 35)
        );

        hireDateField.setToolTipText(
                "Example: 2026-10-15"
        );

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

        employmentStatusField = new JTextField();
        employmentStatusField.setPreferredSize(
                new Dimension(400, 35)
        );

        employmentStatusField.setToolTipText(
                "Example: 2026-10-20"
        );

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

        salaryField = new JTextField();
        salaryField.setPreferredSize(
                new Dimension(400, 35)
        );

        formPanel.add(
                salaryField,
                gbc
        );

        // Job Title
        gbc.gridx = 0;
        gbc.gridy = 5;

        gbc.anchor = GridBagConstraints.NORTH;

        formPanel.add(
                createLabel("Job Title"),
                gbc
        );

        gbc.gridx = 1;

        jobTitleArea = new JTextArea(5, 30);
        jobTitleArea.setLineWrap(true);
        jobTitleArea.setWrapStyleWord(true);

        JScrollPane jobTitleScrollPane =
                new JScrollPane(jobTitleArea);

        jobTitleScrollPane.setPreferredSize(
                new Dimension(400, 120)
        );

        formPanel.add(
                jobTitleScrollPane,
                gbc
        );

        // =========================
        // BUTTONS
        // =========================

        JPanel buttonPanel = new JPanel();

        buttonPanel.setBackground(Color.WHITE);

        JButton createButton =
                new JButton("Add Employee");

        JButton clearButton =
                new JButton("Clear");

        JButton backButton =
                new JButton("Back to Home");

        styleButton(createButton);
        styleButton(clearButton);
        styleButton(backButton);

        buttonPanel.add(createButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;

        gbc.anchor = GridBagConstraints.CENTER;

        formPanel.add(
                buttonPanel,
                gbc
        );

        mainPanel.add(
                formPanel,
                BorderLayout.CENTER
        );

        add(mainPanel);

        // =========================
        // BUTTON ACTIONS
        // =========================

        createButton.addActionListener(
                e -> createEmployee()
        );

        clearButton.addActionListener(
                e -> clearForm()
        );

        backButton.addActionListener(e -> {

            dispose();

            new HomeFrame().setVisible(true);

        });
    }

    // =========================
    // ADD EMPLOYEE
    // =========================

    private void createEmployee() {

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

        // Validation

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

            salary = Double.parseDouble(salaryText);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid salary.",
                    "Invalid Monthly Salary",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        // Generate temporary ID
        int id =
                EmployeeManager.getNextId();

        Employee employee = new Employee(
                id,
                employeeName,
                department,
                hireDate,
                employmentStatus,
                salary,
                jobTitle
        );

        EmployeeManager.addEmployee(employee);

        JOptionPane.showMessageDialog(
                this,
                "Employee created successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );

        clearForm();
    }

    // =========================
    // CLEAR FORM
    // =========================

    private void clearForm() {

        employeeNameField.setText("");
        departmentField.setText("");
        hireDateField.setText("");
        employmentStatusField.setText("");
        salaryField.setText("");
        jobTitleArea.setText("");
    }

    // =========================
    // LABEL
    // =========================

    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);

        label.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        return label;
    }

    // =========================
    // BUTTON STYLE
    // =========================

    private void styleButton(JButton button) {

        button.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        button.setBackground(
                new Color(100, 125, 235)
        );

        button.setForeground(Color.WHITE);

        button.setFocusPainted(false);
    }
}



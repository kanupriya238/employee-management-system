package com.example.employeemanagementsystem;

import javax.swing.*;
import java.awt.*;

public class EditDepartmentFrame extends JFrame {

    private final Department department;
    private final ViewDepartmentsFrame parentFrame;

    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextArea jobTitleArea;

    public EditDepartmentFrame(
            Department department,
            ViewDepartmentsFrame parentFrame) {

        this.department = department;
        this.parentFrame = parentFrame;

        setTitle("Employee Management System - Edit Department");
        setSize(700, 550);
        setLocationRelativeTo(parentFrame);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        createUI();
        loadDepartmentData();
    }

    private void createUI() {

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(Color.WHITE);

        // =========================
        // HEADER
        // =========================

        JPanel headerPanel =
                new JPanel(new BorderLayout());

        headerPanel.setPreferredSize(
                new Dimension(700, 75)
        );

        headerPanel.setBackground(
                new Color(100, 125, 235)
        );

        JLabel titleLabel =
                new JLabel(
                        "Edit Department",
                        SwingConstants.CENTER
                );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
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
        // FORM
        // =========================

        JPanel formPanel =
                new JPanel(new GridBagLayout());

        formPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(10, 10, 10, 10);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        // Name
        gbc.gridx = 0;
        gbc.gridy = 0;

        formPanel.add(
                createLabel("Department Name"),
                gbc
        );

        gbc.gridx = 1;

        nameField =
                new JTextField(25);

        nameField.setPreferredSize(
                new Dimension(350, 35)
        );

        formPanel.add(
                nameField,
                gbc
        );

        // Email
        gbc.gridx = 0;
        gbc.gridy = 1;

        formPanel.add(
                createLabel("Contact Email"),
                gbc
        );

        gbc.gridx = 1;

        emailField =
                new JTextField(25);

        emailField.setPreferredSize(
                new Dimension(350, 35)
        );

        formPanel.add(
                emailField,
                gbc
        );

        // Phone
        gbc.gridx = 0;
        gbc.gridy = 2;

        formPanel.add(
                createLabel("Contact Phone"),
                gbc
        );

        gbc.gridx = 1;

        phoneField =
                new JTextField(25);

        phoneField.setPreferredSize(
                new Dimension(350, 35)
        );

        formPanel.add(
                phoneField,
                gbc
        );

        // Description
        gbc.gridx = 0;
        gbc.gridy = 3;

        gbc.anchor =
                GridBagConstraints.NORTH;

        formPanel.add(
                createLabel("Description"),
                gbc
        );

        gbc.gridx = 1;

        jobTitleArea =
                new JTextArea(5, 25);

        jobTitleArea.setLineWrap(true);
        jobTitleArea.setWrapStyleWord(true);

        JScrollPane jobTitleScrollPane =
                new JScrollPane(jobTitleArea);

        jobTitleScrollPane.setPreferredSize(
                new Dimension(350, 120)
        );

        formPanel.add(
                jobTitleScrollPane,
                gbc
        );

        // =========================
        // BUTTONS
        // =========================

        JPanel buttonPanel =
                new JPanel();

        buttonPanel.setBackground(Color.WHITE);

        JButton updateButton =
                new JButton("Update Department");

        JButton cancelButton =
                new JButton("Cancel");

        styleButton(updateButton);
        styleButton(cancelButton);

        buttonPanel.add(updateButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
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

        // =========================
        // ACTIONS
        // =========================

        updateButton.addActionListener(
                e -> updateDepartment()
        );

        cancelButton.addActionListener(
                e -> dispose()
        );
    }

    // =========================
    // LOAD DEPARTMENT DATA
    // =========================

    private void loadDepartmentData() {

        nameField.setText(
                department.getName()
        );

        emailField.setText(
                department.getEmail()
        );

        phoneField.setText(
                department.getPhone()
        );

        jobTitleArea.setText(
                department.getDescription()
        );
    }

    // =========================
    // UPDATE DEPARTMENT
    // =========================

    private void updateDepartment() {

        String name =
                nameField.getText().trim();

        String email =
                emailField.getText().trim();

        String phone =
                phoneField.getText().trim();

        String jobTitle =
                jobTitleArea.getText().trim();

        if (name.isEmpty()
                || email.isEmpty()
                || phone.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all required fields.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        department.setName(name);
        department.setEmail(email);
        department.setPhone(phone);
        department.setDescription(jobTitle);

        JOptionPane.showMessageDialog(
                this,
                "Department updated successfully.",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );

        parentFrame.refreshTable();

        dispose();
    }

    // =========================
    // LABEL
    // =========================

    private JLabel createLabel(String text) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        return label;
    }

    // =========================
    // BUTTON STYLE
    // =========================

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



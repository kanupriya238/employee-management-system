package com.example.employeemanagementsystem;

import javax.swing.*;
import java.awt.*;

public class AddDepartmentFrame extends JFrame {

    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextArea jobTitleArea;

    public AddDepartmentFrame() {

        setTitle("Employee Management System - Add Department");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        createUI();
    }

    private void createUI() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // =========================
        // HEADER
        // =========================

        HeaderPanel headerPanel =
                new HeaderPanel("Employee Management System");

        mainPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );
        // =========================
        // FORM
        // =========================

        JPanel formPanel = new JPanel(
                new GridBagLayout()
        );

        formPanel.setBackground(Color.WHITE);

        formPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        30, 80, 20, 80
                )
        );

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

        nameField = new JTextField(25);

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

        emailField = new JTextField(25);

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

        phoneField = new JTextField(25);

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

        JButton addButton =
                new JButton("Add Department");

        JButton clearButton =
                new JButton("Clear");

        JButton backButton =
                new JButton("Back to Home");

        styleButton(addButton);
        styleButton(clearButton);
        styleButton(backButton);

        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

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

        addButton.addActionListener(
                e -> addDepartment()
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
    // ADD DEPARTMENT
    // =========================

    private void addDepartment() {

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

        int id =
                DepartmentManager.getNextId();

        Department department =
                new Department(
                        id,
                        name,
                        email,
                        phone,
                        jobTitle
                );

        DepartmentManager.addDepartment(department);

        JOptionPane.showMessageDialog(
                this,
                "Department added successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );

        clearForm();
    }

    // =========================
    // CLEAR
    // =========================

    private void clearForm() {

        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        jobTitleArea.setText("");
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



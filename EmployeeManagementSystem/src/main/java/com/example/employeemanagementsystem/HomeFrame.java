package com.example.employeemanagementsystem;

import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JFrame {

    public HomeFrame() {

        setTitle("Employee Management System - Home");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        createUI();
    }

    private void createUI() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // =========================
        // HEADER
        // =========================

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setPreferredSize(new Dimension(1000, 80));
        headerPanel.setBackground(new Color(100, 125, 235));

        JLabel titleLabel = new JLabel(
                "Employee Management System",
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

        // =========================
        // MENU
        // =========================

        JPanel menuPanel = new JPanel(
                new GridLayout(3, 2, 20, 20)
        );

        menuPanel.setBackground(Color.WHITE);

        menuPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        60, 150, 60, 150
                )
        );

        JButton createEmployeeButton =
                new JButton("Add Employee");

        JButton viewEmployeesButton =
                new JButton("View Employees");
        JButton addDepartmentButton =
                new JButton("Add Department");

        JButton viewDepartmentsButton =
                new JButton("View Departments");

        JButton changePasswordButton =
                new JButton("Change Password");

        JButton logoutButton =
                new JButton("Logout");

        styleButton(createEmployeeButton);
        styleButton(viewEmployeesButton);
        styleButton(changePasswordButton);
        styleButton(logoutButton);
        styleButton(addDepartmentButton);
        styleButton(viewDepartmentsButton);

        menuPanel.add(createEmployeeButton);
        menuPanel.add(viewEmployeesButton);
        menuPanel.add(changePasswordButton);
        menuPanel.add(logoutButton);
        menuPanel.add(addDepartmentButton);
        menuPanel.add(viewDepartmentsButton);

        mainPanel.add(
                menuPanel,
                BorderLayout.CENTER
        );

        add(mainPanel);

        // =========================
        // BUTTON ACTIONS
        // =========================

        createEmployeeButton.addActionListener(e -> {

            new AddEmployeeFrame().setVisible(true);

            dispose();
        });

        viewEmployeesButton.addActionListener(e -> {

            new ViewEmployeesFrame().setVisible(true);

            dispose();
        });
        addDepartmentButton.addActionListener(e -> {

            new AddDepartmentFrame().setVisible(true);

            dispose();
        });

        viewDepartmentsButton.addActionListener(e -> {

            new ViewDepartmentsFrame().setVisible(true);

            dispose();
        });

        changePasswordButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Change Password page will be added next.",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        logoutButton.addActionListener(e -> {

            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {

                dispose();

                new LoginFrame().setVisible(true);
            }
        });
    }

    private void styleButton(JButton button) {

        button.setFont(
                new Font("Arial", Font.BOLD, 17)
        );

        button.setBackground(
                new Color(100, 125, 235)
        );

        button.setForeground(Color.WHITE);

        button.setFocusPainted(false);
    }
}



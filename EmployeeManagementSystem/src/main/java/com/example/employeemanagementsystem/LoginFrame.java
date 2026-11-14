package com.example.employeemanagementsystem;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    public LoginFrame() {

        setTitle("Employee Management System - Login");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        createUI();
    }

    private void createUI() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(102, 92, 190));

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(900, 100));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setLayout(new BorderLayout());

        JLabel headerLabel = new JLabel(
                "EMPLOYEE MANAGEMENT SYSTEM",
                SwingConstants.CENTER
        );

        headerLabel.setFont(
                new Font("Arial", Font.BOLD, 25)
        );

        headerLabel.setForeground(
                new Color(45, 42, 120)
        );

        headerPanel.add(headerLabel, BorderLayout.CENTER);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Login area
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(102, 92, 190));

        JPanel loginPanel = new JPanel();
        loginPanel.setPreferredSize(new Dimension(400, 360));
        loginPanel.setBackground(Color.WHITE);

        loginPanel.setLayout(
                new BoxLayout(loginPanel, BoxLayout.Y_AXIS)
        );

        loginPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25, 40, 25, 40
                )
        );

        // Logo
        JLabel logoLabel = new JLabel("👥");
        logoLabel.setFont(
                new Font("Segoe UI Emoji", Font.PLAIN, 40)
        );
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginPanel.add(logoLabel);

        // Title
        JLabel titleLabel = new JLabel(
                "Employee"
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 27)
        );

        titleLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        loginPanel.add(titleLabel);

        JLabel systemLabel = new JLabel(
                "Management System"
        );

        systemLabel.setFont(
                new Font("Arial", Font.BOLD, 21)
        );

        systemLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        loginPanel.add(systemLabel);

        loginPanel.add(
                Box.createVerticalStrut(20)
        );

        // Username
        JLabel usernameLabel = new JLabel(
                "Username"
        );

        usernameLabel.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        usernameLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        loginPanel.add(usernameLabel);

        usernameField = new JTextField();

        usernameField.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );

        loginPanel.add(usernameField);

        loginPanel.add(
                Box.createVerticalStrut(15)
        );

        // Password
        JLabel passwordLabel = new JLabel(
                "Password"
        );

        passwordLabel.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        passwordLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();

        passwordField.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );

        loginPanel.add(passwordField);

        loginPanel.add(
                Box.createVerticalStrut(20)
        );

        // Login button
        JButton loginButton = new JButton(
                "Sign In"
        );

        loginButton.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        45
                )
        );

        loginButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        loginButton.setBackground(
                new Color(100, 125, 235)
        );

        loginButton.setForeground(Color.WHITE);

        loginButton.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        loginButton.setFocusPainted(false);

        loginPanel.add(loginButton);

        loginPanel.add(
                Box.createVerticalStrut(12)
        );

        // Message
        messageLabel = new JLabel(" ");

        messageLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        messageLabel.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        loginPanel.add(messageLabel);

        centerPanel.add(loginPanel);

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        add(mainPanel);

        // Login action
        loginButton.addActionListener(
                e -> login()
        );

        passwordField.addActionListener(
                e -> login()
        );
    }

    private void login() {

        String username =
                usernameField.getText().trim();

        String password =
                new String(
                        passwordField.getPassword()
                );

        // Temporary login - database will be added later
        if (username.equals("admin")
                && password.equals("123456")) {

            messageLabel.setForeground(
                    new Color(0, 150, 70)
            );

            messageLabel.setText(
                    "Login successful!"
            );

            dispose();

            new HomeFrame().setVisible(true);

        } else {

            messageLabel.setForeground(
                    Color.RED
            );

            messageLabel.setText(
                    "Invalid username or password."
            );
        }
    }
}



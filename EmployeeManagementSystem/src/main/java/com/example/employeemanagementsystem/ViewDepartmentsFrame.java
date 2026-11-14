package com.example.employeemanagementsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewDepartmentsFrame extends JFrame {

    private JTable departmentTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;

    public ViewDepartmentsFrame() {

        setTitle("Employee Management System - View Departments");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        createUI();
        loadDepartments();
    }

    private void createUI() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setPreferredSize(new Dimension(1000, 80));
        headerPanel.setBackground(new Color(100, 125, 235));

        JLabel titleLabel = new JLabel(
                "View Departments",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 27)
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

        // Search
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.setBackground(Color.WHITE);

        JLabel searchLabel = new JLabel("Search:");

        searchField = new JTextField(25);
        searchField.setPreferredSize(
                new Dimension(250, 35)
        );

        JButton searchButton =
                new JButton("Search");

        JButton showAllButton =
                new JButton("Show All");

        styleButton(searchButton);
        styleButton(showAllButton);

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(showAllButton);

        mainPanel.add(
                searchPanel,
                BorderLayout.PAGE_START
        );

        // Table
        String[] columns = {
                "ID",
                "Name",
                "Email",
                "Phone",
                "Description"
        };

        tableModel = new DefaultTableModel(
                columns,
                0
        ) {
            @Override
            public boolean isCellEditable(
                    int row,
                    int column) {
                return false;
            }
        };

        departmentTable = new JTable(tableModel);
        departmentTable.setRowHeight(30);

        JScrollPane scrollPane =
                new JScrollPane(departmentTable);

        mainPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);

        JButton editButton =
                new JButton("Edit Selected");

        JButton deleteButton =
                new JButton("Delete Selected");

        JButton refreshButton =
                new JButton("Refresh");

        JButton backButton =
                new JButton("Back to Home");

        styleButton(editButton);
        styleButton(deleteButton);
        styleButton(refreshButton);
        styleButton(backButton);

        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);
        buttonPanel.add(backButton);

        mainPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        add(mainPanel);

        // Actions
        searchButton.addActionListener(
                e -> searchDepartments()
        );

        showAllButton.addActionListener(e -> {
            searchField.setText("");
            loadDepartments();
        });

        refreshButton.addActionListener(
                e -> loadDepartments()
        );

        deleteButton.addActionListener(
                e -> deleteSelectedDepartment()
        );

        editButton.addActionListener(
                e -> editSelectedDepartment()
        );

        backButton.addActionListener(e -> {
            dispose();
            new HomeFrame().setVisible(true);
        });

        searchField.addActionListener(
                e -> searchDepartments()
        );
    }

    private void loadDepartments() {

        tableModel.setRowCount(0);

        for (Department department :
                DepartmentManager.getDepartments()) {

            addDepartmentToTable(department);
        }
    }

    private void addDepartmentToTable(
            Department department) {

        tableModel.addRow(
                new Object[]{
                        department.getId(),
                        department.getName(),
                        department.getEmail(),
                        department.getPhone(),
                        department.getDescription()
                }
        );
    }

    private void searchDepartments() {

        String searchText =
                searchField.getText()
                        .trim()
                        .toLowerCase();

        tableModel.setRowCount(0);

        if (searchText.isEmpty()) {
            loadDepartments();
            return;
        }

        for (Department department :
                DepartmentManager.getDepartments()) {

            boolean matches =
                    department.getName()
                            .toLowerCase()
                            .contains(searchText)
                            ||
                            department.getEmail()
                                    .toLowerCase()
                                    .contains(searchText)
                            ||
                            department.getPhone()
                                    .toLowerCase()
                                    .contains(searchText);

            if (matches) {
                addDepartmentToTable(department);
            }
        }

        if (tableModel.getRowCount() == 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "No departments found.",
                    "Search Result",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void deleteSelectedDepartment() {

        int selectedRow =
                departmentTable.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a department first.",
                    "No Department Selected",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int id =
                (int) tableModel.getValueAt(
                        selectedRow,
                        0
                );

        int choice =
                JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete this department?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

        if (choice == JOptionPane.YES_OPTION) {

            DepartmentManager.deleteDepartment(id);

            loadDepartments();

            JOptionPane.showMessageDialog(
                    this,
                    "Department deleted successfully.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void editSelectedDepartment() {

        int selectedRow =
                departmentTable.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a department first.",
                    "No Department Selected",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int id =
                (int) tableModel.getValueAt(
                        selectedRow,
                        0
                );

        Department selectedDepartment = null;

        for (Department department :
                DepartmentManager.getDepartments()) {

            if (department.getId() == id) {

                selectedDepartment = department;
                break;
            }
        }

        if (selectedDepartment != null) {

            new EditDepartmentFrame(
                    selectedDepartment,
                    this
            ).setVisible(true);
        }
    }

    public void refreshTable() {
        loadDepartments();
    }

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



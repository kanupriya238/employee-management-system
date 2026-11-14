package com.example.employeemanagementsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewEmployeesFrame extends JFrame {

    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;

    public ViewEmployeesFrame() {

        setTitle("Employee Management System - View Employees");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        createUI();
        loadEmployees();
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
                "View Employees",
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

        // =========================
        // SEARCH
        // =========================

        JPanel searchPanel = new JPanel(new FlowLayout());

        searchPanel.setBackground(Color.WHITE);

        JLabel searchLabel = new JLabel("Search:");

        searchLabel.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

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

        // =========================
        // TABLE
        // =========================

        String[] columns = {
                "ID",
                "Employee Name",
                "Department",
                "Job Title",
                "Hire Date",
                "Employment Status",
                "Monthly Salary"
        };

        tableModel = new DefaultTableModel(columns, 0) {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column) {

                return false;
            }
        };

        employeeTable = new JTable(tableModel);

        employeeTable.setRowHeight(30);

        employeeTable.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        employeeTable.getTableHeader().setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        JScrollPane scrollPane =
                new JScrollPane(employeeTable);

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 20, 10, 20
                )
        );

        mainPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // =========================
        // BUTTONS
        // =========================

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

        // =========================
        // ACTIONS
        // =========================

        searchButton.addActionListener(
                e -> searchEmployees()
        );

        showAllButton.addActionListener(
                e -> {
                    searchField.setText("");
                    loadEmployees();
                }
        );

        refreshButton.addActionListener(
                e -> loadEmployees()
        );

        editButton.addActionListener(
                e -> editSelectedEmployee()
        );

        deleteButton.addActionListener(
                e -> deleteSelectedEmployee()
        );

        backButton.addActionListener(e -> {

            dispose();

            new HomeFrame().setVisible(true);
        });

        searchField.addActionListener(
                e -> searchEmployees()
        );
    }

    // =========================
    // LOAD EMPLOYEES
    // =========================

    private void loadEmployees() {

        tableModel.setRowCount(0);

        for (Employee employee : EmployeeManager.getEmployees()) {

            addEmployeeToTable(employee);
        }
    }

    // =========================
    // ADD EMPLOYEE TO TABLE
    // =========================

    private void addEmployeeToTable(Employee employee) {

        tableModel.addRow(
                new Object[]{
                        employee.getId(),
                        employee.getEmployeeName(),
                        employee.getDepartment(),
                        employee.getJobTitle(),
                        employee.getHireDate(),
                        employee.getEmploymentStatus(),
                        employee.getSalary()
                }
        );
    }

    // =========================
    // SEARCH
    // =========================

    private void searchEmployees() {

        String searchText =
                searchField.getText()
                        .trim()
                        .toLowerCase();

        tableModel.setRowCount(0);

        if (searchText.isEmpty()) {

            loadEmployees();

            return;
        }

        for (Employee employee : EmployeeManager.getEmployees()) {

            boolean matches =
                    employee.getEmployeeName()
                            .toLowerCase()
                            .contains(searchText)
                            ||
                            employee.getDepartment()
                                    .toLowerCase()
                                    .contains(searchText)
                            || employee.getJobTitle().toLowerCase().contains(searchText)
                            || employee.getEmploymentStatus().toLowerCase().contains(searchText);

            if (matches) {

                addEmployeeToTable(employee);
            }
        }

        if (tableModel.getRowCount() == 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "No employees found.",
                    "Search Result",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // =========================
    // EDIT EMPLOYEE
    // =========================

    private void editSelectedEmployee() {

        int selectedRow =
                employeeTable.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a employee first.",
                    "No Employee Selected",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int id =
                (int) tableModel.getValueAt(
                        selectedRow,
                        0
                );

        Employee selectedEmployee = null;

        for (Employee employee : EmployeeManager.getEmployees()) {

            if (employee.getId() == id) {

                selectedEmployee = employee;

                break;
            }
        }

        if (selectedEmployee != null) {

            new EditEmployeeFrame(
                    selectedEmployee,
                    this
            ).setVisible(true);
        }
    }

    // =========================
    // DELETE EMPLOYEE
    // =========================

    private void deleteSelectedEmployee() {

        int selectedRow =
                employeeTable.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a employee first.",
                    "No Employee Selected",
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
                        "Are you sure you want to delete this employee?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

        if (choice == JOptionPane.YES_OPTION) {

            EmployeeManager.deleteEmployee(id);

            loadEmployees();

            JOptionPane.showMessageDialog(
                    this,
                    "Employee deleted successfully.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
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
    public void refreshTable() {
        loadEmployees();
    }
}



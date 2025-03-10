package gui;

import data_access.StudentManage;
import logic.ButtonManageStudents;
import logic.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class WindowStudents extends JFrame {
    private JTable tableStudents;
    private JScrollPane scrollPane;
    private JTextField searchField;
    private JButton searchButton;
    private JButton addButton;
    private JButton editButton;

    public WindowStudents() {
        setTitle("Lista de Estudiantes");
        this.setBounds(10, 10, 700, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        searchField = new JTextField();
        searchField.setBounds(50, 10, 200, 30);
        this.add(searchField);

        searchButton = new JButton("Buscar");
        searchButton.setBounds(260, 10, 100, 30);
        this.add(searchButton);

        addButton = new JButton("Registrar");
        addButton.setBounds(370, 10, 100, 30);
        this.add(addButton);

        editButton = new JButton("Modificar");
        editButton.setBounds(480, 10, 100, 30);
        this.add(editButton);

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Email");
        model.addColumn("Names");
        model.addColumn("Surnames");
        model.addColumn("Enrollment");

        tableStudents = new JTable(model);
        scrollPane = new JScrollPane(tableStudents);
        scrollPane.setBounds(50, 50, 600, 400);
        this.add(scrollPane);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        setActionListener();
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JTable getTableStudents() {
        return tableStudents;
    }

    public void setActionListener() {
        ButtonManageStudents buttonManageStudents = new ButtonManageStudents(this);
        searchButton.addActionListener(buttonManageStudents);
        addButton.addActionListener(buttonManageStudents);
        editButton.addActionListener(buttonManageStudents);
    }
}
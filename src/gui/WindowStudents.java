package gui;

import data_access.StudentManage;
import logic.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class WindowStudents extends JFrame {
    private JTable tableStudents;
    private JScrollPane scrollPane;

    public WindowStudents() {
        setTitle("Lista de Estudiantes");
        this.setBounds(10, 10, 700, 500);
        this.setLayout(null);

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

        StudentManage studentManage = new StudentManage();
        List<Student> students = studentManage.listAllStudents();
        for (Student student : students) {
            model.addRow(new Object[]{student.getEmail(), student.getNames(), student.getSurnames(), student.getEnrollment()});
        }

        tableStudents = new JTable(model);
        scrollPane = new JScrollPane(tableStudents);
        scrollPane.setBounds(50, 50, 600, 400);

        this.add(scrollPane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
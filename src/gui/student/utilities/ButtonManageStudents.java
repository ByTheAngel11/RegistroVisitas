package gui.student.utilities;

import gui.student.WindowAddStudent;
import gui.student.WindowEditStudent;
import gui.student.WindowStudents;
import data_access.StudentManage;
import logic.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ButtonManageStudents implements ActionListener {
    private WindowStudents windowStudents;
    private TableRowSorter<DefaultTableModel> sorter;

    public ButtonManageStudents(WindowStudents windowStudents) {
        this.windowStudents = windowStudents;
        DefaultTableModel model = (DefaultTableModel) windowStudents.getTableStudents().getModel();
        this.sorter = new TableRowSorter<>(model);
        windowStudents.getTableStudents().setRowSorter(sorter);
        reloadTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == windowStudents.getAddButton()) {
            new WindowAddStudent(windowStudents, this);
        }
        if (e.getSource() == windowStudents.getEditButton()) {
            editSelectedStudent();
        }
        if (e.getSource() == windowStudents.getSearchButton()) {
            searchStudentByEmail();
        }
    }

    private void searchStudentByEmail() {
        String email = windowStudents.getSearchField().getText();
        sorter.setRowFilter(RowFilter.regexFilter(email, 0));
    }

    private void editSelectedStudent() {
        int selectedRow = windowStudents.getTableStudents().getSelectedRow();
        if (selectedRow != -1) {
            String email = (String) windowStudents.getTableStudents().getValueAt(selectedRow, 0);
            String names = (String) windowStudents.getTableStudents().getValueAt(selectedRow, 1);
            String surnames = (String) windowStudents.getTableStudents().getValueAt(selectedRow, 2);
            String enrollment = (String) windowStudents.getTableStudents().getValueAt(selectedRow, 3);

            Student student = new Student(email, names, surnames, enrollment);
            WindowEditStudent windowEditStudent = new WindowEditStudent(student, windowStudents);
            windowEditStudent.getTextFieldEmail().setText(email);
            windowEditStudent.getTextFieldNames().setText(names);
            windowEditStudent.getTextFieldSurnames().setText(surnames);
            windowEditStudent.getTextFieldEnrollment().setText(enrollment);

            ButtonManageEditStudent buttonManageEditStudent = new ButtonManageEditStudent(windowEditStudent, windowStudents, student);
            windowEditStudent.getButtonSave().addActionListener(buttonManageEditStudent);
            windowEditStudent.getButtonCancel().addActionListener(buttonManageEditStudent);
        } else {
            JOptionPane.showMessageDialog(windowStudents, "Seleccione un estudiante para editar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void reloadTable() {
        DefaultTableModel model = (DefaultTableModel) windowStudents.getTableStudents().getModel();
        model.setRowCount(0);

        StudentManage studentManage = new StudentManage();
        List<Student> students = studentManage.listAllStudents();
        for (Student student : students) {
            model.addRow(new Object[]{student.getEmail(), student.getNames(), student.getSurnames(), student.getEnrollment()});
        }
    }
}
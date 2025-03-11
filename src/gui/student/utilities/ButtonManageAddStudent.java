package gui.student.utilities;

import gui.student.WindowAddStudent;
import data_access.StudentManage;
import logic.Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonManageAddStudent implements ActionListener {
    private WindowAddStudent windowAddStudent;
    private StudentManage studentManage;
    private ButtonManageStudents buttonManageStudents;

    public ButtonManageAddStudent(WindowAddStudent windowAddStudent, ButtonManageStudents buttonManageStudents) {
        this.windowAddStudent = windowAddStudent;
        this.studentManage = new StudentManage();
        this.buttonManageStudents = buttonManageStudents;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == windowAddStudent.getButtonSave()) {
            addNewStudent();
        }
        if (e.getSource() == windowAddStudent.getButtonCancel()) {
            windowAddStudent.dispose();
        }
    }

    private void addNewStudent() {
        String email = windowAddStudent.getTextFieldEmail().getText();
        String names = windowAddStudent.getTextFieldNames().getText();
        String surnames = windowAddStudent.getTextFieldSurnames().getText();
        String enrollment = windowAddStudent.getTextFieldEnrollment().getText();

        Student student = new Student(email, names, surnames, enrollment);
        studentManage.addStudent(student);
        System.out.println("Estudiante registrado exitosamente en la base de datos.");
        windowAddStudent.dispose();
        buttonManageStudents.reloadTable();
    }
}
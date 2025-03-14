package gui.student.utilities;

import gui.student.WindowEditStudent;
import gui.student.WindowStudents;
import data_access.StudentManage;
import logic.Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonManageEditStudent implements ActionListener {

    private WindowEditStudent windowEditStudent;
    private WindowStudents windowStudents;
    private StudentManage studentManage;
    private Student student;

    public ButtonManageEditStudent(WindowEditStudent windowEditStudent, WindowStudents windowStudents, Student student) {
        this.windowEditStudent = windowEditStudent;
        this.windowStudents = windowStudents;
        this.studentManage = new StudentManage();
        this.student = student;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == windowEditStudent.getButtonSave()) {
            saveStudentChanges();
        }
        if (e.getSource() == windowEditStudent.getButtonCancel()) {
            windowEditStudent.dispose();
        }
    }

    private void saveStudentChanges() {
        student.setEmail(windowEditStudent.getTextFieldEmail().getText());
        student.setNames(windowEditStudent.getTextFieldNames().getText());
        student.setSurnames(windowEditStudent.getTextFieldSurnames().getText());
        student.setEnrollment(windowEditStudent.getTextFieldEnrollment().getText());

        studentManage.editStudentByEmail(student);
        System.out.println("Estudiante editado exitosamente en la base de datos y en la lista de objetos.");
        windowEditStudent.dispose();
        ButtonManageStudents buttonManageStudents = new ButtonManageStudents(windowStudents);
        buttonManageStudents.reloadTable();
    }
}
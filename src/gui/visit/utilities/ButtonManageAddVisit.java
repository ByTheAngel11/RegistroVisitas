package gui.visit.utilities;

import Exceptions.InvalidDateFormat;
import data_access.StudentManage;
import gui.visit.WindowAddVisit;
import data_access.VisitManage;
import logic.Student;
import logic.Visit;
import Exceptions.EmptyField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.List;

public class ButtonManageAddVisit implements ActionListener {
    private WindowAddVisit windowAddVisit;
    private VisitManage visitManage;
    private ButtonManageVisits buttonManageVisits;

    public ButtonManageAddVisit(WindowAddVisit windowAddVisit, ButtonManageVisits buttonManageVisits) {
        this.windowAddVisit = windowAddVisit;
        this.visitManage = new VisitManage();
        this.buttonManageVisits = buttonManageVisits;
        populateEmailComboBox();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == windowAddVisit.getButtonSave()) {
            try {
                addNewVisit();
            } catch (EmptyField | InvalidDateFormat ex) {
                JOptionPane.showMessageDialog(windowAddVisit, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == windowAddVisit.getButtonCancel()) {
            windowAddVisit.dispose();
        }
    }

    private void addNewVisit() throws EmptyField, InvalidDateFormat {
        String visitSubject = windowAddVisit.getTextFieldVisitSubject().getText();
        String entryDateStr = windowAddVisit.getTextFieldEntryDate().getText();
        String email = (String) windowAddVisit.getComboBoxEmail().getSelectedItem();

        if (visitSubject.isEmpty() || entryDateStr.isEmpty() || email.isEmpty()) {
            throw new EmptyField("Todos los campos deben estar llenos");
        }

        Timestamp entryDate;
        try {
            entryDate = Timestamp.valueOf(entryDateStr);
        } catch (RuntimeException ex) {
            throw new InvalidDateFormat("Formato de fecha incorrecto. Use yyyy/MM/dd HH:mm:ss", ex);
        }

        Visit visit = new Visit(visitSubject, entryDate, email);
        visitManage.addVisitWithDefaultExitDate(visit);
        System.out.println("Visita registrada exitosamente en la base de datos.");
        windowAddVisit.dispose();
        buttonManageVisits.reloadTable();
    }

    private void populateEmailComboBox() {
        StudentManage studentManage = new StudentManage();
        List<Student> students = studentManage.listAllStudents();
        for (Student student : students) {
            windowAddVisit.getComboBoxEmail().addItem(student.getEmail());
        }
    }
}
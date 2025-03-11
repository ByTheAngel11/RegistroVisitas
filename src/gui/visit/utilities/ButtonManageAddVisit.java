package gui.visit.utilities;

import Exceptions.EmptyField;
import Exceptions.InvalidDateFormat;
import gui.utilities.InputValidator;
import gui.visit.WindowAddVisit;
import data_access.VisitManage;
import logic.Visit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

public class ButtonManageAddVisit implements ActionListener {
    private WindowAddVisit windowAddVisit;
    private VisitManage visitManage;
    private ButtonManageVisits buttonManageVisits;

    public ButtonManageAddVisit(WindowAddVisit windowAddVisit, ButtonManageVisits buttonManageVisits) {
        this.windowAddVisit = windowAddVisit;
        this.visitManage = new VisitManage();
        this.buttonManageVisits = buttonManageVisits;
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
        String exitDateStr = windowAddVisit.getTextFieldExitDate().getText();
        String email = (String) windowAddVisit.getComboBoxEmail().getSelectedItem();

        if (visitSubject.isEmpty() || entryDateStr.isEmpty() || exitDateStr.isEmpty() || email == null || email.isEmpty()) {
            throw new EmptyField("Todos los campos deben estar llenos");
        }

        Timestamp entryDate;
        Timestamp exitDate;
        try {
            entryDate = InputValidator.convertStringToTimestamp(entryDateStr);
            exitDate = InputValidator.convertStringToTimestamp(exitDateStr);
        } catch (RuntimeException ex) {
            throw new InvalidDateFormat("Formato de fecha incorrecto. Use yyyy/MM/dd HH:mm:ss", ex);
        }

        Visit visit = new Visit(0, visitSubject, entryDate, exitDate, email);
        visitManage.addVisit(visit);
        System.out.println("Visita registrada exitosamente en la base de datos.");
        windowAddVisit.dispose();
        buttonManageVisits.reloadTable();
    }
}
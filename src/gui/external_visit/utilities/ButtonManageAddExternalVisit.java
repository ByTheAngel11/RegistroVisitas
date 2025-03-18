package gui.external_visit.utilities;

import data_access.ExternalVisitManage;
import gui.external_visit.WindowAddExternalVisit;
import logic.ExternalVisit;
import Exceptions.EmptyField;
import Exceptions.InvalidDateFormat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.List;

public class ButtonManageAddExternalVisit implements ActionListener {
    private WindowAddExternalVisit windowAddExternalVisit;
    private ExternalVisitManage externalVisitManage;
    private ButtonManageExternalVisits buttonManageExternalVisits;

    public ButtonManageAddExternalVisit(WindowAddExternalVisit windowAddExternalVisit, ButtonManageExternalVisits buttonManageExternalVisits) {
        this.windowAddExternalVisit = windowAddExternalVisit;
        this.externalVisitManage = new ExternalVisitManage();
        this.buttonManageExternalVisits = buttonManageExternalVisits;
        loadEmails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == windowAddExternalVisit.getButtonSave()) {
            try {
                addNewExternalVisit();
            } catch (EmptyField | InvalidDateFormat ex) {
                JOptionPane.showMessageDialog(windowAddExternalVisit, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == windowAddExternalVisit.getButtonCancel()) {
            windowAddExternalVisit.dispose();
        }
    }

    private void addNewExternalVisit() throws EmptyField, InvalidDateFormat {
        String visitSubject = windowAddExternalVisit.getTextFieldVisitSubject().getText();
        String entryDateStr = windowAddExternalVisit.getTextFieldEntryDate().getText();
        String email = (String) windowAddExternalVisit.getComboBoxEmail().getSelectedItem();

        if (visitSubject.isEmpty() || entryDateStr.isEmpty() || email.isEmpty()) {
            throw new EmptyField("Todos los campos deben estar llenos");
        }

        Timestamp entryDate;
        try {
            entryDate = Timestamp.valueOf(entryDateStr);
        } catch (RuntimeException ex) {
            throw new InvalidDateFormat("Formato de fecha incorrecto. Use yyyy/MM/dd HH:mm:ss", ex);
        }

        ExternalVisit externalVisit = new ExternalVisit(visitSubject, entryDate, email);
        externalVisitManage.addExternalVisit(externalVisit);
        System.out.println("Visita externa registrada exitosamente en la base de datos.");
        windowAddExternalVisit.dispose();
        buttonManageExternalVisits.reloadTable();
    }

    private void loadEmails() {
        List<ExternalVisit> externalVisits = externalVisitManage.listAllVisits();
        for (ExternalVisit visit : externalVisits) {
            windowAddExternalVisit.getComboBoxEmail().addItem(visit.getEmail());
        }
    }
}
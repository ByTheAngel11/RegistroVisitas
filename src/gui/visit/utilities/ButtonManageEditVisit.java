package gui.visit.utilities;

import gui.visit.WindowEditVisit;
import gui.visit.WindowVisits;
import data_access.VisitManage;
import logic.Visit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

public class ButtonManageEditVisit implements ActionListener {

    private WindowEditVisit windowEditVisit;
    private VisitManage visitManage;
    private Visit visit;
    private WindowVisits windowVisits;

    public ButtonManageEditVisit(WindowEditVisit windowEditVisit, Visit visit, WindowVisits windowVisits) {
        this.windowEditVisit = windowEditVisit;
        this.visitManage = new VisitManage();
        this.visit = visit;
        this.windowVisits = windowVisits;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == windowEditVisit.getButtonSave()) {
            saveVisitChanges();
        }
        if (e.getSource() == windowEditVisit.getButtonCancel()) {
            windowEditVisit.dispose();
        }
    }

    private void saveVisitChanges() {
        visit.setVisitSubject(windowEditVisit.getTextFieldVisitSubject().getText());
        visit.setEntryDate(Timestamp.valueOf(windowEditVisit.getTextFieldEntryDate().getText()));
        String exitDateStr = windowEditVisit.getTextFieldExitDate().getText();
        visit.setExitDate(exitDateStr.isEmpty() ? null : Timestamp.valueOf(exitDateStr));
        visit.setEmail(windowEditVisit.getTextFieldEmail().getText());

        visitManage.editVisitByNumeroVisita(visit);
        System.out.println("Visita editada exitosamente en la base de datos y en la lista de objetos.");
        windowEditVisit.dispose();
        windowVisits.getButtonManageVisits().reloadTable();
    }
}
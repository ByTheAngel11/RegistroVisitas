package gui.external_visit;

import data_access.ExternalVisitManage;
import logic.ExternalVisit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

public class ButtonManageEditExternalVisit implements ActionListener {

    private WindowEditExternalVisit windowEditExternalVisit;
    private ExternalVisitManage externalVisitManage;
    private ExternalVisit externalVisit;
    private WindowExternalVisits windowExternalVisits;

    public ButtonManageEditExternalVisit(WindowEditExternalVisit windowEditExternalVisit, ExternalVisit externalVisit, WindowExternalVisits windowExternalVisits) {
        this.windowEditExternalVisit = windowEditExternalVisit;
        this.externalVisitManage = new ExternalVisitManage();
        this.externalVisit = externalVisit;
        this.windowExternalVisits = windowExternalVisits;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == windowEditExternalVisit.getButtonSave()) {
            saveExternalVisitChanges();
        }
        if (e.getSource() == windowEditExternalVisit.getButtonCancel()) {
            windowEditExternalVisit.dispose();
        }
    }

    private void saveExternalVisitChanges() {
        externalVisit.setVisitSubject(windowEditExternalVisit.getTextFieldVisitSubject().getText());
        externalVisit.setEntryDate(Timestamp.valueOf(windowEditExternalVisit.getTextFieldEntryDate().getText()));
        String exitDateStr = windowEditExternalVisit.getTextFieldExitDate().getText();
        externalVisit.setExitDate(exitDateStr.isEmpty() ? null : Timestamp.valueOf(exitDateStr));
        externalVisit.setEmail(windowEditExternalVisit.getTextFieldEmail().getText());

        externalVisitManage.editVisitByVisitNumber(externalVisit);
        System.out.println("Visita externa editada exitosamente en la base de datos y en la lista de objetos.");
        windowEditExternalVisit.dispose();
        windowExternalVisits.getButtonManageExternalVisits().reloadTable();
    }
}
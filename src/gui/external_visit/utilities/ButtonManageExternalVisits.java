package gui.external_visit.utilities;

import data_access.ExternalVisitManage;
import gui.external_visit.WindowExternalVisits;
import gui.external_visit.WindowAddExternalVisit;
import gui.external_visit.WindowEditExternalVisit;
import data_access.ExternalManage;
import logic.ExternalVisit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ButtonManageExternalVisits implements ActionListener {
    private WindowExternalVisits windowExternalVisits;
    private TableRowSorter<DefaultTableModel> sorter;

    public ButtonManageExternalVisits(WindowExternalVisits windowExternalVisits) {
        this.windowExternalVisits = windowExternalVisits;
        DefaultTableModel model = new DefaultTableModel();
        this.sorter = new TableRowSorter<>(model);
        windowExternalVisits.getTableExternalVisits().setRowSorter(sorter);
        reloadTable();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == windowExternalVisits.getAddButton()) {
            new WindowAddExternalVisit(windowExternalVisits, this);
        }
        if (e.getSource() == windowExternalVisits.getEditButton()) {
            //TODO
        }
        if (e.getSource() == windowExternalVisits.getSearchButton()) {
            searchVisitByEmail();
        }

    }

    private void searchVisitByEmail() {
        String email = windowExternalVisits.getSearchTextField().getText();
        sorter.setRowFilter(RowFilter.regexFilter(email, 4));
    }

    public void reloadTable() {
        DefaultTableModel model = (DefaultTableModel) windowExternalVisits.getTableExternalVisits().getModel();
        model.setRowCount(0);

        ExternalVisitManage externalVisitManage = new ExternalVisitManage();
        List<ExternalVisit> externalVisits = externalVisitManage.listAllVisits();
        for (ExternalVisit externalVisit : externalVisits) {
            model.addRow(new Object[]{externalVisit.getVisitNumber(), externalVisit.getVisitSubject(),
                    externalVisit.getEntryDate(), externalVisit.getExitDate(), externalVisit.getEmail()});
        }
    }

}

package gui.external_visit;

import data_access.ExternalVisitManage;
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
        DefaultTableModel model = (DefaultTableModel) windowExternalVisits.getTableExternalVisits().getModel();
        this.sorter = new TableRowSorter<>(model);
        windowExternalVisits.getTableExternalVisits().setRowSorter(sorter);
        reloadTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == windowExternalVisits.getAddButton()) {
            new WindowAddExternalVisit(windowExternalVisits, this);
        }
        if (e.getSource() == windowExternalVisits.getEditButton()) {
            int selectedRow = windowExternalVisits.getTableExternalVisits().getSelectedRow();
            if (selectedRow != -1) {
                int visitNumber = (int) windowExternalVisits.getTableExternalVisits().getValueAt(selectedRow, 0);
                ExternalVisitManage externalVisitManage = new ExternalVisitManage();
                ExternalVisit externalVisit = externalVisitManage.getVisitByVisitNumber(visitNumber);
                new WindowEditExternalVisit(externalVisit, windowExternalVisits);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una visita para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == windowExternalVisits.getSearchButton()) {
            searchVisitByEmail();
        }
    }

    private void searchVisitByEmail() {
        String email = windowExternalVisits.getSearchField().getText();
        sorter.setRowFilter(RowFilter.regexFilter(email, 4));
    }

    public void reloadTable() {
        DefaultTableModel model = (DefaultTableModel) windowExternalVisits.getTableExternalVisits().getModel();
        model.setRowCount(0); // Clear existing data

        ExternalVisitManage externalVisitManage = new ExternalVisitManage();
        List<ExternalVisit> externalVisits = externalVisitManage.listAllVisits();
        for (ExternalVisit externalVisit : externalVisits) {
            model.addRow(new Object[]{externalVisit.getVisitNumber(), externalVisit.getVisitSubject(),
                    externalVisit.getEntryDate(), externalVisit.getExitDate(), externalVisit.getEmail()});
        }
    }
}
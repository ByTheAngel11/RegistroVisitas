package gui.visit.utilities;

import gui.visit.WindowAddVisit;
import gui.visit.WindowEditVisit;
import gui.visit.WindowVisits;
import data_access.VisitManage;
import logic.Visit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ButtonManageVisits implements ActionListener {
    private WindowVisits windowVisits;
    private TableRowSorter<DefaultTableModel> sorter;

    public ButtonManageVisits(WindowVisits windowVisits) {
        this.windowVisits = windowVisits;
        DefaultTableModel model = (DefaultTableModel) windowVisits.getTableVisits().getModel();
        this.sorter = new TableRowSorter<>(model);
        windowVisits.getTableVisits().setRowSorter(sorter);
        reloadTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == windowVisits.getAddButton()) {
            new WindowAddVisit(windowVisits, this);
        }
        if (e.getSource() == windowVisits.getEditButton()) {
            int selectedRow = windowVisits.getTableVisits().getSelectedRow();
            if (selectedRow != -1) {
                int visitNumber = (int) windowVisits.getTableVisits().getValueAt(selectedRow, 0);
                VisitManage visitManage = new VisitManage();
                Visit visit = visitManage.getVisitByNumeroVisita(visitNumber);
                new WindowEditVisit(visit, windowVisits);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una visita para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == windowVisits.getSearchButton()) {
            searchVisitByEmail();
        }
    }

    private void searchVisitByEmail() {
        String email = windowVisits.getSearchField().getText();
        sorter.setRowFilter(RowFilter.regexFilter(email, 4));
    }

    public void reloadTable() {
        DefaultTableModel model = (DefaultTableModel) windowVisits.getTableVisits().getModel();
        model.setRowCount(0); // Clear existing data

        VisitManage visitManage = new VisitManage();
        List<Visit> visits = visitManage.listAllVisits();
        for (Visit visit : visits) {
            model.addRow(new Object[]{visit.getVisitNumber(), visit.getVisitSubject(),
                    visit.getEntryDate(), visit.getExitDate(), visit.getEmail()});
        }
    }
}
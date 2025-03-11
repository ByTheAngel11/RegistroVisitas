// src/logic/ButtonManageExternal.java
package gui.external.utilities;

import data_access.ExternalManage;
import gui.external.WindowAddExternal;
import gui.external.WindowEditExternal;
import gui.external.WindowExternals;
import logic.External;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ButtonManageExternal implements ActionListener {
    private WindowExternals windowExternals;
    private TableRowSorter<DefaultTableModel> sorter;

    public ButtonManageExternal(WindowExternals windowExternals) {
        this.windowExternals = windowExternals;
        DefaultTableModel model = (DefaultTableModel) windowExternals.getTableExternals().getModel();
        this.sorter = new TableRowSorter<>(model);
        windowExternals.getTableExternals().setRowSorter(sorter);
        reloadTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == windowExternals.getAddButton()) {
            new WindowAddExternal(windowExternals);
        }
        if (e.getSource() == windowExternals.getEditButton()) {
            editSelectedExternal();
        }
        if (e.getSource() == windowExternals.getSearchButton()) {
            searchExternalByEmail();
        }
    }

    private void searchExternalByEmail() {
        String email = windowExternals.getSearchField().getText();
        sorter.setRowFilter(RowFilter.regexFilter(email, 0));
    }

    private void editSelectedExternal() {
        int selectedRow = windowExternals.getTableExternals().getSelectedRow();
        if (selectedRow != -1) {
            String email = (String) windowExternals.getTableExternals().getValueAt(selectedRow, 0);
            String names = (String) windowExternals.getTableExternals().getValueAt(selectedRow, 1);
            String surnames = (String) windowExternals.getTableExternals().getValueAt(selectedRow, 2);
            String officialIdentification = (String) windowExternals.getTableExternals().getValueAt(selectedRow, 3);

            External external = new External(email, names, surnames, officialIdentification);
            WindowEditExternal windowEditExternal = new WindowEditExternal();
            windowEditExternal.getTextFieldEmail().setText(email);
            windowEditExternal.getTextFieldNames().setText(names);
            windowEditExternal.getTextFieldSurnames().setText(surnames);
            windowEditExternal.getTextFieldOfficialIdentification().setText(officialIdentification);

            ButtonManageEditExternal buttonManageEditExternal = new ButtonManageEditExternal(windowEditExternal, windowExternals, external);
            windowEditExternal.getButtonSave().addActionListener(buttonManageEditExternal);
            windowEditExternal.getButtonCancel().addActionListener(buttonManageEditExternal);
        } else {
            JOptionPane.showMessageDialog(windowExternals, "Seleccione un externo para editar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void reloadTable() {
        DefaultTableModel model = (DefaultTableModel) windowExternals.getTableExternals().getModel();
        model.setRowCount(0); // Clear existing data

        ExternalManage externalManage = new ExternalManage();
        List<External> externals = externalManage.listAllExternals();
        for (External external : externals) {
            model.addRow(new Object[]{external.getEmail(), external.getNames(), external.getSurnames(), external.getOfficialIdentification()});
        }
    }
}
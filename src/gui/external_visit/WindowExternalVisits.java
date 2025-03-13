package gui.external_visit;

import data_access.ExternalVisitManage;
import gui.external_visit.utilities.ButtonManageExternalVisits;
import logic.ExternalVisit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class WindowExternalVisits extends JFrame {
    private JTable tableExternalVisits;
    private JButton addButton;
    private JButton searchButton;
    private JButton editButton;
    private JTextField searchTextField;
    private ButtonManageExternalVisits buttonManageExternalVisits;

    public WindowExternalVisits() {
        setTitle("Lista de Visitas Externas");
        this.setBounds(10, 10, 700, 500);
        this.setLayout(null);

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Visit Number");
        model.addColumn("Visit Subject");
        model.addColumn("Entry Date");
        model.addColumn("Exit Date");
        model.addColumn("Email");

        ExternalVisitManage externalVisitManage = new ExternalVisitManage();
        List<ExternalVisit> externalVisits = externalVisitManage.listAllVisits();
        for (ExternalVisit visit : externalVisits) {
            model.addRow(new Object[]{visit.getVisitNumber(), visit.getVisitSubject(), visit.getEntryDate(), visit.getExitDate(), visit.getEmail()});
        }

        tableExternalVisits = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableExternalVisits);
        scrollPane.setBounds(50, 50, 600, 400);

        this.add(scrollPane);

        ButtonManageExternalVisits buttonManageExternalVisits = new ButtonManageExternalVisits(this);
        addButton.addActionListener(buttonManageExternalVisits);
        searchButton.addActionListener(buttonManageExternalVisits);
        editButton.addActionListener(buttonManageExternalVisits);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    public JTable getTableExternalVisits() {
        return tableExternalVisits;
    }

    public void setTableExternalVisits(JTable tableExternalVisits) {
        this.tableExternalVisits = tableExternalVisits;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

    public JTextField getSearchTextField() {
        return searchTextField;
    }

    public void setSearchTextField(JTextField searchTextField) {
        this.searchTextField = searchTextField;
    }

    public ButtonManageExternalVisits getButtonManageExternalVisits() {
        return buttonManageExternalVisits;
    }

}
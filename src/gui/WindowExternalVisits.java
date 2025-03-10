package gui;

import data_access.ExternalVisitManage;
import logic.ExternalVisit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class WindowExternalVisits extends JFrame {
    private JTable tableExternalVisits;
    private JScrollPane scrollPane;

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
        scrollPane = new JScrollPane(tableExternalVisits);
        scrollPane.setBounds(50, 50, 600, 400);

        this.add(scrollPane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
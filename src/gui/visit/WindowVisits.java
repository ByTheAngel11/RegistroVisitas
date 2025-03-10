package gui.visit;

import data_access.VisitManage;
import logic.Visit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class WindowVisits extends JFrame {
    private JTable tableVisits;
    private JScrollPane scrollPane;

    public WindowVisits() {
        setTitle("Lista de Visitas");
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

        VisitManage visitManage = new VisitManage();
        List<Visit> visits = visitManage.listAllVisits();
        for (Visit visit : visits) {
            model.addRow(new Object[]{visit.getVisitNumber(), visit.getVisitSubject(), visit.getEntryDate(), visit.getExitDate(), visit.getEmail()});
        }

        tableVisits = new JTable(model);
        scrollPane = new JScrollPane(tableVisits);
        scrollPane.setBounds(50, 50, 600, 400);

        this.add(scrollPane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
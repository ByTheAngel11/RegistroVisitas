package gui;

import data_access.ExternalManage;
import logic.External;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class WindowExternals extends JFrame {
    private JTable tableExternals;
    private JScrollPane scrollPane;

    public WindowExternals() {
        setTitle("Lista de Externos");
        this.setBounds(10, 10, 700, 500);
        this.setLayout(null);

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Email");
        model.addColumn("Names");
        model.addColumn("Surnames");
        model.addColumn("Official Identification");

        ExternalManage externalManage = new ExternalManage();
        List<External> externals = externalManage.listAllExternals();
        for (External external : externals) {
            model.addRow(new Object[]{external.getEmail(), external.getNames(), external.getSurnames(), external.getOfficialIdentification()});
        }

        tableExternals = new JTable(model);
        scrollPane = new JScrollPane(tableExternals);
        scrollPane.setBounds(50, 50, 600, 400);

        this.add(scrollPane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
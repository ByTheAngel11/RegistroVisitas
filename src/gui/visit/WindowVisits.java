package gui.visit;

import gui.visit.utilities.ButtonManageVisits;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class WindowVisits extends JFrame {
    private JTable tableVisits;
    private JScrollPane scrollPane;
    private JTextField searchField;
    private JButton searchButton;
    private JButton addButton;
    private JButton editButton;

    public WindowVisits() {
        setTitle("Lista de Visitas");
        this.setBounds(10, 10, 700, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        searchField = new JTextField();
        searchField.setBounds(50, 10, 200, 30);
        this.add(searchField);

        searchButton = new JButton("Buscar");
        searchButton.setBounds(260, 10, 100, 30);
        this.add(searchButton);

        addButton = new JButton("Registrar");
        addButton.setBounds(370, 10, 100, 30);
        this.add(addButton);

        editButton = new JButton("Modificar");
        editButton.setBounds(480, 10, 100, 30);
        this.add(editButton);

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

        tableVisits = new JTable(model);
        scrollPane = new JScrollPane(tableVisits);
        scrollPane.setBounds(50, 50, 600, 400);
        this.add(scrollPane);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        setActionListener();
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JTable getTableVisits() {
        return tableVisits;
    }

    public void setActionListener() {
        ButtonManageVisits buttonManageVisits = new ButtonManageVisits(this);
        searchButton.addActionListener(buttonManageVisits);
        addButton.addActionListener(buttonManageVisits);
        editButton.addActionListener(buttonManageVisits);
    }
}
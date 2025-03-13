package gui.visit;

import gui.visit.utilities.ButtonManageVisits;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class WindowVisits extends JFrame {
    private JTable tableVisits;
    private JButton addButton;
    private JButton editButton;
    private JButton searchButton;
    private JTextField searchField;
    private ButtonManageVisits buttonManageVisits;

    public WindowVisits() {
        setTitle("Visitas");
        this.setBounds(10, 10, 800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        addButton = new JButton("Agregar");
        addButton.setBounds(30, 10, 100, 30);
        this.add(addButton);

        editButton = new JButton("Editar");
        editButton.setBounds(140, 10, 100, 30);
        this.add(editButton);

        searchField = new JTextField();
        searchField.setBounds(250, 10, 150, 30);
        this.add(searchField);

        searchButton = new JButton("Buscar");
        searchButton.setBounds(410, 10, 100, 30);
        this.add(searchButton);

        tableVisits = new JTable(new DefaultTableModel(new Object[]{"Número", "Asunto", "Fecha Entrada", "Fecha Salida", "Correo"}, 0));
        JScrollPane scrollPane = new JScrollPane(tableVisits);
        scrollPane.setBounds(30, 50, 700, 500);
        this.add(scrollPane);

        buttonManageVisits = new ButtonManageVisits(this);
        addButton.addActionListener(buttonManageVisits);
        editButton.addActionListener(buttonManageVisits);
        searchButton.addActionListener(buttonManageVisits);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JTable getTableVisits() {
        return tableVisits;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public ButtonManageVisits getButtonManageVisits() {
        return buttonManageVisits;
    }
}
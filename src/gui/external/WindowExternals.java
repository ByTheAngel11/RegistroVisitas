package gui.external;

import gui.external.utilities.ButtonManageExternal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class WindowExternals extends JFrame {
    private JTable tableExternals;
    private JButton addButton;
    private JButton editButton;
    private JButton searchButton;
    private JTextField searchField;

    public WindowExternals() {
        setTitle("Gestionar Externos");
        this.setBounds(10, 10, 800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        JLabel labelSearch = new JLabel("Buscar por Email:");
        labelSearch.setBounds(20, 20, 150, 30);
        this.add(labelSearch);

        searchField = new JTextField();
        searchField.setBounds(150, 20, 200, 30);
        this.add(searchField);

        searchButton = new JButton("Buscar");
        searchButton.setBounds(360, 20, 100, 30);
        this.add(searchButton);

        addButton = new JButton("Agregar");
        addButton.setBounds(470, 20, 100, 30);
        this.add(addButton);

        editButton = new JButton("Editar");
        editButton.setBounds(580, 20, 100, 30);
        this.add(editButton);

        tableExternals = new JTable(new DefaultTableModel(new Object[]{"Email", "Nombres", "Apellidos", "Identificación Oficial"}, 0));
        JScrollPane scrollPane = new JScrollPane(tableExternals);
        scrollPane.setBounds(20, 60, 760, 500);
        this.add(scrollPane);

        ButtonManageExternal buttonManageExternal = new ButtonManageExternal(this);
        addButton.addActionListener(buttonManageExternal);
        editButton.addActionListener(buttonManageExternal);
        searchButton.addActionListener(buttonManageExternal);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public JTable getTableExternals() {
        return tableExternals;
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
}
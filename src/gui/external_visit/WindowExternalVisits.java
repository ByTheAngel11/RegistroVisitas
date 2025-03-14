package gui.external_visit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class WindowExternalVisits extends JFrame {
    private JTable tableExternalVisits;
    private JButton addButton;
    private JButton editButton;
    private JButton searchButton;
    private JTextField searchField;
    private ButtonManageExternalVisits buttonManageExternalVisits;

    public WindowExternalVisits() {
        setTitle("Visitas Externas");
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

        tableExternalVisits = new JTable(new DefaultTableModel(new Object[]{"Número", "Asunto", "Fecha Entrada", "Fecha Salida", "Correo"}, 0));
        JScrollPane scrollPane = new JScrollPane(tableExternalVisits);
        scrollPane.setBounds(30, 50, 700, 500);
        this.add(scrollPane);

        buttonManageExternalVisits = new ButtonManageExternalVisits(this);
        addButton.addActionListener(buttonManageExternalVisits);
        editButton.addActionListener(buttonManageExternalVisits);
        searchButton.addActionListener(buttonManageExternalVisits);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JTable getTableExternalVisits() {
        return tableExternalVisits;
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

    public ButtonManageExternalVisits getButtonManageExternalVisits() {
        return buttonManageExternalVisits;
    }
}
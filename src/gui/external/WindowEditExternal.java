// src/gui/WindowEditExternal.java
package gui.external;

import javax.swing.*;

public class WindowEditExternal extends JFrame {
    private JTextField textFieldEmail;
    private JTextField textFieldNames;
    private JTextField textFieldSurnames;
    private JTextField textFieldOfficialIdentification;
    private JButton buttonSave;
    private JButton buttonCancel;

    public WindowEditExternal() {
        setTitle("Editar Externo");
        this.setBounds(10, 10, 400, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(20, 20, 100, 30);
        this.add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(150, 20, 200, 30);
        textFieldEmail.setEditable(false);
        this.add(textFieldEmail);

        JLabel labelNames = new JLabel("Nombres:");
        labelNames.setBounds(20, 60, 100, 30);
        this.add(labelNames);

        textFieldNames = new JTextField();
        textFieldNames.setBounds(150, 60, 200, 30);
        this.add(textFieldNames);

        JLabel labelSurnames = new JLabel("Apellidos:");
        labelSurnames.setBounds(20, 100, 100, 30);
        this.add(labelSurnames);

        textFieldSurnames = new JTextField();
        textFieldSurnames.setBounds(150, 100, 200, 30);
        this.add(textFieldSurnames);

        JLabel labelOfficialIdentification = new JLabel("Identificación Oficial:");
        labelOfficialIdentification.setBounds(20, 140, 150, 30);
        this.add(labelOfficialIdentification);

        textFieldOfficialIdentification = new JTextField();
        textFieldOfficialIdentification.setBounds(150, 140, 200, 30);
        this.add(textFieldOfficialIdentification);

        buttonSave = new JButton("Guardar");
        buttonSave.setBounds(50, 200, 100, 30);
        this.add(buttonSave);

        buttonCancel = new JButton("Cancelar");
        buttonCancel.setBounds(200, 200, 100, 30);
        this.add(buttonCancel);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public JTextField getTextFieldEmail() {
        return textFieldEmail;
    }

    public JTextField getTextFieldNames() {
        return textFieldNames;
    }

    public JTextField getTextFieldSurnames() {
        return textFieldSurnames;
    }

    public JTextField getTextFieldOfficialIdentification() {
        return textFieldOfficialIdentification;
    }

    public JButton getButtonSave() {
        return buttonSave;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }
}
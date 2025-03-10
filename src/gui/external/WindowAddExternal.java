// src/gui/WindowAddExternal.java
package gui.external;

import javax.swing.*;

public class WindowAddExternal extends JFrame {
    private JLabel labelEmail;
    private JLabel labelNames;
    private JLabel labelSurnames;
    private JLabel labelOfficialIdentification;
    private JTextField textFieldEmail;
    private JTextField textFieldNames;
    private JTextField textFieldSurnames;
    private JTextField textFieldOfficialIdentification;
    private JButton buttonSave;
    private JButton buttonCancel;

    public WindowAddExternal(WindowExternals windowExternals) {
        setTitle("Registrar Externo");
        this.setBounds(10, 10, 700, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        labelEmail = new JLabel("Email");
        labelEmail.setBounds(50, 50, 100, 30);
        this.add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(150, 50, 200, 30);
        this.add(textFieldEmail);

        labelNames = new JLabel("Nombres");
        labelNames.setBounds(50, 100, 100, 30);
        this.add(labelNames);

        textFieldNames = new JTextField();
        textFieldNames.setBounds(150, 100, 200, 30);
        this.add(textFieldNames);

        labelSurnames = new JLabel("Apellidos");
        labelSurnames.setBounds(50, 150, 100, 30);
        this.add(labelSurnames);

        textFieldSurnames = new JTextField();
        textFieldSurnames.setBounds(150, 150, 200, 30);
        this.add(textFieldSurnames);

        labelOfficialIdentification = new JLabel("Identificación Oficial");
        labelOfficialIdentification.setBounds(50, 200, 150, 30);
        this.add(labelOfficialIdentification);

        textFieldOfficialIdentification = new JTextField();
        textFieldOfficialIdentification.setBounds(200, 200, 200, 30);
        this.add(textFieldOfficialIdentification);

        buttonSave = new JButton("Guardar");
        buttonSave.setBounds(150, 250, 100, 30);
        this.add(buttonSave);

        buttonCancel = new JButton("Cancelar");
        buttonCancel.setBounds(260, 250, 100, 30);
        this.add(buttonCancel);

        setActionListener(windowExternals);

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

    private void setActionListener(WindowExternals windowExternals) {
        ButtonManageAddExternal buttonManageAddExternal = new ButtonManageAddExternal(this, windowExternals);
        buttonSave.addActionListener(buttonManageAddExternal);
        buttonCancel.addActionListener(buttonManageAddExternal);
    }
}
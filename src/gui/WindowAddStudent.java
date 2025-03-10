// src/gui/WindowAddStudent.java
package gui;

import logic.ButtonManageAddStudent;
import logic.ButtonManageStudents;

import javax.swing.*;

public class WindowAddStudent extends JFrame {
    private JLabel labelEmail;
    private JLabel labelNames;
    private JLabel labelSurnames;
    private JLabel labelEnrollment;
    private JTextField textFieldEmail;
    private JTextField textFieldNames;
    private JTextField textFieldSurnames;
    private JTextField textFieldEnrollment;
    private JButton buttonSave;
    private JButton buttonCancel;

    public WindowAddStudent(WindowStudents windowStudents, ButtonManageStudents buttonManageStudents) {
        setTitle("Registrar Estudiante");
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

        labelEnrollment = new JLabel("Matrícula");
        labelEnrollment.setBounds(50, 200, 100, 30);
        this.add(labelEnrollment);

        textFieldEnrollment = new JTextField();
        textFieldEnrollment.setBounds(150, 200, 200, 30);
        this.add(textFieldEnrollment);

        buttonSave = new JButton("Guardar");
        buttonSave.setBounds(150, 250, 100, 30);
        this.add(buttonSave);

        buttonCancel = new JButton("Cancelar");
        buttonCancel.setBounds(260, 250, 100, 30);
        this.add(buttonCancel);

        setActionListener(windowStudents, buttonManageStudents);

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

    public JTextField getTextFieldEnrollment() {
        return textFieldEnrollment;
    }

    public JButton getButtonSave() {
        return buttonSave;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    private void setActionListener(WindowStudents windowStudents, ButtonManageStudents buttonManageStudents) {
        ButtonManageAddStudent buttonManageAddStudent = new ButtonManageAddStudent(this, buttonManageStudents);
        buttonSave.addActionListener(buttonManageAddStudent);
        buttonCancel.addActionListener(buttonManageAddStudent);
    }
}
package gui.visit;

import gui.visit.utilities.ButtonManageEditVisit;
import logic.Visit;

import javax.swing.*;

public class WindowEditVisit extends JFrame {
    private int visitNumber;
    private JLabel labelVisitSubject;
    private JLabel labelEntryDate;
    private JLabel labelExitDate;
    private JLabel labelEmail;
    private JTextField textFieldVisitSubject;
    private JTextField textFieldEntryDate;
    private JTextField textFieldExitDate;
    private JTextField textFieldEmail;
    private JButton buttonSave;
    private JButton buttonCancel;

    public WindowEditVisit(Visit visit, WindowVisits windowVisits) {
        this.visitNumber = visit.getVisitNumber();
        setTitle("Modificar Visita");
        this.setBounds(10, 10, 700, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        labelVisitSubject = new JLabel("Asunto de la Visita");
        labelVisitSubject.setBounds(50, 50, 150, 30);
        this.add(labelVisitSubject);

        textFieldVisitSubject = new JTextField(visit.getVisitSubject());
        textFieldVisitSubject.setBounds(200, 50, 200, 30);
        this.add(textFieldVisitSubject);

        labelEntryDate = new JLabel("Fecha de Entrada");
        labelEntryDate.setBounds(50, 100, 150, 30);
        this.add(labelEntryDate);

        textFieldEntryDate = new JTextField(visit.getEntryDate().toString());
        textFieldEntryDate.setBounds(200, 100, 200, 30);
        this.add(textFieldEntryDate);

        labelExitDate = new JLabel("Fecha de Salida");
        labelExitDate.setBounds(50, 150, 150, 30);
        this.add(labelExitDate);

        textFieldExitDate = new JTextField(visit.getExitDate() != null ? visit.getExitDate().toString() : "");
        textFieldExitDate.setBounds(200, 150, 200, 30);
        this.add(textFieldExitDate);

        labelEmail = new JLabel("Correo");
        labelEmail.setBounds(50, 200, 150, 30);
        this.add(labelEmail);

        textFieldEmail = new JTextField(visit.getEmail());
        textFieldEmail.setBounds(200, 200, 200, 30);
        this.add(textFieldEmail);

        buttonSave = new JButton("Guardar");
        buttonSave.setBounds(150, 250, 100, 30);
        this.add(buttonSave);

        buttonCancel = new JButton("Cancelar");
        buttonCancel.setBounds(260, 250, 100, 30);
        this.add(buttonCancel);

        ButtonManageEditVisit buttonManageEditVisit = new ButtonManageEditVisit(this, visit, windowVisits);
        buttonSave.addActionListener(buttonManageEditVisit);
        buttonCancel.addActionListener(buttonManageEditVisit);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public int getVisitNumber() {
        return visitNumber;
    }

    public JTextField getTextFieldVisitSubject() {
        return textFieldVisitSubject;
    }

    public JTextField getTextFieldEntryDate() {
        return textFieldEntryDate;
    }

    public JTextField getTextFieldExitDate() {
        return textFieldExitDate;
    }

    public JTextField getTextFieldEmail() {
        return textFieldEmail;
    }

    public JButton getButtonSave() {
        return buttonSave;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }
}
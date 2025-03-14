package gui.external_visit;

import gui.external_visit.utilities.ButtonManageEditExternalVisit;
import logic.ExternalVisit;

import javax.swing.*;

public class WindowEditExternalVisit extends JFrame {
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

    public WindowEditExternalVisit(ExternalVisit externalVisit, WindowExternalVisits windowExternalVisits) {
        this.visitNumber = externalVisit.getVisitNumber();
        setTitle("Modificar Visita Externa");
        this.setBounds(10, 10, 700, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        labelVisitSubject = new JLabel("Asunto de la Visita");
        labelVisitSubject.setBounds(50, 50, 150, 30);
        this.add(labelVisitSubject);

        textFieldVisitSubject = new JTextField(externalVisit.getVisitSubject());
        textFieldVisitSubject.setBounds(200, 50, 200, 30);
        this.add(textFieldVisitSubject);

        labelEntryDate = new JLabel("Fecha de Entrada");
        labelEntryDate.setBounds(50, 100, 150, 30);
        this.add(labelEntryDate);

        textFieldEntryDate = new JTextField(externalVisit.getEntryDate().toString());
        textFieldEntryDate.setBounds(200, 100, 200, 30);
        this.add(textFieldEntryDate);

        labelExitDate = new JLabel("Fecha de Salida");
        labelExitDate.setBounds(50, 150, 150, 30);
        this.add(labelExitDate);

        textFieldExitDate = new JTextField(externalVisit.getExitDate() != null ? externalVisit.getExitDate().toString() : "");
        textFieldExitDate.setBounds(200, 150, 200, 30);
        this.add(textFieldExitDate);

        labelEmail = new JLabel("Correo");
        labelEmail.setBounds(50, 200, 150, 30);
        this.add(labelEmail);

        textFieldEmail = new JTextField(externalVisit.getEmail());
        textFieldEmail.setBounds(200, 200, 200, 30);
        this.add(textFieldEmail);

        buttonSave = new JButton("Guardar");
        buttonSave.setBounds(150, 250, 100, 30);
        this.add(buttonSave);

        buttonCancel = new JButton("Cancelar");
        buttonCancel.setBounds(260, 250, 100, 30);
        this.add(buttonCancel);

        ButtonManageEditExternalVisit buttonManageEditExternalVisit = new ButtonManageEditExternalVisit(this, externalVisit, windowExternalVisits);
        buttonSave.addActionListener(buttonManageEditExternalVisit);
        buttonCancel.addActionListener(buttonManageEditExternalVisit);

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
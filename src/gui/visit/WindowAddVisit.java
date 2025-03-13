package gui.visit;

import gui.visit.utilities.ButtonManageAddVisit;
import gui.visit.utilities.ButtonManageVisits;
import gui.utilities.PlaceholderTextField;

import javax.swing.*;

public class WindowAddVisit extends JFrame {
    private JLabel labelVisitSubject;
    private JLabel labelEntryDate;
    private JLabel labelEmail;
    private JTextField textFieldVisitSubject;
    private PlaceholderTextField textFieldEntryDate;
    private JComboBox<String> comboBoxEmail;
    private JButton buttonSave;
    private JButton buttonCancel;

    public WindowAddVisit(WindowVisits windowVisits, ButtonManageVisits buttonManageVisits) {
        setTitle("Registrar Visita");
        this.setBounds(10, 10, 700, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        labelVisitSubject = new JLabel("Asunto de la Visita");
        labelVisitSubject.setBounds(50, 50, 150, 30);
        this.add(labelVisitSubject);

        textFieldVisitSubject = new JTextField();
        textFieldVisitSubject.setBounds(200, 50, 200, 30);
        this.add(textFieldVisitSubject);

        labelEntryDate = new JLabel("Fecha de Entrada");
        labelEntryDate.setBounds(50, 100, 150, 30);
        this.add(labelEntryDate);

        textFieldEntryDate = new PlaceholderTextField("yyyy-MM-dd HH:mm:ss");
        textFieldEntryDate.setBounds(200, 100, 200, 30);
        this.add(textFieldEntryDate);

        labelEmail = new JLabel("Correo");
        labelEmail.setBounds(50, 150, 150, 30);
        this.add(labelEmail);

        comboBoxEmail = new JComboBox<>();
        comboBoxEmail.setBounds(200, 150, 200, 30);
        this.add(comboBoxEmail);

        buttonSave = new JButton("Guardar");
        buttonSave.setBounds(150, 200, 100, 30);
        this.add(buttonSave);

        buttonCancel = new JButton("Cancelar");
        buttonCancel.setBounds(260, 200, 100, 30);
        this.add(buttonCancel);

        setActionListener(windowVisits, buttonManageVisits);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public JTextField getTextFieldVisitSubject() {
        return textFieldVisitSubject;
    }

    public JTextField getTextFieldEntryDate() {
        return textFieldEntryDate;
    }

    public JComboBox<String> getComboBoxEmail() {
        return comboBoxEmail;
    }

    public JButton getButtonSave() {
        return buttonSave;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    private void setActionListener(WindowVisits windowVisits, ButtonManageVisits buttonManageVisits) {
        ButtonManageAddVisit buttonManageAddVisit = new ButtonManageAddVisit(this, buttonManageVisits);
        buttonSave.addActionListener(buttonManageAddVisit);
        buttonCancel.addActionListener(buttonManageAddVisit);
    }
}
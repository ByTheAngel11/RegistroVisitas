package gui;

import logic.ButtonManageMenu;

import javax.swing.*;

public class WindowMenu extends JFrame {
    private JButton buttonConsultStudents;
    private JButton buttonConsultExternals;
    private JButton buttonConsultVisits;
    private JButton buttonConsultExternalVisits;
    private JLabel labelTitle;

    public WindowMenu(){
        setTitle("Menu");
        this.setBounds(10, 10, 700, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        labelTitle = new JLabel("Menu Registro de visitas");
        labelTitle.setBounds(280, 20, 200, 40);
        this.add(labelTitle);

        buttonConsultStudents = new JButton("Consult students");
        buttonConsultStudents.setBounds(250, 100, 200, 40);
        this.add(buttonConsultStudents);

        buttonConsultExternals = new JButton("Consult externals");
        buttonConsultExternals.setBounds(250, 160, 200, 40);
        this.add(buttonConsultExternals);

        buttonConsultVisits = new JButton("Consult visits");
        buttonConsultVisits.setBounds(250, 220, 200, 40);
        this.add(buttonConsultVisits);

        buttonConsultExternalVisits = new JButton("Consult external visits");
        buttonConsultExternalVisits.setBounds(250, 280, 200, 40);
        this.add(buttonConsultExternalVisits);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        setActionListener();
    }

    public void setActionListener() {
        ButtonManageMenu buttonManageMenu = new ButtonManageMenu(this);
        buttonConsultStudents.addActionListener(buttonManageMenu);
        buttonConsultExternals.addActionListener(buttonManageMenu);
        buttonConsultVisits.addActionListener(buttonManageMenu);
        buttonConsultExternalVisits.addActionListener(buttonManageMenu);
    }

    public JButton getButtonConsultStudents() {
        return buttonConsultStudents;
    }

    public JButton getButtonConsultExternals() {
        return buttonConsultExternals;
    }

    public JButton getButtonConsultVisits() {
        return buttonConsultVisits;
    }

    public JButton getButtonConsultExternalVisits() {
        return buttonConsultExternalVisits;
    }
}
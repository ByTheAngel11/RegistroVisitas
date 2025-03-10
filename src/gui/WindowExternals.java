package gui;

import logic.ButtonManageMenu;

import javax.swing.*;

public class WindowExternals extends JFrame {
    private JButton buttonConsultStudents;
    private JButton buttonConsultExternals;
    private JButton buttonConsultVisits;
    private JButton buttonConsultExternalVisits;
    private JLabel labelTitle;

    public WindowExternals(){
        setTitle("Menu");
        this.setBounds(10, 10, 700, 500);
        this.setLayout(null); // Use null layout to use setBounds

        labelTitle = new JLabel("Menu Registro de visitas");
        labelTitle.setBounds(280, 20, 200, 40);

        buttonConsultStudents = new JButton("Consult students");
        buttonConsultStudents.setBounds(250, 100, 200, 40);

        buttonConsultExternals = new JButton("Consult externals");
        buttonConsultExternals.setBounds(250, 160, 200, 40);

        buttonConsultVisits = new JButton("Consult visits");
        buttonConsultVisits.setBounds(250, 220, 200, 40);

        buttonConsultExternalVisits = new JButton("Consult external visits");
        buttonConsultExternalVisits.setBounds(250, 280, 200, 40);

        this.add(labelTitle);
        this.add(buttonConsultStudents);
        this.add(buttonConsultExternals);
        this.add(buttonConsultVisits);
        this.add(buttonConsultExternalVisits);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

}
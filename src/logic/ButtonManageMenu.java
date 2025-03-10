package logic;

import gui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonManageMenu implements ActionListener {

    WindowMenu windowMenu;

    public ButtonManageMenu(WindowMenu windowMenu) {
        this.windowMenu = windowMenu;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == windowMenu.getButtonConsultStudents()) {
            new WindowStudents();
        }
        if (e.getSource() == windowMenu.getButtonConsultExternals()){
            new WindowExternals();
        }
        if (e.getSource() == windowMenu.getButtonConsultVisits()){
            new WindowVisits();
        }
        if (e.getSource() == windowMenu.getButtonConsultExternalVisits()){
            new WindowExternalVisits();
        }
    }
}
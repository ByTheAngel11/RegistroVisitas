package gui.menu;

import gui.external_visit.WindowExternalVisits;
import gui.student.WindowStudents;
import gui.visit.WindowVisits;
import gui.external.WindowExternals;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonManageMenu implements ActionListener {

    private WindowMenu windowMenu;

    public ButtonManageMenu(WindowMenu windowMenu) {
        this.windowMenu = windowMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == windowMenu.getButtonConsultStudents()) {
            new WindowStudents();
        }
        if (e.getSource() == windowMenu.getButtonConsultExternals()) {
            new WindowExternals();
        }
        if (e.getSource() == windowMenu.getButtonConsultVisits()) {
            new WindowVisits();
        }
        if (e.getSource() == windowMenu.getButtonConsultExternalVisits()) {
            new WindowExternalVisits();
        }
    }
}
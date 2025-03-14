package gui.external.utilities;

import data_access.ExternalManage;
import gui.external.WindowAddExternal;
import gui.external.WindowExternals;
import logic.External;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ButtonManageAddExternal implements ActionListener {
    private WindowAddExternal windowAddExternal;
    private ExternalManage externalManage;
    private WindowExternals windowExternals;

    public ButtonManageAddExternal(WindowAddExternal windowAddExternal, WindowExternals windowExternals) {
        this.windowAddExternal = windowAddExternal;
        this.externalManage = new ExternalManage();
        this.windowExternals = windowExternals;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == windowAddExternal.getButtonSave()) {
            addNewExternal();
        }
        if (e.getSource() == windowAddExternal.getButtonCancel()) {
            windowAddExternal.dispose();
        }
    }

    private void addNewExternal() {
        String email = windowAddExternal.getTextFieldEmail().getText();
        String names = windowAddExternal.getTextFieldNames().getText();
        String surnames = windowAddExternal.getTextFieldSurnames().getText();
        String officialIdentification = windowAddExternal.getTextFieldOfficialIdentification().getText();

        External external = new External(email, names, surnames, officialIdentification);
        externalManage.addExternal(external);
        System.out.println("Externo registrado exitosamente en la base de datos.");
        windowAddExternal.dispose();
        reloadTable();
    }

    private void reloadTable() {
        DefaultTableModel model = (DefaultTableModel) windowExternals.getTableExternals().getModel();
        model.setRowCount(0);

        List<External> externals = externalManage.listAllExternals();
        for (External external : externals) {
            model.addRow(new Object[]{external.getEmail(), external.getNames(), external.getSurnames(), external.getOfficialIdentification()});
        }
    }
}
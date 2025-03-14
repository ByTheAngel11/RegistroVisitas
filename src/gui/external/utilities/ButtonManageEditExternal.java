package gui.external.utilities;

import data_access.ExternalManage;
import gui.external.WindowEditExternal;
import gui.external.WindowExternals;
import logic.External;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ButtonManageEditExternal implements ActionListener {
    private WindowEditExternal windowEditExternal;
    private WindowExternals windowExternals;
    private External external;

    public ButtonManageEditExternal(WindowEditExternal windowEditExternal, WindowExternals windowExternals, External external) {
        this.windowEditExternal = windowEditExternal;
        this.windowExternals = windowExternals;
        this.external = external;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == windowEditExternal.getButtonSave()) {
            saveExternal();
        }
        if (e.getSource() == windowEditExternal.getButtonCancel()) {
            windowEditExternal.dispose();
        }
    }

    private void saveExternal() {
        external.setEmail(windowEditExternal.getTextFieldEmail().getText());
        external.setNames(windowEditExternal.getTextFieldNames().getText());
        external.setSurnames(windowEditExternal.getTextFieldSurnames().getText());
        external.setOfficialIdentification(windowEditExternal.getTextFieldOfficialIdentification().getText());

        ExternalManage externalManage = new ExternalManage();
        externalManage.editExternalByCorreo(external);
        System.out.println("Externo actualizado exitosamente en la base de datos.");
        windowEditExternal.dispose();
        reloadTable();
    }

    private void reloadTable() {
        DefaultTableModel model = (DefaultTableModel) windowExternals.getTableExternals().getModel();
        model.setRowCount(0);

        ExternalManage externalManage = new ExternalManage();
        List<External> externals = externalManage.listAllExternals();
        for (External external : externals) {
            model.addRow(new Object[]{external.getEmail(), external.getNames(), external.getSurnames(), external.getOfficialIdentification()});
        }
    }
}
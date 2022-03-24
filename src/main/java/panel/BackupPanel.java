package panel;


import listener.BackupListener;
import util.GUIUtil;

import javax.swing.*;

/**
 * 界面类 BackupPanel 备份页
 */

public class BackupPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }

    public static BackupPanel instance = new BackupPanel();
    private JButton bBackup = new JButton("备份");

    public BackupPanel() {
        this.add(bBackup);
        addListener();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(BackupPanel.instance);
    }

    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {
        BackupListener listener = new BackupListener();
        bBackup.addActionListener(listener);
    }
}
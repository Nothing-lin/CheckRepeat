package listener;


import panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MainPanel 的监听器，监听 Toolbar 的按钮操作并切换面板
 * workingPanel有方法 .show(WorkingPanel p) 可以居中显示子面板 并 更新数据
 * @see MainPanel
 */

public class ToolBarListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        CheckPanel checkPanel = CheckPanel.instance;
        MainPanel p = MainPanel.instance;
        JButton b = (JButton) e.getSource();
        if (b == p.bCheck) {
            p.updateUI();
            p.workingPanel.show(CheckPanel.instance);
            checkPanel.remove(CheckListPanel.instance);

        }
        if (b == p.bAdd) {
            p.workingPanel.show(AddPanel.instance);
            checkPanel.remove(CheckListPanel.instance);
        }
        if (b == p.bBackup) {
            p.workingPanel.show(BackupPanel.instance);
            checkPanel.remove(CheckListPanel.instance);
        }
        if (b == p.bRestore) {
            p.workingPanel.show(RecoverPanel.instance);
            checkPanel.remove(CheckListPanel.instance);
        }


    }
}

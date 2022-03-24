package listener;

import panel.BackupPanel;
import util.SQLUtil;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class RecoverListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        BackupPanel p = BackupPanel.instance;

        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File("Data.db"));
        fc.setFileFilter(new FileFilter() {

            @Override
            public String getDescription() {
                return ".db";
            }

            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".db");
            }
        });

        int returnVal = fc.showOpenDialog(p);
        File file = fc.getSelectedFile();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                SQLUtil.recover(file.getAbsolutePath());
                JOptionPane.showMessageDialog(p, "恢复成功");
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(p, "恢复失败\r\n,错误:\r\n" + e1.getMessage());
            }

        }
    }
}

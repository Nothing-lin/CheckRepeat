package listener;

import dao.AddDao;
import dao.CheckDao;
import entity.Add;
import model.CheckTableModel;
import panel.CheckListPanel;
import panel.CheckPanel;
import panel.MainPanel;
import service.AddService;
import service.CheckService;
import util.CheckRepeatUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckPanelListenr implements ActionListener {
    public List<Add> repeatData = new ArrayList<Add>();
    public List<Add> getResult = new ArrayList<Add>();
    AddService service = new AddService();
    public CheckTableModel ctm;

    @Override
    public void actionPerformed(ActionEvent e) {
        CheckPanel checkPanel = CheckPanel.instance;
        CheckListPanel checkListPanel =CheckListPanel.instance;
        MainPanel p = MainPanel.instance;
        JButton b = (JButton) e.getSource();

        if (b == checkPanel.bcheck){


            //调取表格面板刷新函数
//            CheckListPanel checkListPanel = new CheckListPanel();

            checkPanel.add(CheckListPanel.instance, BorderLayout.CENTER);
            checkListPanel.updateUI();
            checkPanel.updateUI();

        }

        if (b == checkPanel.bdelete){

            if (!checkListPanel.checkSelected()) {
                JOptionPane.showMessageDialog(p, "请先选择一行 ");
                return;
            }
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "确定删除？")) {
                return;
            }

            //删除选中的行
            service.delete(checkListPanel.getSelectedData().getId());
            checkListPanel.updateUI();
        }

    }
}

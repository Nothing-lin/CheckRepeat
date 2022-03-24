package panel;


import listener.RecoverListener;

import util.GUIUtil;

import javax.swing.*;

/**
 * 界面类 RecoverPanel 恢复页
 */

public class RecoverPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }
    public static RecoverPanel instance = new RecoverPanel();
 
    private JButton bRecover =new JButton("恢复");
 
    public RecoverPanel() {
        this.add(bRecover);
        addListener();
    }
 
    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }
    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {
        RecoverListener listener = new RecoverListener();
        bRecover.addActionListener(listener);
    }
}
package startup;

import frame.MainFrame;
import panel.CheckPanel;
import panel.MainPanel;
import util.GUIUtil;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;

public class Bootstrap {
    public static void main(String[] args) {
        GUIUtil.useLNF();

        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    MainFrame.instance.setVisible(true);
                    //居中显示子面板 并 更新数据
                    MainPanel.instance.workingPanel.show(CheckPanel.instance);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

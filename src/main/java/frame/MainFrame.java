package frame;

import panel.MainPanel;
import util.GUIUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {

    //定义皮肤
    static {
        GUIUtil.useLNF();
    }

    //创建主窗口对象,主窗口不变所以用static
    public static MainFrame instance = new MainFrame();


    //定义构造器，私有只能被Mainframe调用
    private MainFrame(){
        this.setSize(800, 800); //主窗口大小
        this.setTitle("数据查重"); //主窗口标题
        //设置窗口图标
        String src = "src\\main\\resources\\img\\luck.png";
        ImageIcon icon = new ImageIcon(src);
        this.setIconImage(icon.getImage());

        this.setContentPane(MainPanel.instance);//主窗口显示的面板
        this.setLocationRelativeTo(null); //主窗口居中显示
        this.setResizable(false); //主窗口是否可调节大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭资源
    }
}

package panel;

import listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends  JPanel{
    //定义皮肤
    static {
        GUIUtil.useLNF();
    }

    //创建主面板对象
    public static MainPanel instance = new MainPanel();

    //定义组件
    private JToolBar tb = new JToolBar();//工具栏
    public JButton bCheck = new JButton();//按钮
    public JButton bAdd = new JButton();
    public JButton bBackup = new JButton();
    public JButton bRestore = new JButton();
    public CenterPanel workingPanel;

    //定义主面板构造器
    private MainPanel(){
        //设置图片按钮的基本配置
        GUIUtil.setImageIcon(bCheck,"check.png","查询数据");
        GUIUtil.setImageIcon(bAdd,"add.png","添加数据");
        GUIUtil.setImageIcon(bBackup,"backup.png","备份");
        GUIUtil.setImageIcon(bRestore,"restore.png","恢复");

        //将组件添加至工具栏中
        tb.add(bCheck);
        tb.add(bAdd);
        tb.add(bBackup);
        tb.add(bRestore);
        tb.setFloatable(false);//设置工具栏不可拉伸

        //创建工作面板，就是工具栏以下的那部分显示面板
        workingPanel = new CenterPanel(0.85);

        //初始打开的页面
        workingPanel.show(CheckPanel.instance);

        //设置main面板布局
        this.setLayout(new BorderLayout());
        this.add(tb, BorderLayout.NORTH);
        this.add(workingPanel, BorderLayout.CENTER);

        //调用组件监听器方法
        addListeners();
    }

    private void addListeners() {
        //工具栏监听器
        ToolBarListener l = new ToolBarListener();
        //对工具栏组件进行监听
        bCheck.addActionListener(l);
        bAdd.addActionListener(l);
        bBackup.addActionListener(l);
        bRestore.addActionListener(l);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(MainPanel.instance, 1);
    }
}

package panel;

import listener.CheckPanelListenr;
import util.GUIUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CheckPanel extends WorkingPanel{
    //美化界面工具
    static {
        GUIUtil.useLNF();
    }

    //实例化查询面板
    public static CheckPanel instance = new CheckPanel();

    //定义查询按钮
    public JButton bcheck = new JButton("查询");
    public JButton bdelete = new JButton("删除");

    //定义添加界面组件
    private JLabel N1 = new JLabel("N1");
    private JLabel N2 = new JLabel("N2");
    private JLabel N3 = new JLabel("N3");
    private JLabel N4 = new JLabel("N4");
    private JLabel N5 = new JLabel("N5");
    private JLabel N6 = new JLabel("N6");
    private JLabel N7 = new JLabel("N7");
    private JLabel N8 = new JLabel("");

    public JTextField TN1 = new JTextField();//括号里面填数字可以设置输入框的长度
    public JTextField TN2 = new JTextField();
    public JTextField TN3 = new JTextField();
    public JTextField TN4 = new JTextField();
    public JTextField TN5 = new JTextField();
    public JTextField TN6 = new JTextField();
    public JTextField TN7 = new JTextField();



    //初始化输入面板、数据库面板
    public JPanel pInput = new JPanel();
    public JPanel pData = new JPanel();

    public CheckPanel(){
        //设置面板布局
        pInput.setLayout(new GridLayout(2,8,5,5));

        //向输入面板添加组件
        pInput.add(N1);
        pInput.add(N2);
        pInput.add(N3);
        pInput.add(N4);
        pInput.add(N5);
        pInput.add(N6);
        pInput.add(N7);
        pInput.add(bdelete);


        pInput.add(TN1);
        pInput.add(TN2);
        pInput.add(TN3);
        pInput.add(TN4);
        pInput.add(TN5);
        pInput.add(TN6);
        pInput.add(TN7);
        pInput.add(bcheck);
        //设置面板的边距
        pInput.setBorder(new EmptyBorder(0,0,20,0));

        CheckPanelListenr checkListener = new CheckPanelListenr();
        //设置以下面板布局并且添加进添加面板（addpanel）
        this.setLayout(new BorderLayout());
        this.add(pInput, BorderLayout.NORTH);





        //在这个面板中添加监听器
        addListener();
    }


    @Override
    public void updateData() {
        //清空输入框
        TN1.setText("");
        TN2.setText("");
        TN3.setText("");
        TN4.setText("");
        TN5.setText("");
        TN6.setText("");
        TN7.setText("");
        //设置第一个输入框为焦点
        TN1.grabFocus();
//        this.updateUI();

    }

    @Override
    public void addListener() {
        bcheck.addActionListener(new CheckPanelListenr());
        bdelete.addActionListener(new CheckPanelListenr());

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(CheckPanel.instance);
    }
}

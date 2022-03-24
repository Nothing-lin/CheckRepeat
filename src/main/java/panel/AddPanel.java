package panel;

import entity.Add;
import listener.AddPanelListener;
import model.DataTableModel;
import service.AddService;
import util.GUIUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 添加界面
 */
public class AddPanel extends WorkingPanel{
    //美化界面工具
    static {
        GUIUtil.useLNF();
    }

    //创建添加面板的实例
    public static AddPanel instance = new AddPanel();

    //定义添加界面组件
    private JLabel N1 = new JLabel("N1");
    private JLabel N2 = new JLabel("N2");
    private JLabel N3 = new JLabel("N3");
    private JLabel N4 = new JLabel("N4");
    private JLabel N5 = new JLabel("N5");
    private JLabel N6 = new JLabel("N6");
    private JLabel N7 = new JLabel("N7");
    private JLabel date = new JLabel("添加日期");

    public JTextField TN1 = new JTextField();//括号里面填数字可以设置输入框的长度
    public JTextField TN2 = new JTextField();
    public JTextField TN3 = new JTextField();
    public JTextField TN4 = new JTextField();
    public JTextField TN5 = new JTextField();
    public JTextField TN6 = new JTextField();
    public JTextField TN7 = new JTextField();

    public JButton bSubmit = new JButton("确定保存");
    public JButton bDelete = new JButton("删除");
    public int kbSubmint;

    //初始化输入面板、数据库面板、确认按钮面板
    public JPanel pInput = new JPanel();
    public JPanel pData = new JPanel();
    public JPanel pSubmit = new JPanel();
    //获取数据库数据总和
    public int size = new AddService().total();

    //定义添加面板构造器
    public AddPanel(){

        String msg = "全部数据一共有："+size+"条";
        //定义显示数据总和的标签
        JLabel total = new JLabel(msg);

        //设置面板布局
        pInput.setLayout(new GridLayout(2,7,5,5));

        //向输入面板添加组件
        pInput.add(N1);
        pInput.add(N2);
        pInput.add(N3);
        pInput.add(N4);
        pInput.add(N5);
        pInput.add(N6);
        pInput.add(N7);

        pInput.add(TN1);
        pInput.add(TN2);
        pInput.add(TN3);
        pInput.add(TN4);
        pInput.add(TN5);
        pInput.add(TN6);
        pInput.add(TN7);
        //设置面板的边距
        pInput.setBorder(new EmptyBorder(0,0,20,0));

        pSubmit.add(bSubmit);
        pSubmit.add(bDelete);
        pSubmit.add(total);

        //按钮与键盘绑定enter键,按键监听器
        //有一个问题就是需要alt+enter才能触发按钮，alt用来聚焦焦点
        bSubmit.setMnemonic(KeyEvent.VK_ENTER);


        //设置以下面板布局并且添加进添加面板（addpanel）
        this.setLayout(new BorderLayout());
        this.add(pInput, BorderLayout.NORTH);
        this.add(DataListPanel.instance,BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH);

        //在这个面板中添加监听器
        addListener();
    }


    //面板数据刷新,在监听器中被调用这个刷新方法
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
        pSubmit.repaint();

    }

    public void addListener() {
        bSubmit.addActionListener(new AddPanelListener());
        bDelete.addActionListener(new AddPanelListener());

    }

    //面板测试程序
    public static void main(String[] args) {
        GUIUtil.showPanel(AddPanel.instance);
    }

}

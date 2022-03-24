package panel;

import entity.Add;
import model.DataTableModel;
import service.AddService;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class DataListPanel extends WorkingPanel{
    //定义皮肤
    static {
        GUIUtil.useLNF();
    }

    //定义数据面板的实例
    public static DataListPanel instance = new DataListPanel();

    //定义数据表模型
    public DataTableModel dtm = new DataTableModel();
    //将数据表模型放入Jtable中
    public JTable t = new JTable(dtm);

    //构造数据表面板构造器
    public DataListPanel(){
        //定义一个滚动面板
        JScrollPane scrollPane = new JScrollPane(t);

        //定义数据列表面板布局
        this.setLayout(new BorderLayout());
        this.add(scrollPane,BorderLayout.CENTER);

        //定义监听器
        this.addListener();
    }

    //下面的数据选取要在Jtable代码对应的位置才能获取到选取中的数据
    //监听选中的数据
    public boolean checkSelected() {
        return t.getSelectedRow() >=0;
    }

    //获取选中的数据
    public Add getSelectedData(){
        int index = t.getSelectedRow();
        return dtm.adds().get(index>0?index:0);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(DataListPanel.instance);
    }

    @Override
    public void updateData() {
        t.updateUI();
    }

    @Override
    public void addListener() {


    }
}

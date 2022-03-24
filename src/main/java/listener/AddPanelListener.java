package listener;

import dao.AddDao;
import panel.AddPanel;
import panel.DataListPanel;
import panel.MainPanel;
import service.AddService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AddPanelListener implements ActionListener {

    //事件监听器的主启动方法
    @Override
    public void actionPerformed(ActionEvent e) {

        //初始化添加面板的实例
        AddPanel p = AddPanel.instance;
        DataListPanel dataListPanel = DataListPanel.instance;
        AddService service = new AddService();
        //获取按钮监听事件
        JButton b = (JButton) e.getSource();//这里监听到是哪个按钮被触发了




        //保存按钮触发的事件
        if (p.bSubmit == b || p.kbSubmint ==1) {

            //获取添加面板中的数据
            try {
                Integer TN1 = Integer.valueOf(p.TN1.getText());
                Integer TN2 = Integer.valueOf(p.TN2.getText());
                Integer TN3 = Integer.valueOf(p.TN3.getText());
                Integer TN4 = Integer.valueOf(p.TN4.getText());
                Integer TN5 = Integer.valueOf(p.TN5.getText());
                Integer TN6 = Integer.valueOf(p.TN6.getText());
                Integer TN7 = Integer.valueOf(p.TN7.getText());


                //判断输入框的数据是否为空
                if (TN7 == null || TN6 == null || TN5 == null || TN4 == null || TN3 == null || TN2 == null || TN1 == null) {
                    JOptionPane.showMessageDialog(p, "不能输入空数据！");
                }

                //获取添加时的时间
                Date time = new Date();

                //格式化时间
                SimpleDateFormat ft = new SimpleDateFormat("yyyy年MM月dd日");
                String date = String.valueOf(ft.format(time));

                //添加面板数据处理，添加数据到sqlite上,将数据送到service类上处理
                new AddService().add(TN1, TN2, TN3, TN4, TN5, TN6, TN7, date);
                //刷新面板中输入框的数据
                p.updateData();
                dataListPanel.updateData();
                new AddService().addStatus();
                new AddService().update();




            } catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
                JOptionPane.showMessageDialog(p, "不能输入空数据！");
            }

        //页面跳转回添加界面
        MainPanel.instance.workingPanel.show(AddPanel.instance);
        }


        //删除按钮触发的事件
        if(p.bDelete == b){
            if (!dataListPanel.checkSelected()) {
                JOptionPane.showMessageDialog(p, "请先选择一行 ");
                return;
            }
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "确定删除？")) {
                return;
            }

            //删除选中的行
            service.delete(dataListPanel.getSelectedData().getId());

            //数据刷新
            //没有这个，那么数据需要手动刷新，不能按完删除键之后刷新，必须要有
            dataListPanel.updateData();


            //测试是否能输出选中的数据的id
//            System.out.println(service.deleteStatus);

        }

    }
}

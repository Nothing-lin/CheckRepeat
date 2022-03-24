package model;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import dao.AddDao;
import entity.Add;
import service.AddService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class DataTableModel implements TableModel {
    //定义表列名
    private String[] columnNames = new String[]{"N1","N2","N3","N4","N5","N6","N7","日期","序号"};

    //定义数据结果集,adds封装了数据库中的全部数据信息,如果有添加数据就刷新
    public List<Add> adds(){
        int addStatus = new AddService().addStatus();
        int deleteStatus = new AddService().deleteStatus();
        if (addStatus == 1){
            List<Add> adds = new AddService().update();
            return adds;
        }
        if (deleteStatus == 1){
            List<Add> adds = new AddService().update();
            return adds;
        }
        List<Add> adds = new AddDao().getAll();
        return adds;
    }


    //以下是TableModel自动生成，部分需要细微改动
    @Override
    public int getRowCount() {
        return adds().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //对应列对应行放对应数据
        if (8 == columnIndex){
            return adds().get(rowIndex).getId();
        }
        if (0 == columnIndex){
            return adds().get(rowIndex).getTN1();
        }
        if (1 == columnIndex){
            return adds().get(rowIndex).getTN2();
        }
        if (2 == columnIndex){
            return adds().get(rowIndex).getTN3();
        }
        if (3 == columnIndex){
            return adds().get(rowIndex).getTN4();
        }
        if (4 == columnIndex){
            return adds().get(rowIndex).getTN5();
        }
        if (5 == columnIndex){
            return adds().get(rowIndex).getTN6();
        }
        if (6 == columnIndex){
            return adds().get(rowIndex).getTN7();
        }
        if (7 == columnIndex){
            return adds().get(rowIndex).getDate();
        }

        return null;
    }





    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}

package model;

import entity.Add;
import service.CheckService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class CheckTableModel implements TableModel {
    //定义表列名
    private String[] columnNames = new String[]{"N1","N2","N3","N4","N5","N6","N7","日期"};

    //核心算法
    public List<Add> repeatData(){
        //设计算法的入口
        CheckService service = new CheckService();
        List<Add> repeatData = service.getResult();

        return repeatData;
    }

    @Override
    public int getRowCount() {
        return repeatData().size();
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
            return repeatData().get(rowIndex).getId();
        }
        if (0 == columnIndex){
            return repeatData().get(rowIndex).getTN1();
        }
        if (1 == columnIndex){
            return repeatData().get(rowIndex).getTN2();
        }
        if (2 == columnIndex){
            return repeatData().get(rowIndex).getTN3();
        }
        if (3 == columnIndex){
            return repeatData().get(rowIndex).getTN4();
        }
        if (4 == columnIndex){
            return repeatData().get(rowIndex).getTN5();
        }
        if (5 == columnIndex){
            return repeatData().get(rowIndex).getTN6();
        }
        if (6 == columnIndex){
            return repeatData().get(rowIndex).getTN7();
        }
        if (7 == columnIndex){
            return repeatData().get(rowIndex).getDate();
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

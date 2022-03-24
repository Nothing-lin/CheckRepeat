package service;

import dao.AddDao;
import entity.Add;
import model.DataTableModel;

import java.util.Date;
import java.util.List;

public class AddService {
    public int addStatus;
    public int deleteStatus;
    public int size;

    //初始化添加面板的Dao层
    private static AddDao dao = new AddDao();

    public List<Add> update(){
        List<Add> updateData = new AddDao().getAll();
        return updateData;
    }

    public void add(Integer tn1, Integer tn2, Integer tn3, Integer tn4, Integer tn5, Integer tn6, Integer tn7, String date) {
        Add add = new Add();
        //设置数据
        add.setTN1(tn1);
        add.setTN2(tn2);
        add.setTN3(tn3);
        add.setTN4(tn4);
        add.setTN5(tn5);
        add.setTN6(tn6);
        add.setTN7(tn7);
        add.setDate(date);

        //将数据传入dao中处理
        dao.add(add);
        this.addStatus=1;
        this.size = new DataTableModel().adds().size();
//        System.out.println(this.size);
    }

    public void delete(int id) {
        dao.delete(id);
        this.deleteStatus=1;
        this.size = new DataTableModel().adds().size();
        System.out.println(this.size);
    }

    //设置添加面板状态，1添加，2删除
    public int addStatus(){
        return this.addStatus;
    };
    public int deleteStatus(){
        return this.deleteStatus;
    }

    public int total(){

        if (addStatus()==1 || deleteStatus() == 1){
            return this.size;
        }
        return new DataTableModel().adds().size();
    }
}

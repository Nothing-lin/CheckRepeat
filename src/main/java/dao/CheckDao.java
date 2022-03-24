package dao;

import entity.Add;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckDao {

    //根据获得到的id查询，获取对应的数值
    public static List<Add> getIdAll(int[] Id) {
        List<Add> idAll = new ArrayList<Add>();
        Add add = null;

        //遍历所有id
        for (int i =0;i < Id.length;i++){
            //定义查询语句
            String sql = "select * from data where id =?";
            //连接内置数据库
            try (Connection c = DBUtil.getConnection();
                 PreparedStatement ps = c.prepareStatement(sql)) {
                //传入索引值
                ps.setInt(1,Id[i]);
                //编译查询，获取结果集
                ResultSet rs = ps.executeQuery();

                //rs某元素有下一个就执行，也就是判断有没有数值或还有没有数值
                //思考一下next（）
                if (rs.next()){
                    add = new Add(
                            rs.getInt("id"),
                            rs.getInt("TN1"),
                            rs.getInt("TN2"),
                            rs.getInt("TN3"),
                            rs.getInt("TN4"),
                            rs.getInt("TN5"),
                            rs.getInt("TN6"),
                            rs.getInt("TN7"),
                            rs.getString("date")
                    );
                }

                idAll.add(add);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return idAll;
    }

}

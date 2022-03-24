package dao;

import entity.Add;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库业务处理，增删改查
 */
public class AddDao {

    //数据添加方法
    public void add(Add add){
        //设置sql语句
        String sql = "insert into data('TN1','TN2','TN3','TN4','TN5','TN6','TN7','date') values (?,?,?,?,?,?,?,?)";

        //启动数据库驱动
        try (Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            //设置要往数据库中传送的数据
            ps.setInt(1,add.getTN1());
            ps.setInt(2,add.getTN2());
            ps.setInt(3,add.getTN3());
            ps.setInt(4,add.getTN4());
            ps.setInt(5,add.getTN5());
            ps.setInt(6,add.getTN6());
            ps.setInt(7,add.getTN7());
            ps.setString(8,add.getDate());

            //数据库编译
            ps.execute();
            //处理编译结果集
            ResultSet rs = ps.getGeneratedKeys();
            //序号处理
            if (rs.next()){
                int id =rs.getInt(1);
                add.setId(id);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }



    //数据删除方法
    public int delete(int id){
        String sql = "delete from data where id = ?";
        int result = 0;
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            //数据库结果集刷新
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //查询数据库中的所有数据内容
    public List<Add> getAll(){
        Add add = null;
        String sql = "select * from data order by id desc";

        //定义结果集
        List<Add> adds = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            //数据库查询结果集
            ResultSet rs = ps.executeQuery();
            //循环遍历结果集
            while (rs.next()){
                add = new Add(rs.getInt("id"),
                                rs.getInt("TN1"),
                                rs.getInt("TN2"),
                                rs.getInt("TN3"),
                                rs.getInt("TN4"),
                                rs.getInt("TN5"),
                                rs.getInt("TN6"),
                                rs.getInt("TN7"),
                                rs.getString("date"));
                //将每次循环的结果封装进adds数组中
                adds.add(add);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return adds;
    }
}

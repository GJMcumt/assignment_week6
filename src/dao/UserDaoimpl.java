package dao;

import dbutil.DbUtil;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoimpl implements UserDao {
    @Override
    public List<User> getAll() {
        List<User> newsList=new ArrayList<>();
        try{
            ResultSet rs= DbUtil.executeQuery("select * from user ", new Object[]{});
            while(rs.next()){
                User user=new User();
                user.setUser_id(rs.getInt(1));
                user.setUser_name(rs.getString(2));
                user.setPwd(rs.getString(3));
                newsList.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return newsList;
    }

    @Override
    public boolean addUser(User user) {
        return DbUtil.executeUpdate("insert into user values(?,?,?)", new Object[]{user.getUser_id(),user.getUser_name(),user.getPwd()});
    }

    @Override
    public boolean updateUser(User oldUser, User newUser) {
        return DbUtil.executeUpdate("update user set user_id=?,user_name=?,pwd=? where user_id=?",new Object[]{newUser.getUser_id(),newUser.getUser_name(),newUser.getPwd(),oldUser.getUser_id()});
    }

    @Override
    public boolean deleteUser(User user) {
        return DbUtil.executeUpdate("delete from user where k=?", new Object[]{user.getUser_id()});
    }

    @Override
    public User getByUser_Name(User user) {
        try{
            ResultSet rs= DbUtil.executeQuery("select * from user where user_name=?", new Object[]{user.getUser_name()});
            while(rs.next()){
                user.setUser_id(rs.getInt("user_id"));
                //user.setUser_name (rs.getString(2));
                user.setPwd(rs.getString("pwd"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}

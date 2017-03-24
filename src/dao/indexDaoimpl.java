package dao;

import dbutil.DbUtil;
import entity.Cart;
import entity.Good;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class indexDaoimpl implements indexDao {
    @Override
    public List<Good> getAll() {
        List<Good> newsList=new ArrayList<>();
        try{
            ResultSet rs= DbUtil.executeQuery("select * from good", new Object[]{});
            while(rs.next()){
                Good good=new Good();
                good.setGood_name(rs.getString(2));
                good.setSuk(rs.getInt(1));
                newsList.add(good);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return newsList;
    }
}

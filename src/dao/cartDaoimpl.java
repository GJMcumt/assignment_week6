package dao;

import dbutil.DbUtil;
import entity.Cart;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class cartDaoimpl implements CartDao {


    @Override
    public List<Cart> getAll() {
        List<Cart> newsList=new ArrayList<>();
        try{
            ResultSet rs= DbUtil.executeQuery("select good_name,shopping_num,cart.suk,cart.user_id from cart,user,good where user.user_id=1 AND cart.suk=good.suk AND cart.user_id=user.user_id", new Object[]{});
            while(rs.next()){
                Cart cart=new Cart();
                cart.setGood_name(rs.getString(1));
                cart.setShopping_num(rs.getInt(2));
                cart.setSuk(rs.getInt(3));
                cart.setUser_id(rs.getInt(4));
                newsList.add(cart);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return newsList;

    }


    @Override
    public boolean addCart(Cart cart) {
        return DbUtil.executeUpdate("insert into cart values(?,?,?)", new Object[]{cart.getSuk(),cart.getUser_id(),cart.getShopping_num()});
    }

    @Override
    public boolean updateCart(Cart oldCart,Cart newCart) {
        return DbUtil.executeUpdate("update cart set user_id=?,shopping_num=? where suk=?",new Object[]{newCart.getUser_id(),newCart.getShopping_num(),oldCart.getSuk()});
    }

    @Override
    public Cart getBySuk(Cart cart) {
        try{
            ResultSet rs= DbUtil.executeQuery("select * from cart where suk=?", new Object[]{cart.getSuk()});
            while(rs.next()){
                cart.setSuk(rs.getInt(1));
                cart.setUser_id (rs.getInt(2));
                cart.setShopping_num(rs.getInt(3));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public boolean deleteCart(Cart cart) {
        return DbUtil.executeUpdate("delete from cart where suk=?", new Object[]{cart.getSuk()});
    }
}

package service;

import dao.CartDao;
import dao.cartDaoimpl;
import entity.Cart;
import java.util.List;
//购物车服务
public class cartService {
    private CartDao cartDao;
    public void setCartDao(){
        this.cartDao = new cartDaoimpl();
    }
    public List<Cart> getAll(Cart cart){
        return cartDao.getAll(cart);
    }
    public boolean addCart(Cart cart){
        return cartDao.addCart(cart);
    }
    public boolean updateCart(Cart oldCart,Cart newCart){
        return cartDao.updateCart(oldCart, newCart);
    }
    public boolean deleteCart(Cart cart){
        return cartDao.deleteCart(cart);
    }
    public Cart getBySuk(Cart cart){
        return cartDao.getBySuk(cart);

    }
}

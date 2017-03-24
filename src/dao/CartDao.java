package dao;

import entity.Cart;

import java.util.List;
public interface CartDao {
	public List<Cart> getAll();
    public boolean addCart(Cart cart);
    public boolean updateCart(Cart oldCart,Cart newCart);
    public boolean deleteCart(Cart cart);
    public Cart getBySuk(Cart cart);
}


package kr.ac.hansung.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.CartDao;
import kr.ac.hansung.cse.model.Cart;
import kr.ac.hansung.cse.model.CartItem;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;
	
	public Cart getCartById(int cartId){
		return cartDao.getCartById(cartId);
	}

	public void save(Cart cart) {
		cartDao.save(cart);	
	}
	
	public int calGrandTotal(Cart cart){
		int grandTotal = 0;
		
		List<CartItem> cartItems = cart.getCartItems();
		
		for(int i=0; i<cartItems.size(); i++){
			grandTotal += cartItems.get(i).getTotalPrice();
		}
		
		return grandTotal;
	}
}

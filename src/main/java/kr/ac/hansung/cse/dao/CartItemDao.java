package kr.ac.hansung.cse.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.Cart;
import kr.ac.hansung.cse.model.CartItem;

@Repository
@Transactional
public class CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	}

	public void removeCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();
	}

	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItems();
		
		for(CartItem item: cartItems){
			removeCartItem(item);
		}
	}

	public CartItem getCartItemByProductId(int cartId, int productId) {
		Session session = sessionFactory.getCurrentSession();
		Query<CartItem> query = session.createQuery("FROM CartItem WHERE cart.cartId = :cid AND product.id = :pid", CartItem.class);
		
		query.setParameter("cid", cartId);
		query.setParameter("pid", productId);
		
		return query.uniqueResult();
	}

}

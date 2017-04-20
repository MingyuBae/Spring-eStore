package kr.ac.hansung.cse.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.Product;

@Repository
@Transactional
public class ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Product> getProducts(){
		Session session = sessionFactory.getCurrentSession();
		Query<Product> query = (Query<Product>)session.createQuery("from Product");
		List<Product> productList = query.list();
		
		return productList;
	}
	
	public Product getProductById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Product product = session.get(Product.class, id);
		
		return product;
	}

	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(product);
		session.flush();
	}

	public void deleteProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		
		session.delete(product);
		session.flush();
	}

	public void editProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}
}

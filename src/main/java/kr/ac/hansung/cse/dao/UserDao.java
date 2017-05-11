package kr.ac.hansung.cse.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.User;

@Repository
@Transactional
public class UserDao {
	
	@Autowired
	private PasswordEncoder PasswordEncoder;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUser(User user){
		Session session = sessionFactory.getCurrentSession();
		user.setPassword(PasswordEncoder.encode(user.getPassword()));
		session.saveOrUpdate(user);
		
		session.flush();
	}
	
	public User getUserById(int userId){
		Session session = sessionFactory.getCurrentSession();
		return (User) session.get(User.class, userId);
	}
	
	public List<User> getAllUsers(){
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("FROM User", User.class);
		List<User> userList = query.list();
		
		return userList;
	}
	
	public User getUserByUsername(String username){
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("FROM User WHERE username = ?", User.class);
		query.setParameter(0, username);
		
		return query.uniqueResult();
	}
	
}

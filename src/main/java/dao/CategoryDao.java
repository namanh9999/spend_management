package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Category;
import util.HiberUtil;

public class CategoryDao implements DaoInterface<Category> {

	public static CategoryDao getInstance() {
		return new CategoryDao();
	}
	public List<Category> selectAll(){
		List<Category> result = null;
		Session session = getSS();
		String hql = "from Category";
		Query<Category> query = session.createQuery(hql);
		result = query.list();
		return result;
	}
	public void insert(Category d) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		session.save(d);
		tr.commit();
		session.close();
	}

	public Category getCategoryByID(int id) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		Category w1 = session.find(Category.class, id);
		tr.commit();
		session.close();
		return w1;
	}
	public void remove(Category d) {
	}

	public Category getCategory() {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		Category ct1 = session.find(Category.class, 2);
		tr.commit();
		session.close();
		return ct1;

	}

	private Session getSS() {
		try {
			SessionFactory sessionFactory = HiberUtil.getSessionfactory();
			Session session = sessionFactory.openSession();
			return session;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

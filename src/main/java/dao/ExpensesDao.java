package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Expenses;
import util.HiberUtil;

public class ExpensesDao implements DaoInterface<Expenses> {

	public static ExpensesDao getInstance() {
		return  new ExpensesDao();
	}
	public void insert(Expenses d) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(d);
		tr.commit();
		session.close();
	}

	public void remove(Expenses d) {
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
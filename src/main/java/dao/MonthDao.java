package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Month;
import model.Week;
import util.HiberUtil;

public class MonthDao implements DaoInterface<Month> {

	public static MonthDao getInstance() {
		return new MonthDao();
	}
	
	public void insert(Month month) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		session.save(month);
		tr.commit();
		session.close();
	}
		public int getIDFromMonthTable() {
		int id = 0;
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		try {
			String hql = "select Max(id) from Week";
			Query query = session.createQuery(hql);
			id = (Integer) query.uniqueResult();
			tr.commit();
		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			// Handle or log the exception appropriately
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return id;
	}

		public void updateWithStatement(Month month) {
			Session session = getSS();
			Transaction tr = session.beginTransaction();
			String hqlUpdate = "Update Month set food= :food, utilities = :utilities, entertainment = :entertainment ,"+
			" transportation = :transportation, shopping = :shopping,"+
			" study = :study, groceries = :groceries, total = :total where id = :id";
			Query query = session.createQuery(hqlUpdate);
			query.setParameter("food",month.getFood());
			query.setParameter("utilities",month.getUtilities());
			query.setParameter("entertainment",month.getEntertainment());
			query.setParameter("transportation",month.getTransportation());
			query.setParameter("shopping",month.getShopping());
			query.setParameter("study",month.getStudy());
			query.setParameter("groceries",month.getGroceries());
			query.setParameter("total",month.getTotal());
			query.setParameter("id",month.getId());
			System.out.println("month id  is " + month.getId());
			query.executeUpdate();
			tr.commit();
			session.close();
			System.out.println("Done");

		}
	public Month getMonthByID(int id) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		Month w1 = session.find(Month.class, id);
		tr.commit();
		session.close();
		return w1;
	}


	public void remove(Month month) {
		
	}
	public Session getSS() {
		SessionFactory sessionFactory = HiberUtil.getSessionfactory();
		Session session  = sessionFactory.openSession();
		return session;
	}
}

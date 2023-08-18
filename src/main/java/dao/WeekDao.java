package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Week;
import util.DateProcess;
import util.HiberUtil;

public class WeekDao implements DaoInterface<Week> {

	public static WeekDao getInstance() {
		return new WeekDao();
	}

	public void insert(Week d) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		session.save(d);
		tr.commit();
		session.close();
	}

	public void remove(Week d) {

	}

	public Week getWeekByID(int id) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		Week w1 = session.find(Week.class, id);
		tr.commit();
		session.close();
		return w1;
	}

	public int getIDFromWeekTable() {
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
	public void updateWithStatement(Week week) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		String hqlUpdate = "Update Week set food= :food, utilities = :utilities, entertainment = :entertainment ,"+
		" transportation = :transportation, shopping = :shopping,"+
		" study = :study, groceries = :groceries, total = :total where id = :id";
		Query query = session.createQuery(hqlUpdate);
		query.setParameter("food",week.getFood());
		query.setParameter("utilities",week.getUtilities());
		query.setParameter("entertainment",week.getEntertainment());
		query.setParameter("transportation",week.getTransportation());
		query.setParameter("shopping",week.getShopping());
		query.setParameter("study",week.getStudy());
		query.setParameter("groceries",week.getGroceries());
		query.setParameter("total",week.getTotal());
		query.setParameter("id",week.getId());
		System.out.println("month id  is " + week.getId());
		query.executeUpdate();
		tr.commit();
		session.close();
		System.out.println("Done");

	}
	public List<Week> checkExist() {
		String hql = "FROM Week WHERE monthOfYear = :month AND weekOfMonth = :week AND currentYear = :year";
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		Query<Week> query = session.createQuery(hql, Week.class);
		query.setParameter("month", DateProcess.getInstance().takeMonthOfYear());
		query.setParameter("week", DateProcess.getInstance().takeWeekOfMonth());
		query.setParameter("year", DateProcess.getInstance().takeCurrentYear());
		List<Week> list = query.list();
		tr.commit();
		session.close();

		return list;

	}

	public void createIfNotExit() {
		List<Week> list = checkExist();
		if (list.size() == 0) {
			Week w = new Week();
			insert(w);
		} else {
			System.out.println("already existing");
		}
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

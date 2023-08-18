package dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.IdentifierEqExpression;
import org.hibernate.query.Query;
import model.Day;
import util.HiberUtil;

public class DayDao implements DaoInterface<Day> {
	public static DayDao getInstance() {
		return new DayDao();
	}

	public void insert(Day d) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		session.save(d);
		tr.commit();
		session.close();
	}

	public List<Day> selectAll() {
		Session session = getSS();
		String hql = "from Day";
		Query<Day> query = session.createQuery(hql, Day.class);
		List<Day> resultList = query.list();

		session.close();
		return resultList;
	}

	public void remove(Day d) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		session.remove(d);
		tr.commit();
		session.close();
	}

	public void updateWithStatement(Day day) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		String hqlUpdate = "Update Day set food= :food, utilities = :utilities, entertainment = :entertainment ,"+
		" transportation = :transportation, shopping = :shopping,"+
		" study = :study, groceries = :groceries, totalDay = :total where id = :id";
		Query query = session.createQuery(hqlUpdate);
		query.setParameter("food",day.getFood());
		query.setParameter("utilities",day.getUtilities());
		query.setParameter("entertainment",day.getEntertainment());
		query.setParameter("transportation",day.getTransportation());
		query.setParameter("shopping",day.getShopping());
		query.setParameter("study",day.getStudy());
		query.setParameter("groceries",day.getGroceries());
		query.setParameter("total",day.getTotalDay());
		query.setParameter("id",day.getId());
		System.out.println("id is " + day.getId());
		query.executeUpdate();
		tr.commit();
		session.close();
		System.out.println("Done");

	}

	public void update(Day d) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		session.update(d);
		tr.commit();
		session.close();
	}

	public Day getDayByID(int id) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		Day w1 = session.find(Day.class, id);
		tr.commit();
		session.close();
		return w1;
	}
	public Day getDayByDate(Date date) {
		String hql = "from Day where date = :date";
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		Query<Day>  query = session.createQuery(hql);
		query.setParameter("date", date);
		Day result = query.uniqueResult();
		tr.commit();
		session.close();
		return result;
	}

	public int getIDFromDayTable() {
		int id = 0;
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		try {
			String hql = "select Max(id) from Day";
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

	public Session getSS() {
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

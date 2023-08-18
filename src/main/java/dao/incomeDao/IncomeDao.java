package dao.incomeDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.DaoInterface;
import model.income.Income;
import util.HiberUtil;

public class IncomeDao implements DaoInterface<Income> {

	public void insert(Income d) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		session.save(d);
		tr.commit();
		session.close();
	}

	public void remove(Income d) {
		// TODO Auto-generated method stub
		
	}
	
	public Session getSS() {
		SessionFactory sessionFactory = HiberUtil.getSessionfactory();
		Session session = sessionFactory.openSession() ;
		return session;
	}

}

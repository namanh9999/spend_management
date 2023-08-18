package dao.loanDao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.DaoInterface;
import model.loan.Information;
import util.HiberUtil;

public class InformationDao implements DaoInterface<Information>{
	public static InformationDao getInstance() {
		return new InformationDao();
	}
	@Override
	public void insert(Information d) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		session.save(d);
		tr.commit();
		session.close();
	}
	public Information findInfor(int id) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		Information loan =session.find(Information.class, id);
		tr.commit();
		session.close();
		return loan;
	}
	@Override
	public void remove(Information d) {
		// TODO Auto-generated method stub
		
	}
	
	private Session getSS() {
		SessionFactory sessionFactory = HiberUtil.getSessionfactory();
		Session session = sessionFactory.openSession();
		return session;
		
	}

}

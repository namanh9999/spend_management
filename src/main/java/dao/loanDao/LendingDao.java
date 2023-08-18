package dao.loanDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.DaoInterface;
import model.loan.Creditworthiness;
import model.loan.Lending;
import util.HiberUtil;

public class LendingDao implements DaoInterface<Lending> {
	public static LendingDao getInstance() {
		return new LendingDao();
	}
	@Override
	public void insert(Lending d) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		session.save(d);
		tr.commit();
		session.close();
	}
	public Lending selectByID(int id) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		Lending query = session.find(Lending.class, id);
		tr.commit();
		session.close();
		return query;
	}
	public void updatePaymentStatusById(int id,String status ) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		Lending lending = selectByID(id);
		lending.setPaymentStatus(status);
		session.saveOrUpdate(lending);
		tr.commit();
		session.close();
	}

	public void updatePaymentStatusById(int id,String status , String credName ) {
		Creditworthiness cred = CreditworthinessDao.getInstance().selectByName(credName);
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		Lending lending = selectByID(id);
		lending.setPaymentStatus(status);
		lending.setCreditworthiness_id(cred);
		session.saveOrUpdate(lending);
		tr.commit();
		session.close();
		
	}
	@Override
	public void remove(Lending d) {
		// TODO Auto-generated method stub
	}
	public Session getSS(){
		SessionFactory sessionFactory = HiberUtil.getSessionfactory();
		Session session = sessionFactory.openSession();
		return session;
	}

}

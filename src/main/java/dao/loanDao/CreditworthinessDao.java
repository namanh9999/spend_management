package dao.loanDao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.DaoInterface;
import model.loan.Creditworthiness;
import util.HiberUtil;

public class CreditworthinessDao implements DaoInterface<Creditworthiness> {

	public static CreditworthinessDao getInstance() {
		return new CreditworthinessDao();
	}

	@Override
	public void insert(Creditworthiness d) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		session.save(d);
		tr.commit();
		session.close();
	}

	@Override
	public void remove(Creditworthiness d) {
		// TODO Auto-generated method stub

	}

	public Creditworthiness selectByName(String credName) {
		Creditworthiness cred = null;
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		String hql = "from Creditworthiness where name = :name";
		Query<Creditworthiness> query = session.createQuery(hql);
		query.setParameter("name", credName);
		List<Creditworthiness> list = query.list();
		tr.commit();
		session.close();
		for (Creditworthiness crd : list) {
			cred = crd;
		}
		return cred;
	}

	public Creditworthiness selectByID(int id) {
		Creditworthiness cred = null;
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		cred = session.find(Creditworthiness.class,id);
		tr.commit();
		session.close();
		return cred;
	}

	private Session getSS() {
		SessionFactory sessionFactory = HiberUtil.getSessionfactory();
		Session session = sessionFactory.openSession();
		return session;
	}
}

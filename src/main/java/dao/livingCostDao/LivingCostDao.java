package dao.livingCostDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.DaoInterface;
import model.livingCost.LivingCost;
import util.HiberUtil;

public class LivingCostDao implements DaoInterface<LivingCost>{

	public static LivingCostDao getInstance() {
		return new LivingCostDao();
	}
	
	@Override
	public void insert(LivingCost d) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		session.save(d);
		tr.commit();
		session.close();
	}

	@Override
	public void remove(LivingCost d) {
		// TODO Auto-generated method stub
		
	}

	public Session getSS(){
		SessionFactory sessionFactory = HiberUtil.getSessionfactory();
		Session session = sessionFactory.openSession();
		return session;
	}


}

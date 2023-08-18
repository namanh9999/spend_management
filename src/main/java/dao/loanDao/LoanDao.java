package dao.loanDao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.DaoInterface;
import model.loan.Loan;
import util.HiberUtil;

public class LoanDao implements DaoInterface<Loan> {

	public static LoanDao getInstance() {
		return new LoanDao();
	}

	@Override
	public void insert(Loan d) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		session.save(d);
		tr.commit();
		session.close();
	}

	@Override
	public void remove(Loan d) {

	}

	public void getAllLoan() {
		int result = 1;
		Session session = getSS();
		String hql = "select l.loanDate, l.paymentDeadline, l.lendOfPay, l.infor_id.fullName from Loan as l ";
		Query<Object[]> query = session.createQuery(hql);
		List<Object[]> list = query.list();
		// to do
		for (Object[] obj : list) {
			Date loanDate = Date.valueOf(obj[0] + "");
			Date paymentDeadLine = Date.valueOf(obj[1] + "");
			String lendTemp = obj[2] + "";
			String criticalLevel = "";
			if (lendTemp.equals("1")) {
				criticalLevel = "level 1";
			} else if (lendTemp.equals("2")) {
				criticalLevel = "level 2";
			} else if (lendTemp.equals("3")) {
				criticalLevel = "level 3";
			} else if (lendTemp.equals("4")) {
				criticalLevel = "level 4";
			}
			String ownnerName = obj[3] + "";
			System.out.println("Loan Date : " + loanDate + "Payment Dead Line " + paymentDeadLine + " Critical Level : " + criticalLevel + "Owner Name : "  + ownnerName);

		}

		//return list;
	}
//	public Loan findInfor(int id) {
//		Session session = getSS();
//		Transaction tr = session.beginTransaction();
//		Loan loan =session.find(Loan.class, id);
//		tr.commit();
//		session.close();
//		return loan;
//	}

	public Session getSS() {
		SessionFactory sessionFactory = HiberUtil.getSessionfactory();
		Session session = sessionFactory.openSession();
		return session;
	}

}

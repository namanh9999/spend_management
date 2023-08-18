package dao.loanDao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.loan.Creditworthiness;
import model.loan.Lending;
import util.DateProcess;
import util.HiberUtil;

public class CentralDao {
	public static CentralDao getInstance() {
		return new CentralDao();
	}

	public void creditRatingForLending() {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		String hql = "select l.loanDate, l.paymentDeadline, l.payDay,l.creditworthiness_id.name, l.infor_id.fullName from Lending as l";
		Query<Object[]> query = session.createQuery(hql);
		List<Object[]> list = query.list();
		tr.commit();
		session.close();
		for (Object[] obj : list) {
			Date loanDate = Date.valueOf(obj[0] + "");
			Date paymentDeadline = Date.valueOf(obj[1] + "");
			// Date payDay = Date.valueOf(obj[2] + "");
			String creditworthiness = obj[3] + "";
			String loaner = obj[4] + "";
			String payDayMessage = "";
//			if(payDay == null) {
//				 payDayMessage = "unpaid";
//			}else {
//				 payDayMessage = String.valueOf(payDay);
//			}
			System.out.println("Loaner : " + loaner + "| creditworthiness : " + creditworthiness + "| Loan Date : "
					+ loanDate + "| paymentDeadline : " + paymentDeadline + " | payDay : ");
		}
	}

	public void checkPaymentDeadline() {
		int result = 1;
		Session session = getSS();
		String hql = "select  id , payDay, paymentDeadline, creditworthiness_id.name from Lending where creditworthiness_id.name = \'Good \'";
		Query<Object[]> query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for (Object[] obj : list) {
			var payDay = "";
			int compare = 0;
			if (obj[0] == null) {
				payDay = "Unpaid";
			} else {

			}
			Date paymentDeadline = Date.valueOf(obj[1] + "");
			String creditworthinessName = obj[2] + "";
			System.out.println("Pay Day : " + payDay + compare + " | Payment Dealine : " + paymentDeadline
					+ "Creditworthiness Name : " + creditworthinessName);
		}
	}

	private List<Object[]> getDataToCreditScoring() {
		try (Session session = getSS();) {

			Transaction tr = session.beginTransaction();
			String hql = "select l.loan, l.payDay, l.paymentDeadline, l.paid from Lending";
			Query query = session.createQuery(hql);
			List<Object[]> result = query.list();
			tr.commit();
			session.close();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// used to decision credit scoring
	public List getAmountOfMoney() {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		String hql1 = "from Lending";
		String hql = "select l.loan from Lending as l";
		Query query = session.createQuery(hql);
		List result = query.list();
		tr.commit();
		session.close();
		for (Object obj : result) {
			System.out.println(obj.toString());
		}
		return result;
	}

	public List getPaid() {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		String hql = "select l.paid from Lending as l";
		Query query = session.createQuery(hql);
		List result = query.list();
		tr.commit();
		session.close();
		for (Object obj : result) {
			System.out.println(obj.toString());
		}
		return result;
	}

	public void comparePayDayAndPaymentDeadline() {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		String hql = "select l.id, l.paid, l.payDay, l.paymentDeadline, l.loan from Lending as l ";
		Query query = session.createQuery(hql);
		List<Object[]> result = query.list();
		tr.commit();
		session.close();
		Date today = DateProcess.getInstance().getCurrentDay();

		for (Object[] obj : result) {
			String temp = obj[2] + "";
			Date paymentDeadline = Date.valueOf(obj[3] + "");
			Date payDay = null;
			if (checkPayDay(temp) == true) {
				payDay = Date.valueOf(temp);
				System.out.println("Pay Day : "+payDay);
				System.out.println("PaymentDeadline : "+ paymentDeadline);
				System.out.println("Updating 1 ");
				if (Boolean.valueOf(obj[1] + "") == true) {
					System.out.println("obj[1] is true ");
					if (payDay.after(paymentDeadline)) {
						System.out.println("pay day after paymentDeadline");
						String paymentStatus = "Overpaid";
						LendingDao.getInstance().updatePaymentStatusById(Integer.valueOf(obj[0] + ""), paymentStatus, "Bad Debt");
						System.out.println("Updated");
					} else if (payDay.before(paymentDeadline)) {
						System.out.println("pay day before paymentDeadline");
						String paymentStatus = "Pay On Time";
						LendingDao.getInstance().updatePaymentStatusById(Integer.valueOf(obj[0] + ""), paymentStatus);
						System.out.println("Updated ");
					} else {
						System.out.println("pay day equal paymentDeadline");
						String paymentStatus = "Pay On Time";
						LendingDao.getInstance().updatePaymentStatusById(Integer.valueOf(obj[0] + ""), paymentStatus);
						System.out.println("Updated ");
					}
				}
			} else {
				System.out.println("obj[1] is false ");
				if (today.after(paymentDeadline)) {
					String paymentStatus = "Unpaid";
					LendingDao.getInstance().updatePaymentStatusById(Integer.valueOf(obj[0] + ""), paymentStatus);
				}
			}
		}
	}

	private boolean checkPayDay(String data) {
		boolean result = false;
		if (!data.equals("null")) {
			result = true;
		}
		return result;
	}

	private void updateInfor(String note, Creditworthiness status) {

	}

	public Creditworthiness selectCreditworthinessByName(String name) {
		Session session = getSS();
		Transaction tr = session.beginTransaction();
		String hql = " from Creditworthiness where name = :name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		List<Creditworthiness> crd = query.list();
		tr.commit();
		session.close();
		if (!crd.isEmpty()) {
			return crd.get(0);
		} else {
			return null;
		}
	}

	private Session getSS() {
		SessionFactory sessionFactory = HiberUtil.getSessionfactory();
		Session session = sessionFactory.openSession();
		return session;
	}
}

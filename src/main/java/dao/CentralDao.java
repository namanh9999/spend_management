package dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Day;
import model.Expenses;
import model.Month;
import model.Week;
import util.DateProcess;
import util.HiberUtil;

public class CentralDao {
	public static CentralDao getInstance() {
		return new CentralDao();
	}

	// get session from HiberUtil
	public Session getSS() {
		SessionFactory sessionFactory = HiberUtil.getSessionfactory();
		Session session = sessionFactory.openSession();
		return session;
	}

	// add parameter
	// I'm running test there
	public void getCurrentWeek() {

		Session session = getSS();
		Transaction tr = session.beginTransaction();
		String hqlExpense = "from Day where date='2023-06-15'";
		Query<Expenses> queryExpense = session.createQuery(hqlExpense);
		List<Expenses> list = queryExpense.list();
		tr.commit();
		session.close();
		for (Expenses day : list) {
			System.out.println(day.toString());
		}
	}

	private void updateValueForDay(Date dateToFind, Day day, int week_id) {
		int id = day.getId();
		String hql = "select e.amount,e.date , e.category_id.name, e.day_id.date from Expenses as e  where date = :date";
		Session session = getSS();
		Query<Object[]> query = session.createQuery(hql);
		query.setParameter("date", dateToFind);
		List<Object[]> list = query.list();
		session.close();

		double entertainment = 0;
		double food = 0;
		double groceries = 0;
		double shopping = 0;
		double study = 0;
		double transpotation = 0;
		double utilities = 0;
		double total = 0;

		for (Object[] obj : list) {
			double amount = Double.valueOf(obj[0] + "");
			System.out.println("Amount is : " + amount);
			Date date = Date.valueOf(obj[1] + "");
			String categoryName = obj[2] + "";
			System.out.println("Category name is : " + categoryName);
			Date dateInDay = Date.valueOf(obj[3] + "");
			if (categoryName.equals("Groceries")) {
				groceries += amount;
			} else if (categoryName.equals("Entertainment")) {
				entertainment += amount;
			} else if (categoryName.equals("Transportation")) {
				transpotation += amount;
			} else if (categoryName.equals("Shopping")) {
				shopping += amount;
			} else if (categoryName.equals("Utilities")) {
				utilities += amount;
			} else if (categoryName.equals("Study")) {
				study += amount;
			} else if (categoryName.equals("Food")) {
				food += amount;
			}
		}
		System.out.println("Size of Object List = " + list.size());
		total = entertainment + food + groceries + shopping + study + shopping + utilities + transpotation;
		System.out.println("total is = " + total);

		Day day1 = new Day(food, utilities, entertainment, transpotation, shopping, study, groceries, total, dateToFind,
				WeekDao.getInstance().getWeekByID(week_id));
		day1.setId(id);
		DayDao.getInstance().updateWithStatement(day1);
		updateValueForWeek(week_id);
	}

	private void updateValueForWeek(int week_id) {
		String hql = "from Day as e where e.week_id.id = :week";
		Session session = getSS();
		Query<Day> query = session.createQuery(hql);
		query.setParameter("week", week_id);
		List<Day> list = query.list();
		session.close();

		double entertainment = 0;
		double food = 0;
		double groceries = 0;
		double shopping = 0;
		double study = 0;
		double transportation = 0;
		double utilities = 0;
		double total = 0;
		Week id = null;
		int month_id = 0;
		for (Day d : list) {
			entertainment += d.getEntertainment();
			food += d.getFood();
			groceries += d.getGroceries();
			shopping += d.getShopping();
			study += d.getStudy();
			transportation += d.getTransportation();
			utilities += d.getUtilities();
			total += d.getTotalDay();
			id = d.getWeek_id();
			month_id = d.getWeek_id().getMonth_id().getId();
		}
		Week w1 = new Week(food, utilities, entertainment, transportation, shopping, study, groceries, total);
		w1.setId(week_id);
		WeekDao.getInstance().updateWithStatement(w1);
		updateValueForMonth(month_id);
	}

	private void updateValueForMonth(int month_id) {
		String hql = "from Week as e where e.month_id.id = :month";
		Session session = getSS();
		Query<Week> query = session.createQuery(hql);
		query.setParameter("month", month_id);
		List<Week> list = query.list();
		session.close();

		double entertainment = 0;
		double food = 0;
		double groceries = 0;
		double shopping = 0;
		double study = 0;
		double transportation = 0;
		double utilities = 0;
		double total = 0;
		Month id = null;
		for (Week d : list) {
			entertainment += d.getEntertainment();
			food += d.getFood();
			groceries += d.getGroceries();
			shopping += d.getShopping();
			study += d.getStudy();
			transportation += d.getTransportation();
			utilities += d.getUtilities();
			total += d.getTotal();
			id = d.getMonth_id();
		}
		Month m1 = new Month(food, utilities, entertainment, transportation, shopping, study, groceries, total);
		m1.setId(month_id);
		MonthDao.getInstance().updateWithStatement(m1);

	}

	// get Specified like Day, Week , Month and Year
	public List<Week> getSpecifiedWeek() {
		try (Session session = getSS()) {
			String hqlWeek = "from Week where weekOfMonth = :week and monthOfYear = :month and currentYear = :year ";
			Query<Week> queryWeek = session.createQuery(hqlWeek);
			queryWeek.setParameter("week", DateProcess.getInstance().takeWeekOfMonth());
			queryWeek.setParameter("month", DateProcess.getInstance().takeMonthOfYear());
			queryWeek.setParameter("year", DateProcess.getInstance().takeCurrentYear());
			return queryWeek.list();
		}
	}

	public List<Month> getSpecifiedMonth() {
		try (Session session = getSS()) {
			String hqlMonth = "from Month where  monthOfYear = :month and currentYear = :year ";
			Query<Month> queryMonth = session.createQuery(hqlMonth);
			queryMonth.setParameter("month", DateProcess.getInstance().takeMonthOfYear());
			queryMonth.setParameter("year", DateProcess.getInstance().takeCurrentYear());
			return queryMonth.list();
		}
	}

	public List<Day> getSpecifiedDay(Date day) {
		try (Session session = getSS()) {
			String hqlDay = "from Day where date= :date";
			Query<Day> queryDay = session.createQuery(hqlDay);
			queryDay.setParameter("date", day);
			return queryDay.list();
		}
	}

	// check and create a new field if not exist
	// to do
	public void checkDayAndCreatreExist(Week week, Expenses expense) {
		Date day = DateProcess.getInstance().getCurrentDay();
		List<Day> list = getSpecifiedDay(day);
		if (list.isEmpty()) {
			Day newDay = new Day();
			newDay.setDate(day);
			newDay.setWeek_id(week);
			DayDao.getInstance().insert(newDay);
			expense.setDay(newDay);
			ExpensesDao.getInstance().insert(expense);
			try (Session session = getSS()) {
				Day result = session.find(Day.class, DayDao.getInstance().getIDFromDayTable());
				updateValueForDay(day, newDay, result.getWeek_id().getId());
			}
		} else {
			Date dayToFind = expense.getDate();
			Day dayToLink = DayDao.getInstance().getDayByDate(dayToFind);
			System.out.println("Day is already existing ");
			expense.setDay(dayToLink);
			ExpensesDao.getInstance().insert(expense);
			for (Day d : list) {
				int id = d.getId();
				int week_id = d.getWeek_id().getId();
				System.out.println(day.toString());
				try (Session session = getSS()) {
					Day result = session.find(Day.class, id);
					System.out.println(result.toString());
					updateValueForDay(day, result, week_id);
				}
			}
		}
	}

	public void checkWeekAndCreateIfNotExist(Month month, Expenses expense) {
		List<Week> list = getSpecifiedWeek();
		if (list.isEmpty()) {
			Week newCurrentWeek = new Week();
			newCurrentWeek.setWeekOfMonth(DateProcess.getInstance().takeWeekOfMonth());
			newCurrentWeek.setMonthOfYear(DateProcess.getInstance().takeMonthOfYear());
			newCurrentWeek.setCurrentYear(DateProcess.getInstance().takeCurrentYear());
			newCurrentWeek.setMonth_id(month);
			WeekDao.getInstance().insert(newCurrentWeek);
			checkDayAndCreatreExist(newCurrentWeek, expense);
		} else {
			System.out.println("Week is already existing ");
			int id = 0;
			for (Week w : list) {
				id = w.getId();
			}
			checkDayAndCreatreExist(WeekDao.getInstance().getWeekByID(id), expense);
		}

	}

	public void checkMonthAndCreateIfNotExist(Expenses expense) {
		List<Month> list = getSpecifiedMonth();
		if (list.isEmpty()) {
			Month newCurrentMonth = new Month();
			newCurrentMonth.setMonthOfYear(DateProcess.getInstance().takeMonthOfYear());
			newCurrentMonth.setCurrentYear(DateProcess.getInstance().takeCurrentYear());
			MonthDao.getInstance().insert(newCurrentMonth);
			Week week = new Week();
			week.setMonth_id(newCurrentMonth);
			WeekDao.getInstance().insert(week);
			Day day = new Day();
			day.setWeek_id(week);
			DayDao.getInstance().insert(day);
			checkWeekAndCreateIfNotExist(newCurrentMonth, expense);
		} else {
			System.out.println("Month is already existing ");
			Month month = null;
			for (Month mt : list) {
				month = mt;
			}
			checkWeekAndCreateIfNotExist(month, expense);
		}
	}

}

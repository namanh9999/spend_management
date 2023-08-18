package test;

import java.sql.Date;
import java.util.List;

import dao.CategoryDao;
import dao.CentralDao;
import dao.DayDao;
import dao.ExpensesDao;
import dao.MonthDao;
import dao.WeekDao;
import model.Category;
import model.Day;
import model.Expenses;
import model.Month;
import model.Week;
import util.DateProcess;

public class test {

	public static void main(String[] args) {
//		WeekDao.getInstance().createIfNotExit();
//		Week w1 = WeekDao.getInstance().getWeekByID(1);
//		Day day = new Day(2.0, 9.0, 10.0, 10.0, 19.0, 5.0, 3.0, 3.0, DateProcess.getInstance().getCurrentDay(), w1);
//		DayDao.getInstance().insert(day);

//		Day day = DayDao.getInstance().getDayByID(14);
//
//      Category ct = new Category("Technology");
//		Category ct1 = new Category("Entertainment");
//		Category ct2 = new Category("Transportation");
//		Category ct3 = new Category("Shopping");
//		Category ct4 = new Category("Utilities");
//		Category ct5 = new Category("Study");
//		Category ct7 = new Category("Food");
//		CategoryDao.getInstance().insert(ct);
//		CategoryDao.getInstance().insert(ct1);
//		CategoryDao.getInstance().insert(ct2);
//		CategoryDao.getInstance().insert(ct3);
//		CategoryDao.getInstance().insert(ct4);
//		CategoryDao.getInstance().insert(ct5);
//		CategoryDao.getInstance().insert(ct7);
		Category ct = CategoryDao.getInstance().getCategoryByID(31);
		Category ct1 = CategoryDao.getInstance().getCategoryByID(32);
		Category ct2 = CategoryDao.getInstance().getCategoryByID(33);
		Category ct3 = CategoryDao.getInstance().getCategoryByID(34);
		Category ct4 = CategoryDao.getInstance().getCategoryByID(35);
		Category ct5 = CategoryDao.getInstance().getCategoryByID(36);
		Category ct7 = CategoryDao.getInstance().getCategoryByID(37);
//
//		for(int i = 0; i < 10 ; i++) {
//			
		Expenses exp = new Expenses(DateProcess.getInstance().getCurrentDay(), ct5, 164.0, "Book", "Credit Card",
				"1 doi quan tri ");
//		ExpensesDao.getInstance().insert(exp);
//		}
//		Expenses exp1 = new Expenses(DateProcess.getInstance().getCurrentDay(), ct, 100.0, "Paid two bowls", "Cash",

//				"Necessities, Groceries");
//		Expenses exp2 = new Expenses(DateProcess.getInstance().getCurrentDay(), ct3, 50.0, "Bought groceries",
//				"Credit Card", "Groceries, Food");
//		Expenses exp3 = new Expenses(DateProcess.getInstance().getCurrentDay(), ct1, 25.0, "Paid for transportation",
//				"Cash", "Transportation");
//		Expenses exp4 = new Expenses(DateProcess.getInstance().getCurrentDay(), ct2, 10.0, "Purchased stationery items",
//				"Debit Card", "Stationery");
//		Expenses exp5 = new Expenses(DateProcess.getInstance().getCurrentDay(), ct4, 75.0, "Paid for dining out",
//				"Cash", "Entertainment, Dining");
//		Expenses exp6 = new Expenses(DateProcess.getInstance().getCurrentDay(), ct7, 100.0, "Paid for dining out",
//				"Bank Transfer", "Entertainment, Dining");
//		ExpensesDao.getInstance().insert(exp1);
//		ExpensesDao.getInstance().insert(exp2);
//		ExpensesDao.getInstance().insert(exp3);
//		ExpensesDao.getInstance().insert(exp4);
//		ExpensesDao.getInstance().insert(exp5);
//		ExpensesDao.getInstance().insert(exp6);

//		String dayOfWeek = DateProcess.getInstance().takeDayOfWeek();
//		System.out.println(dayOfWeek);
//		int weekOfMonth = DateProcess.getInstance().takeWeekOfMonth();
//		System.out.println(weekOfMonth);
//		String monthOfYear = DateProcess.getInstance().takeMonthOfYear();
//		System.out.println(monthOfYear);
//		int dayOfMonth = DateProcess.getInstance().takeDayOfMonth();
//		System.out.println(dayOfMonth);
//
//		List<Day> resultList = DayDao.getInstance().selectAll();
//		for (Day i : resultList) {
//			System.out.println(i.toString());
//		}
//
//		Date date = DateProcess.getInstance().getCurrentDay();
//		CentralDao.getInstance().checkDayAndCreatreExist(date);

//		Day day1 = new Day()
//		day1.setDate(DateProcess.getInstance().getCurrentDay());
//		DayDao.getInstance().insert(day1);
//
//		Month month = new Month();
//		MonthDao.getInstance().insert(month);

//		int id = DayDao.getInstance().getIDFromDayTable();
//		System.out.println(id);
		 CentralDao.getInstance().checkMonthAndCreateIfNotExist(exp);
//		 CentralDao.getInstance().checkMonthAndCreateIfNotExist(exp1);
//		 CentralDao.getInstance().checkMonthAndCreateIfNotExist(exp2);
//		 CentralDao.getInstance().checkMonthAndCreateIfNotExist(exp3);
//		 CentralDao.getInstance().checkMonthAndCreateIfNotExist(exp4);
//		 CentralDao.getInstance().checkMonthAndCreateIfNotExist(exp6);
//		 CentralDao.getInstance().checkMonthAndCreateIfNotExist(exp5);
	}

}

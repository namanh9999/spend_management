package model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import util.DateProcess;

@Entity
public class Week extends General {
	private double total;
	private int weekOfMonth;
	private String monthOfYear;
	private int currentYear;
	@ManyToOne
	@JoinColumn(name="month_id")
	private Month month_id;
	public Week() {
		this.monthOfYear = DateProcess.getInstance().takeMonthOfYear();
		this.weekOfMonth = DateProcess.getInstance().takeWeekOfMonth();
		this.currentYear = DateProcess.getInstance().takeCurrentYear();
	}

	public Week(double food, double utilities, double entertainment, double transportation, double shopping,
			double study, double groceries, double total, int weekOfMonth, String monthOfYear, int currentYear, String id, Month month_id) {
		super(food, utilities, entertainment, transportation, shopping, study, groceries);
		this.total = calculateTotalExpenses();
		this.weekOfMonth = weekOfMonth;
		this.monthOfYear = DateProcess.getInstance().takeMonthOfYear();
		this.currentYear = DateProcess.getInstance().takeCurrentYear();
		this.month_id = month_id;
	}



	public Week(double food, double utilities, double entertainment, double transportation, double shopping,
			double study, double groceries, double total2) {
		super(food, utilities, entertainment, transportation, shopping, study, groceries);
		this.total = total2;
	}

	@Override
	public double calculateTotalExpenses() {
		// Implement the logic to calculate total expenses for the Specific class
		double totalExpenses = getFood() + getUtilities() + getEntertainment() + getTransportation() + getShopping()
				+ getStudy() + getGroceries();
		return totalExpenses;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public int getWeekOfMonth() {
		return weekOfMonth;
	}

	public void setWeekOfMonth(int weekOfMonth) {
		this.weekOfMonth = weekOfMonth;
	}

	public String getMonthOfYear() {
		return monthOfYear;
	}

	public void setMonthOfYear(String monthOfYear) {
		this.monthOfYear = monthOfYear;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Month getMonth_id() {
		return month_id;
	}

	public void setMonth_id(Month month_id) {
		this.month_id = month_id;
	}

	@Override
	public String toString() {
		return "Week [total=" + total + ", weekOfMonth=" + weekOfMonth + ", monthOfYear=" + monthOfYear
				+ ", currentYear=" + currentYear + ", month_id=" + month_id + ", getFood()=" + getFood() + ", getId()="
				+ getId() + ", getUtilities()=" + getUtilities() + ", getEntertainment()=" + getEntertainment()
				+ ", getTransportation()=" + getTransportation() + ", getShopping()=" + getShopping() + ", getStudy()="
				+ getStudy() + ", getGroceries()=" + getGroceries() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}

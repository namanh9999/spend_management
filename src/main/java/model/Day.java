package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import util.DateProcess;

@Entity
public class Day extends General {
	@Column(unique = true)
	private Date date;
	private double totalDay;
	private String monthOfYear;
	private int weekOfMonth;
	private int year;
	@ManyToOne
	@JoinColumn(name="week_id")
	private Week week_id;
	public Day() {
		this.weekOfMonth = DateProcess.getInstance().takeWeekOfMonth();
		this.year =  DateProcess.getInstance().takeCurrentYear();
		this.monthOfYear = DateProcess.getInstance().takeMonthOfYear();	
		this.date = DateProcess.getInstance().getCurrentDay();
	}

	public Day(double food, double utilities, double entertainment, double transportation, double shopping, 
			double study, double groceries, double totalDay, Date date, Week week_id ) {
		super(food, utilities, entertainment, transportation, shopping, study, groceries);
		this.weekOfMonth = DateProcess.getInstance().takeWeekOfMonth();
		this.year =  DateProcess.getInstance().takeCurrentYear();
		this.monthOfYear = DateProcess.getInstance().takeMonthOfYear();
		this.totalDay = calculateTotalExpenses();
		this.date = date;
		this.week_id = week_id;
	}
//		public Day(double food, double utilities, double entertainment, double transportation, double shopping, 
//				double study, double groceries, double totalDay, Date date, Week week_id ) {
//			super(food, utilities, entertainment, transportation, shopping, study, groceries);
//			this.weekOfMonth =weekOfMonth;
//			this.year =  currentYear;
//			this.monthOfYear = monthOfYear;
//			this.totalDay = ;
//			this.date = date;
//			this.week_id = week_id;
//		}
//

	@Override
	public double calculateTotalExpenses() {
		// Implement the logic to calculate total expenses for the Specific class
		double totalExpenses = getFood() + getUtilities() + getEntertainment() + getTransportation() + getShopping()
				+ getStudy() + getGroceries();
		return totalExpenses;
	}
	
	
	public Week getWeek_id() {
		return week_id;
	}

	public void setWeek_id(Week week_id) {
		this.week_id = week_id;
	}

	public double getTotalDay() {
		return totalDay;
	}

	public void setTotalDay(double totalDay) {
		this.totalDay = totalDay;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMonthOfYear() {
		return monthOfYear;
	}

	public void setMonthOfYear(String monthOfYear) {
		this.monthOfYear = monthOfYear;
	}

	public int getWeekOfMonth() {
		return weekOfMonth;
	}

	public void setWeekOfMonth(int weekOfMonth) {
		this.weekOfMonth = weekOfMonth;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Day [date=" + date + ", totalDay=" + totalDay + ", week_id=" + week_id + ", getFood()=" + getFood()
				+ ", getId()=" + getId() + ", getUtilities()=" + getUtilities() + ", getEntertainment()="
				+ getEntertainment() + ", getTransportation()=" + getTransportation() + ", getShopping()="
				+ getShopping() + ", getStudy()=" + getStudy() + ", getGroceries()=" + getGroceries() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}



}

package model;

import javax.persistence.Entity;

import util.DateProcess;

@Entity
public class Month extends General {
	private double total;
	private String monthOfYear;
	private int currentYear;
	private double rent;
	private double bill;

	public Month() {
		this.monthOfYear = DateProcess.getInstance().takeMonthOfYear();
		this.currentYear = DateProcess.getInstance().takeCurrentYear();
	}

	public Month(double food, double utilities, double entertainment, double transportation, double shopping,
			double study, double groceries, double total, String monthOfYear, int year) {
		super(food, utilities, entertainment, transportation, shopping, study, groceries);
		this.total = calculateTotalExpenses();
		this.monthOfYear = monthOfYear;
		this.currentYear = year;
	}

	public Month(double food, double utilities, double entertainment, double transportation, double shopping,
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

	public String getMonthOfYear() {
		return monthOfYear;
	}

	public void setMonthOfYear(String monthOfYear) {
		this.monthOfYear = monthOfYear;
	}

	public int getCurrnetYear() {
		return currentYear;
	}

	public void setCurrentYear(int year) {
		this.currentYear = year;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Month [monthOfYear=" + monthOfYear + ", year=" + currentYear + ", getFood()=" + getFood() + ", getId()="
				+ getId() + ", getUtilities()=" + getUtilities() + ", getEntertainment()=" + getEntertainment()
				+ ", getTransportation()=" + getTransportation() + ", getShopping()=" + getShopping() + ", getStudy()="
				+ getStudy() + ", getGroceries()=" + getGroceries() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}

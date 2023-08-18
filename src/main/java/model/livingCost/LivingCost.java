package model.livingCost;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import util.DateProcess;

@Entity
public class LivingCost {
	@Id
	@GeneratedValue
	private int id;
	private double rent;
	private double bill;
	private String month;
	private int year;

	public LivingCost() {
	}
	
	public LivingCost(double rent, double bill, String month, int year) {
		super();
		this.rent = rent;
		this.bill = bill;
		this.month = month;
		this.year = year;
	}

	public LivingCost(double rent, double bill) {
		this.rent = rent;
		this.bill = bill;
		this.month = DateProcess.getInstance().takeMonthOfYear();
		this.year = DateProcess.getInstance().takeCurrentYear();
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "LivingCost [rent=" + rent + ", bill=" + bill + "]";
	}
	
}

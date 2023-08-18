package model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Expenses {
	@Id
	@GeneratedValue
	private int id;
	private Date date;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="category_id")
	private Category category_id;
	private double amount;
	private String description;
	private String paymentMethod;
	private String tags;
	@ManyToOne
	@JoinColumn(name="day_id")
	private Day day_id;
	public Expenses() {
	}
	public Expenses(Date date, Category category_id, double amount, String description, String paymentMethod, String tags) {
		this.amount = amount;
		this.date = date;
		this.category_id = category_id;
		this.description = description;
		this.paymentMethod = paymentMethod;
		this.tags = tags;
	}

	public Expenses(Date date, Category category_id, double amount, String description, String paymentMethod, String tags, Day day_id) {
		this.amount = amount;
		this.date = date;
		this.category_id = category_id;
		this.description = description;
		this.paymentMethod = paymentMethod;
		this.tags = tags;
		this.day_id = day_id;
	}

	public Category getCategoryID() {
		return category_id;
	}


	public void setCategoryID(Category category_id) {
		this.category_id = category_id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Day getDay() {
		return day_id;
	}


	public void setDay(Day day_id) {
		this.day_id = day_id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	public String getCategory() {
		return category_id.getName();
	}


	public void setCategory(Category category) {
		this.category_id = category;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public String getTags() {
		return tags;
	}


	public void setTags(String tags) {
		this.tags = tags;
	}


	@Override
	public String toString() {
		return "Expenses [id=" + id + ", date=" + date + ", category=" + category_id + ", amount=" + amount + ", description="
				+ description + ", paymentMethod=" + paymentMethod + ", tags=" + tags + "]";
	}
	
}

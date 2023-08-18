package model.income;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Income {
	@Id
	@GeneratedValue
	private int id;
	private double saraly;
	private double otherIncome;
	private String note;
	
	
	public Income() {
	}

	public Income(double saraly, double otherIncome, String note) {
		this.saraly = saraly;
		this.otherIncome = otherIncome;
		this.note = note;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSaraly() {
		return saraly;
	}
	public void setSaraly(double saraly) {
		this.saraly = saraly;
	}
	public double getOtherIncome() {
		return otherIncome;
	}
	public void setOtherIncome(double otherIncome) {
		this.otherIncome = otherIncome;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Income [id=" + id + ", saraly=" + saraly + ", otherIncome=" + otherIncome + ", note=" + note + "]";
	}
}

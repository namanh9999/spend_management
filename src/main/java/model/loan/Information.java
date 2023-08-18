package model.loan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Information {
	@Id
	@GeneratedValue
	private int id ;
	private String fullName;
	private String phoneNumber;
	
	
	public Information() {
	}

	public Information(String fullName, String phoneNumber) {
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Information [id=" + id + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + "]";
	}
	
}

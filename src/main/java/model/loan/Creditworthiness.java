package model.loan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Creditworthiness {
	@Id
	@GeneratedValue
	private int id ;
	private String name;
	
	public Creditworthiness() {
	}
	public Creditworthiness( String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Creditworthiness [id=" + id + ", name=" + name + "]";
	}
	
}

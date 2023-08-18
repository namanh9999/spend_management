package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class General {
	@Id
	@GeneratedValue
	private int id;
    private double food;
    private double utilities;
    private double entertainment;
    private double transportation;
    private double shopping;
    private double study;
    private double groceries;

    public General() {
	}

	// Constructor
    public General( double food, double utilities, double entertainment, double transportation, double shopping,
                   double study, double groceries) {
        this.food = food;
        this.utilities = utilities;
        this.entertainment = entertainment;
        this.transportation = transportation;
        this.shopping = shopping;
        this.study = study;
        this.groceries = groceries;
    }

    // Abstract method to calculate total expenses
    public abstract double calculateTotalExpenses();
	// Getter and setter methods


    public double getFood() {
        return food;
    }
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFood(double food) {
        this.food = food;
    }

    public double getUtilities() {
        return utilities;
    }

    public void setUtilities(double utilities) {
        this.utilities = utilities;
    }

    public double getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(double entertainment) {
        this.entertainment = entertainment;
    }

    public double getTransportation() {
        return transportation;
    }

    public void setTransportation(double transportation) {
        this.transportation = transportation;
    }

    public double getShopping() {
        return shopping;
    }

    public void setShopping(double shopping) {
        this.shopping = shopping;
    }

    public double getStudy() {
        return study;
    }

    public void setStudy(double study) {
        this.study = study;
    }

    public double getGroceries() {
        return groceries;
    }

    public void setGroceries(double groceries) {
        this.groceries = groceries;
    }

	@Override
	public String toString() {
		return "General [id=" + id + ", food=" + food + ", utilities=" + utilities + ", entertainment=" + entertainment
				+ ", transportation=" + transportation + ", shopping=" + shopping + ", study=" + study + ", groceries="
				+ groceries + "]";
	}
    
    
}

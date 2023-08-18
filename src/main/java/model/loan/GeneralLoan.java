package model.loan;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class GeneralLoan {
	@Id
	@GeneratedValue
	private int id;
	private double loan;
	private Date loanDate;
	private Date paymentDeadline;
	private Date payDay;
	private String note;


	public GeneralLoan() {
	}


	public GeneralLoan( double loan, Date loanDate, Date paymentDeadline, Date payDay, String note) {
		super();
		this.loan = loan;
		this.loanDate = loanDate;
		this.paymentDeadline = paymentDeadline;
		this.payDay = payDay;
		this.note = note;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLoan() {
		return loan;
	}

	public void setLoan(double loan) {
		this.loan = loan;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Date getPaymentDeadline() {
		return paymentDeadline;
	}

	public void setPaymentDeadline(Date paymentDeadline) {
		this.paymentDeadline = paymentDeadline;
	}

	public Date getPayDay() {
		return payDay;
	}

	public void setPayDay(Date payDay) {
		this.payDay = payDay;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "GeneralLoan [id=" + id + ", loan=" + loan + ", loanDate=" + loanDate + ", paymentDeadline="
				+ paymentDeadline + ", payDay=" + payDay + ", note=" + note +"]";
	}

}

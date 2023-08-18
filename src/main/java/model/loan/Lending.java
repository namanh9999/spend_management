package model.loan;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Lending extends GeneralLoan{

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name="creditworthiness_id")
	private Creditworthiness creditworthiness_id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name="infor_id")
	private Information infor_id;
	private boolean paid;
	private String paymentStatus;
	public Lending() {
	}

	public Lending(double loan, Date loanDate, Date paymentDeadline, Date payDay, String note,
			 Creditworthiness creditworthiness_id, Information infor_id2, boolean paid, String paymentStatus) {
		super( loan, loanDate, paymentDeadline, payDay, note);
		this.creditworthiness_id = creditworthiness_id;
		this.infor_id = infor_id2;
		this.paid = paid;
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Creditworthiness getCreditworthiness_id() {
		return creditworthiness_id;
	}

	public void setCreditworthiness_id(Creditworthiness creditworthiness_id) {
		this.creditworthiness_id = creditworthiness_id;
	}

	public Information getInfor_id() {
		return infor_id;
	}

	public void setInfor_id(Information infor_id) {
		this.infor_id = infor_id;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	@Override
	public String toString() {
		return "Lending [creditworthiness_id=" + creditworthiness_id + ", infor_id=" + infor_id + ", paid=" + paid
				+ ", paymentStatus=" + paymentStatus + ", getId()=" + getId() + ", getLoan()=" + getLoan()
				+ ", getLoanDate()=" + getLoanDate() + ", getPaymentDeadline()=" + getPaymentDeadline()
				+ ", getPayDay()=" + getPayDay() + ", getNote()=" + getNote() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}


	

}

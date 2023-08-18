package model.loan;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Loan extends GeneralLoan{
	private int lendOfPay;
	@ManyToOne
	@JoinColumn (name="infor_id")
	private Information infor_id;
	public Loan() {

	}
	public Loan( double loan, Date loanDate, Date paymentDeadline, Date payDay,
			String note, int lendOfPay,Information infor_id) {
		super( lendOfPay, loanDate, paymentDeadline, payDay, note);
		this.lendOfPay = lendOfPay;
		this.infor_id = infor_id;
	}
	public int getLendOfPay() {
		return lendOfPay;
	}

	public void setLendOfPay(int lendOfPay) {
		this.lendOfPay = lendOfPay;
	}
	public Information getInfor_id() {
		return infor_id;
	}

	public void setInfor_id(Information infor_id) {
		this.infor_id = infor_id;
	}
	@Override
	public String toString() {
		return "Loan [lendOfPay=" + lendOfPay + ", infor_id=" + infor_id + ", getId()=" + getId() + ", getLoan()="
				+ getLoan() + ", getLoanDate()=" + getLoanDate() + ", getPaymentDeadline()=" + getPaymentDeadline()
				+ ", getPayDay()=" + getPayDay() + ", getNote()=" + getNote() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}


}

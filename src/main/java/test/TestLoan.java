package test;

import java.sql.Date;

import dao.loanDao.CentralDao;
import dao.loanDao.CreditworthinessDao;
import dao.loanDao.InformationDao;
import dao.loanDao.LendingDao;
import dao.loanDao.LoanDao;
import model.loan.Creditworthiness;
import model.loan.Information;
import model.loan.Lending;
import model.loan.Loan;

public class TestLoan {
	public static void main(String[] args) {
//		Information user1 = new Information("tran thi hoai thu", "0987654321");
//		Information user2 = new Information("vu ba nam anh", "123456789");
//		Information user3 = new Information("pham thanh luan", "6787890621");
//
//		InformationDao.getInstance().insert(user2);
//		InformationDao.getInstance().insert(user1);
//
//		Information u1 = InformationDao.getInstance().findInfor(1);
		Information u2 = InformationDao.getInstance().findInfor(2);
		Information u3 = InformationDao.getInstance().findInfor(2);
//
//		Loan loan1 = new Loan(50.0, new Date(2023 - 6 - 22), new Date(2023 - 6 - 30), null, "", 1, u2);
//		Loan loan2 = new Loan(100.0, new Date(2023 - 6 - 22), new Date(2023 - 6 - 30), null, "", 4, u1);
//		Loan loan3 = new Loan(139.0, new Date(2023 - 6 - 22), new Date(2023 - 7 - 30), null, "", 2, u1);
//		
//		LoanDao.getInstance().insert(loan3);
//		LoanDao.getInstance().insert(loan1);
//		LoanDao.getInstance().insert(loan2);
//		
//		
		// insert value to Creditworthiness table 
//		Creditworthiness cw = new Creditworthiness("Good");
//		Creditworthiness cw1 = new Creditworthiness("Pretty Good");
//		Creditworthiness cw2 = new Creditworthiness("Normal");
//		Creditworthiness cw3 = new Creditworthiness("Bad Debt");
//		
		// select  by id 
		Creditworthiness cw = new Creditworthiness("Good");

//		CreditworthinessDao.getInstance().insert(cw);
//		CreditworthinessDao.getInstance().insert(cw1);
//		CreditworthinessDao.getInstance().insert(cw2);
//		CreditworthinessDao.getInstance().insert(cw3);
//			
		Lending lend1 = new Lending( 600.0, new Date(2022-9-11), new Date(2023-10-11),null,"For pay for tuition ", cw, u2, false, null);
		Lending lend2 = new Lending(500.0, new Date(2022-9-11), new Date(2023-10-11),null,"Bad Debt" , cw, u3, false, null);
//		
		LendingDao.getInstance().insert(lend2);
		LendingDao.getInstance().insert(lend1);
//		CentralDao.getInstance().creditRatingForLending();
//		LoanDao.getInstance().getAllLoan();

//		CentralDao.getInstance().checkPaymentDeadline();
//		CentralDao.getInstance().getAmountOfMoney();
//		System.out.println(CentralDao.getInstance().selectCreditworthinessByName("Good"));

		CentralDao.getInstance().comparePayDayAndPaymentDeadline();
	}

}

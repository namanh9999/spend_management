package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDao;
import model.Category;
import model.Expenses;
import util.DateProcess;

/**
 * Servlet implementation class InputProcessor
 */
public class InputProcessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InputProcessor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String url = "";
		if (action.equals("addPage")) {
			getAndSetCategory(request);
			url = "/Expenses_UI/expenses_ui.jsp";
		} else if (action.equals("addValue")) {
			if (addValueForExpense(request) == 1) {
				getAndSetCategory(request);
				url = "/Expenses_UI/expenses_ui.jsp";
				System.out.println("insert complete");
			}
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	private int addValueForExpense (HttpServletRequest request) {
		int categoryID = Integer.valueOf(request.getParameter("category"));
		Category category = CategoryDao.getInstance().getCategoryByID(categoryID);
		int amount = Integer.valueOf(request.getParameter("amount"));
		String paymentMethod = request.getParameter("paymentMethod");
		String tag = request.getParameter("tag");
		String describe = request.getParameter("describe");
		Expenses exp = new Expenses(DateProcess.getInstance().getCurrentDay(), category, amount, tag, paymentMethod,
				describe);
		dao.CentralDao.getInstance().checkMonthAndCreateIfNotExist(exp);
		return 1;
	}

	private void getAndSetCategory(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Category> listCategory = CategoryDao.getInstance().selectAll();
		session.setAttribute("listCategory", listCategory);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}

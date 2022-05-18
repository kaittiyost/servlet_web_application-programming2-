package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDAO;

/**
 * Servlet implementation class topup
 */
@WebServlet("/topup.do")
public class topup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public topup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("Top Up Requese");
		int customer_id = Integer.parseInt(session.getAttribute("customer_id").toString());
		String balance = request.getParameter("balance");
		CustomerDAO cusDAO = new CustomerDAO();
		int topup = cusDAO.top_up(balance, customer_id);
		System.out.println(topup);
		//session.setAttribute("customer_balance", value);

		RequestDispatcher rd2 = request.getRequestDispatcher("updatebalance.jsp");
		rd2.forward(request, response);
		
	}

}

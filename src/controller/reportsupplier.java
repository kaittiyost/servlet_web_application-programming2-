package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReportDAO;

/**
 * Servlet implementation class reportsupplier
 */
@WebServlet("/reportsupplier.do")
public class reportsupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public reportsupplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ReportDAO reportDAO = new ReportDAO();
		if (session.getAttribute("user") != null) {
			
			ArrayList<HashMap<String, Object>> data = reportDAO.OrderBySupplier();
			//System.out.println(data);
			request.setAttribute("reportsupplier", data);

			RequestDispatcher obj = request.getRequestDispatcher("reportsupplier.jsp");
			obj.forward(request, response);
		} else {
			RequestDispatcher obj = request.getRequestDispatcher("login.jsp");
			obj.forward(request, response);
		}
	}

}

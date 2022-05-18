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

import dao.ReportDAO;

@WebServlet("/reportstock.do")
public class reportstock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public reportstock() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReportDAO reportDAO = new ReportDAO();

		ArrayList<HashMap<String, Object>> data = reportDAO.OrderByStock();
		System.out.println(data);
		request.setAttribute("reportstock", data);

		RequestDispatcher obj = request.getRequestDispatcher("reportproductstock.jsp");
		obj.forward(request, response);
	}

}

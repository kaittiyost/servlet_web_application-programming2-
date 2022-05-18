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
import database.DatabaseConfig;

/**
 * Servlet implementation class reportcustomer
 */
@WebServlet("/reportcustomer.do")
public class reportcustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reportcustomer() {
        super();
       DatabaseConfig db = new DatabaseConfig();
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
		
		ReportDAO reportDAO = new ReportDAO();
		
		ArrayList<HashMap<String, Object>> data = reportDAO.OrderByCustomer();
		System.out.println(data);
		request.setAttribute("reportCustomer", data);
		
		RequestDispatcher obj = request.getRequestDispatcher("reportcustomer.jsp");
		obj.forward(request, response);
		
	}

}

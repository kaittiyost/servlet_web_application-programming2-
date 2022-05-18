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

/**
 * Servlet implementation class reportgooddatetime
 */
@WebServlet("/reportgoodsettime.do")
public class reportgoodsettime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reportgoodsettime() {
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
		String date_start = request.getParameter("date_start");
		String date_end = request.getParameter("date_end");
		
		ReportDAO reportDAO = new ReportDAO();
		ArrayList<HashMap<String , Object>> dataDatatime = reportDAO.ShowInvoiceDateTime(date_start, date_end);
		System.out.println(dataDatatime);
		
		request.setAttribute("invoice_date_time", dataDatatime);
		ArrayList<HashMap<String , Object>> newData = (ArrayList< HashMap <String,Object>>) request.getAttribute("invoice_date_time");
		System.err.println(newData);
		System.out.println("set Attribute Success!!");
		//response.sendRedirect("reportgooddatetime.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("reportgooddatetime.jsp");
		rd.forward(request, response);
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.websocket.Session;

import dao.CustomerDAO;
import dao.GoodDAO;
import database.DatabaseConfig;

@WebServlet("/checklogin.do")
public class checklogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public checklogin() {
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
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		CustomerDAO cusDAO = new CustomerDAO();
		GoodDAO gDAO = new GoodDAO();

		ArrayList<HashMap<String, Object>> data = cusDAO.checkLogin(username, password);
		System.out.println(data);
		if (data.equals(null)) {
			response.sendRedirect("login.jsp");

		} else {

			session.setAttribute("user", data);

			ArrayList<HashMap<String, Object>> dataGood = gDAO.ShowGoodInStock();

			session.setAttribute("datagood", dataGood);
			session.setAttribute("customer_id", data.get(0).get("id"));
			session.setAttribute("customer_balance", data.get(0).get("balance"));
			RequestDispatcher rd2 = request.getRequestDispatcher("online_shop.jsp");
			rd2.forward(request, response);
		}

	}

}

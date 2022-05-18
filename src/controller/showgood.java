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
import javax.websocket.Session;

import dao.GoodDAO;

/**
 * Servlet implementation class showgood
 */
@WebServlet("/showgood.do")
public class showgood extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public showgood() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null) {
		GoodDAO gDAO = new GoodDAO();
		ArrayList<HashMap<String, Object>> data = gDAO.ShowGoodInStock();
		
		request.setAttribute("allGoodInStock", data);
		
		RequestDispatcher obj = request.getRequestDispatcher("online_shop.jsp");
		obj.forward(request, response);
		}else {
			RequestDispatcher obj = request.getRequestDispatcher("login.jsp");
			obj.forward(request, response);
		}
	}

}

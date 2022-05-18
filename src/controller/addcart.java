package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.cartModel;

@WebServlet("/addcart.do")
public class addcart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public addcart() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!= null) {
			
		ArrayList<cartModel> cartList = new ArrayList<cartModel>();

		RequestDispatcher obj = request.getRequestDispatcher("cart.jsp");
		
		String[] good_id = request.getParameterValues("good_id");
		String good_name[] = request.getParameterValues("good_name");
		String good_unitprice[] = request.getParameterValues("good_unitprice");
		String good_total[] = request.getParameterValues("select");

		request.setAttribute("good_id", good_id);
		request.setAttribute("good_name", good_name);
		request.setAttribute("good_unitprice", good_unitprice);
		request.setAttribute("good_total", good_total);
		
		for (int i = 0; i < good_id.length; i++) {
			String g_id = good_id[i];
			String g_name = good_name[i];
			String g_unitprice = good_unitprice[i];
			String g_total = good_total[i];
			if(g_total.equals("0")) {
			
			}else {
				cartModel cart = new cartModel(g_id,g_name,g_unitprice,g_total);
				cartList.add(cart);
			}
		}
		
		session.setAttribute("cartList", cartList);
		//session.setAttribute("cartList_result", result);
		obj.forward(request, response);
		}else {
			
		}

	}

}

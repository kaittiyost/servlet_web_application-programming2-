package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import dao.CartDAO;

@WebServlet("/cartok.do")
public class cartok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/prog2")
	private DataSource jdbcTest;
	private Connection conn;

	public void init() {
		try {
			conn = jdbcTest.getConnection();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public cartok() {
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
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String good_id[] = request.getParameterValues("good_id");
		String total[] = request.getParameterValues("total");
		String good_name[] = request.getParameterValues("good_name");
		String unitprice[] = request.getParameterValues("unitprice");

		double sum_total = Double.parseDouble(request.getParameter("balance").toString());

		int customer_id = Integer.parseInt(session.getAttribute("customer_id").toString());
		double customer_balance = Double.parseDouble(session.getAttribute("customer_balance").toString());

		double new_balance = 0;

		if (customer_balance < sum_total) {
			out.print("<script>alert('ยอดเงินไม่พอจ้า'); location.href = 'cart.jsp';</script>");
			
		} else {
			int invoice_id = 0;
			CartDAO cDAO = new CartDAO();

			new_balance = customer_balance - sum_total;

			for (int i = 0; i < good_id.length; i++) {
				int insertToInvoice = cDAO.AddToInvoice(customer_id, sum_total);

				HashMap<String, Object> lastID = cDAO.GetLastIdInvloce();

				String invoiceId = lastID.get("c").toString();

				int insertToInvoiceDet = cDAO.AddToInvoiceDet(invoiceId, good_id[i], total[i]);

				int updateBalance = cDAO.UpdateBalance(new_balance, customer_id);
				if(updateBalance == 1) {
					session.setAttribute("customer_balance", new_balance);
				}
				int updateStock = cDAO.UpdateStock(total[i], good_id[i]);
			}
			System.out.println("::::::::::::::::[ OK ]:::::::::::::");
			session.removeAttribute("cartList");

//			try {
//				Statement stmt = conn.createStatement();
//				
//				
//				for(int i = 0 ; i < good_id.length ; i++) {
//				//--------- insert to invoice
//				String sql = "INSERT INTO invoice(customer_id,total_amount) VALUES("+
//						customer_id+","+sum_total+")";
//				System.out.println(sql);
//				boolean status = stmt.execute(sql);
//				
//							
//				//-------- get LastID invloce
//				String sql2 = "SELECT MAX(id) as c FROM invoice";
//				System.out.println(sql2);
//				boolean status2 = stmt.execute(sql2);
//				rs1 = stmt.executeQuery(sql2);
//				if (rs1.next()) {
//					System.err.println(rs1.getString("c"));
//					invoice_id = Integer.parseInt(rs1.getString("c"));
//				}
//				
//				
//				//--------- insert to invoice det
//				String sql3 = "INSERT INTO invoice_det(invoice_id,good_id,quantity) VALUES("+
//						invoice_id+","+good_id[i]+","+total[i]+")";
//				System.out.println(sql3);
//				boolean status3 = stmt.execute(sql3);		
//				
//				
//				//---------update balance 
//				
//				new_balance = customer_balance - sum_total;
//				String sql4 = "UPDATE customer SET balance = "+new_balance+" WHERE id ="+customer_id;
//				session.setAttribute("customer_balance", new_balance);
//				System.out.println(sql4);
//				boolean status4 = stmt.execute(sql4);
//				
//				
//				//---------update stock
//				String sql5 = "UPDATE stock SET replenish = replenish - "+total[i]+" WHERE good_id ="+good_id[i];
//				System.out.println(sql5);
//				boolean status5 = stmt.execute(sql5);
//
//				}
			// --------invoice
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

			out.print("<!DOCTYPE html>\n");
			out.print("<html>\n");
			out.print("<head>\n");
			out.print(" <title>Rauy-invoice</title>\n");
			out.print(
					"<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">");
			out.print(
					"<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>");//
			out.print(
					"<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx\" crossorigin=\"anonymous\"></script>");
			out.print(" <style>\n");
			out.print("table {\n");
			out.print("  font-family: arial, sans-serif;\n");
			out.print("  border-collapse: collapse;\n");
			out.print("  width: 100%;\n");
			out.print("}\n");
			out.print("\n");
			out.print("td, th {\n");
			out.print("  border: 1px solid #dddddd;\n");
			out.print("  text-align: left;\n");
			out.print("  padding: 8px;\n");
			out.print("}\n");
			out.print("\n");
			out.print("tr:nth-child(even) {\n");
			out.print("  background-color: #dddddd;\n");
			out.print("}\n");
			out.print("</style>\n");
			out.print("</head>\n");
			out.print("<body>\n <div class=\"col-sm\">\n");
			out.print("<h1 style=\"text-align: center\">ใบเสร็จ<br>***********************<br></h1>\n");
			out.print("<h4 style=\"text-align: center\">รหัสลูกค้า "+session.getAttribute("customer_id").toString()+" </h4><br>\n");
			out.print("ร้าน รวย รวย รวย <br>\n");
			out.print("วันที่ " + formatter.format(date) + " <br>\n");
			out.print("เบอร์ : <br>\n");
			out.print("fax : \n");
			out.print("\n");
			out.print("<br>\n");
			out.print("<table class='table' style=\"margin-top: 50px\">\n");
			out.print("  <tr>\n");
			out.print("    <th>#</th>\n");
			out.print("    <th>Good id</th>\n");
			out.print("    <th>Good name</th>\n");
			out.print("    <th>quantity</th>\n");
			out.print("    <th>ราคาต่อชิ้น</th>\n");
			out.print("  </tr>\n");

			for (int i = 0; i < good_id.length; i++) {
				out.print("  <tr>\n");
				out.print("    <td>" + i + "</td>\n");
				out.print("    <td>" + good_id[i] + "</td>\n");
				out.print("    <td>" + good_name[i] + "</td>\n");
				out.print("    <td>" + total[i] + "</td>\n");
				out.print("    <td>" + unitprice[i] + "</td>\n");
				out.print("  </tr>\n");
			}
			out.print("</table>\n");
			out.print("<div style=\"text-align: right ; margin-top: 30px\">ราคารวม " + sum_total + " บาท<div>\n");
			out.print("<div style=\"text-align: right ; margin-top: 30px\">ยอดเงินคงเหลือ " + new_balance
					+ " บาท<div>\n");
			out.print("\n");
			out.print(" <br>\n");
			out.print(" <br>\n");
			out.print(" <div style=\"text-align:center\">\n");
			out.print(" <a href='report.jsp' >BACK</a> | <button >SAVE</button>\n");
			out.print(" </div>\n");
			out.print("</div></body>\n");
			out.print("</html>");
//
//				
//				session.removeAttribute("cartList");
//			} catch (SQLException ex) {
//				ex.getMessage();
//				out.println("Error " + ex);
//			
//			}
		}
	}
}
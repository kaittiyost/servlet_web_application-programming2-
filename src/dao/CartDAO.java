package dao;

import java.util.HashMap;

import database.DatabaseConfig;

public class CartDAO {
	DatabaseConfig db;
	public CartDAO() {
		db = new DatabaseConfig();
	}
	
	public int AddToInvoice(int customer_id , double sum_total) {
		String sql = "INSERT INTO invoice(customer_id,total_amount) VALUES("+
				customer_id+","+sum_total+")";
		return db.add(sql);
	}
	
	public HashMap<String, Object> GetLastIdInvloce(){
		String sql = "SELECT MAX(id) as c FROM invoice";
		return db.querySingle(sql);
	}
	
	public int AddToInvoiceDet(String invoice_id , String good_id , String total ) {
		String sql = "INSERT INTO invoice_det(invoice_id,good_id,quantity) VALUES("+
				invoice_id+","+good_id+","+total+")";
		return db.add(sql);
	}
	
	public int UpdateBalance(double new_balance , int customer_id) {
		String sql = "UPDATE customer SET balance = "+new_balance+" WHERE id ="+customer_id;
		return db.update(sql);
	}
	
	public int UpdateStock(String total , String good_id) {
		String sql = "UPDATE stock SET replenish = replenish - "+total+" WHERE good_id ="+good_id;
		return db.update(sql);
	}
}

package dao;

import java.util.ArrayList;
import java.util.HashMap;

import database.DatabaseConfig;

public class InvoiceDAO {
DatabaseConfig db;
	public InvoiceDAO() {
		db = new DatabaseConfig();
	}
	
	public int InsertToInvoice(String customer_id , String sum_total){
		String sql = "INSERT INTO invoice(customer_id,total_amount) VALUES("+
				customer_id+","+sum_total+")";
		return db.add(sql);
	}
	
	public HashMap<String, Object> GetLastIdInvloce(){
		String sql = "SELECT MAX(id) as c FROM invoice";
		return db.querySingle(sql);
	}
	
	public int InsertToInvoiceDet(){
		
		return 0;
	}
	
	public int UpdateBalance () {
		
		return 0;
	}
	
	public int UpdateStock() {
		
		return 0;
	}
}

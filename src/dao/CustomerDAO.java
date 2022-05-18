package dao;

import java.util.ArrayList;
import java.util.HashMap;

import database.DatabaseConfig;

public class CustomerDAO {
	DatabaseConfig db;
	public CustomerDAO() {
		db = new DatabaseConfig();
	}
	
	public ArrayList<HashMap<String, Object>> checkLogin(String username , String password){
		String sql = "SELECT * FROM customer WHERE username = '" + username + "'" + " AND password = '"
				+ password + "'";
		return db.queryList(sql);
	}
	
	public int top_up(String balance , int customer_id) {
		String sql="UPDATE customer SET balance = balance+"+balance+" WHERE id ="+customer_id;
		return db.update(sql);
	}
}

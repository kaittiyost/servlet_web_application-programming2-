package dao;

import java.util.ArrayList;
import java.util.HashMap;

import database.DatabaseConfig;

public class GoodDAO {
	DatabaseConfig db;

	public GoodDAO() {
		db = new DatabaseConfig();
	}
	
	public ArrayList<HashMap<String, Object>> ShowGoodInStock (){
		String sql = "SELECT * , IF(stock.replenish > 0,stock.replenish, \"สินค้าหมด\") as replenish FROM stock , good\r\n"
				+ "WHERE stock.good_id = good.id";
		return db.queryList(sql);
	}
}

package dao;

import java.util.ArrayList;
import java.util.HashMap;

import database.DatabaseConfig;

public class ReportDAO {
	DatabaseConfig db;
	public ReportDAO() {
		db = new DatabaseConfig();
	}
	
	public ArrayList<HashMap<String, Object>> findOrderByGood() {
		String sql = "SELECT INVOICE.INVOICE_DATE,INVOICE.ID,INVOICE.CUSTOMER_ID,CUSTOMER.NAME as cus_name,INVOICE_DET.GOOD_ID,\n" +
				"GOOD.NAME as good_name ,GOOD.UNITPRICE,INVOICE_DET.QUANTITY,INVOICE.TOTAL_AMOUNT \n" +
				"FROM INVOICE,INVOICE_DET,CUSTOMER,GOOD \n" +
				"WHERE INVOICE_DET.GOOD_ID=GOOD.ID AND \n" +
				"INVOICE.CUSTOMER_ID=CUSTOMER.ID \n" +
				"AND INVOICE_DET.INVOICE_ID=INVOICE.ID \n" +
				"ORDER BY invoice_det.good_id ";
		return db.queryList(sql);
	}
	
	public ArrayList<HashMap<String, Object>> OrderByCustomer() {
		String sql = "SELECT a.* FROM(\r\n"
				+ "SELECT CUSTOMER.NAME as cus_name,INVOICE.INVOICE_DATE,INVOICE.ID,INVOICE.CUSTOMER_ID,INVOICE_DET.GOOD_ID,\r\n"
				+ "GOOD.NAME as good_name ,GOOD.UNITPRICE,INVOICE_DET.QUANTITY,INVOICE.TOTAL_AMOUNT \r\n"
				+ "FROM INVOICE,INVOICE_DET,CUSTOMER,GOOD \r\n"
				+ "WHERE INVOICE_DET.GOOD_ID=GOOD.ID AND \r\n"
				+ "INVOICE.CUSTOMER_ID=CUSTOMER.ID \r\n"
				+ "AND INVOICE_DET.INVOICE_ID=INVOICE.ID \r\n"
				+ "ORDER BY invoice.customer_id ) AS a";
		return db.queryList(sql);
	}
	
	public ArrayList<HashMap<String, Object>> OrderByStock() {
		String sql = "SELECT   GOOD.ID , GOOD.NAME , GOOD.UNITPRICE , STOCK.replenish \r\n"
				+ "FROM GOOD INNER JOIN STOCK WHERE GOOD.ID=STOCK.GOOD_ID ORDER BY ID ASC";
		return db.queryList(sql);
	}
	
	public ArrayList<HashMap<String, Object>> OrderBySupplier() {
		String sql = "SELECT PURCHASE.ID , supplier.`name` , PURCHASE.PURCHASE_DATE , \r\n"
				+ "PURCHASE.SUPPLIER_ID , PURCHASE_DET.GOOD_ID , \r\n"
				+ "PURCHASE.TOTAL_AMOUNT , PURCHASE.STATUS \r\n"
				+ "FROM PURCHASE , supplier , PURCHASE_DET \r\n"
				+ "WHERE PURCHASE.ID = PURCHASE_DET.PURCHASE_ID ORDER BY purchase.supplier_id";
		System.out.println(sql);
		return db.queryList(sql);
	}
	
	public ArrayList<HashMap<String, Object>> ShowInvoiceDateTime(String date_start , String date_end) {
		String sql ="SELECT INVOICE.INVOICE_DATE,INVOICE.ID,INVOICE.CUSTOMER_ID,CUSTOMER.NAME as cus_name,INVOICE_DET.GOOD_ID,\r\n"
				+ "GOOD.NAME as good_name ,GOOD.UNITPRICE,INVOICE_DET.QUANTITY,INVOICE.TOTAL_AMOUNT \r\n"
				+ "FROM INVOICE,INVOICE_DET,CUSTOMER,GOOD \r\n"
				+ "WHERE DATE_FORMAT( invoice.invoice_date, \"%Y-%m-%d\") BETWEEN '"+date_start+"' AND '"+date_end+"' AND INVOICE_DET.GOOD_ID=GOOD.ID AND \r\n"
				+ "INVOICE.CUSTOMER_ID=CUSTOMER.ID \r\n"
				+ "AND INVOICE_DET.INVOICE_ID=INVOICE.ID \r\n"
				+ "ORDER BY invoice_det.good_id";
		System.out.println(sql);
		return db.queryList(sql);
	}
}

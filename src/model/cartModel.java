package model;

public class cartModel {
	String good_id;
	String good_name;
	String good_unitprice;
	String total;
	public cartModel(String g_id, String g_name, String g_unitprice, String g_total) {
		this.good_id = g_id;
		this.good_name = g_name;
		this.good_unitprice = g_unitprice;
		this.total = g_total;
	}
	public String getGood_id() {
		return good_id;
	}
	public void setGood_id(String good_id) {
		this.good_id = good_id;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getGood_name() {
		return good_name;
	}
	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}
	public String getGood_unitprice() {
		return good_unitprice;
	}
	public void setGood_unitprice(String good_unitprice) {
		this.good_unitprice = good_unitprice;
	}
	
	
}

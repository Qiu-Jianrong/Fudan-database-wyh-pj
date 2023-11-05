package cn.qiu.domain;

import java.io.Serializable;

/*
 * 书籍实体类
 */
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;// 书籍id
	private String newness;// 书籍新度
	private double price;// 书籍价格
	private int number;// 库存，精确到二手书

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String id, String newness, double price, int number) {
		super();
		this.id = id;
		this.newness = newness;
		this.price = price;
		this.number = number;
	}

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getnewness() {
		return newness;
	}
	
	public void setnewness(String string) {
		this.newness = string;
	}

	public double getprice() {
		return price;
	}

	public void setprice(double price) {
		this.price = price;
	}

	public int getnumber() {
		return number;
	}

	public void setnumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", newness=" + newness + ", price=" + price + ", number=" + number + "]";
	}

}

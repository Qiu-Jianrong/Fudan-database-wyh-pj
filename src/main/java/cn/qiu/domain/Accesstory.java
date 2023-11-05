package cn.qiu.domain;

import java.io.Serializable;

/*
 * 书籍实体类
 */
public class Accesstory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;// 非书籍物品id
	private double price;// 价格
	private String name;// 名字

	public Accesstory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Accesstory(String id, double price, String name) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
	}

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	public double getprice() {
		return price;
	}

	public void setprice(double price) {
		this.price = price;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", price=" + price + ", name=" + name + "]";
	}

}

package cn.qiu.domain;

import java.io.Serializable;

/*
 * 书籍实体类
 */
public class Cart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String u_ID;// 用户id
	private String i_ID;// 物品id
	private String newness;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(String u_ID, String i_ID, String newness) {
		super();
		this.u_ID = u_ID;
		this.i_ID = i_ID;
		this.newness = newness;
	}

	public String getu_ID() {
		return u_ID;
	}

	public void setu_ID(String u_id) {
		this.u_ID = u_id;
	}
	
	public String geti_ID() {
		return i_ID;
	}

	public void seti_id(String i_id) {
		this.i_ID = i_id;
	}
	
	public String getnewness() {
		return newness;
	}

	public void setnewness(String newness) {
		this.newness = newness;
	}

	@Override
	public String toString() {
		return "Book [u_ID=" + u_ID + ", i_ID=" + i_ID  + ",newness=" + newness + "]";
	}

}

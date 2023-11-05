package cn.qiu.domain;

import java.io.Serializable;

/*
 * 商品实体类
 */
public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;// 商品id
	private int Class;// 种类
	private String img;// 图片

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(String id, int Class) {
		super();
		this.id = id;
		this.Class = Class;
	}

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}
	
	public int get_Class() {
		return Class;
	}

	public void set_Class(int Class) {
		this.Class = Class;
	}
	
	public String getimg() {
		return img;
	}

	public void setimg(String img) {
		this.img = img;
	}
	

	@Override
	public String toString() {
		return "Book [id=" + id + ", class=" + Class + "]";
	}

}

package cn.qiu.domain;

import java.io.Serializable;

/*
 * 书籍实体类
 */
public class Orders implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String u_ID;// 用户id
	private String i_ID;// 物品id
	private String newness; // 物品新度
	private String state;// 物流状态
	private String get_date;// 预计到达时间
	private int num;
	

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String u_id, String i_id, String newness, String state, String get_date, int num) {
		super();
		this.u_ID = u_id;
		this.i_ID = i_id;
		this.newness =newness;
		this.state = state;
		this.get_date = get_date;
		this.num = num;
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

	public void seti_ID(String i_id) {
		this.i_ID = i_id;
	}

	public void setnewness(String newness) {
		this.newness = newness;
	}
	
	public String getnewness() {
		return newness;
	}	
	
	public String getstate() {
		return state;
	}

	public void setstate(String state) {
		this.state = state;
	}

	public String getget_date() {
		return get_date;
	}

	public void setget_date(String get_date) {
		this.get_date = get_date;
	}
	
	public int getnum() {
		// TODO Auto-generated method stub
		return num;
	}
	public void setnum(int num) {
		// TODO Auto-generated method stub
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "Book [u_ID=" + u_ID + ", i_ID=" + i_ID + ",newness=" + newness + ", state=" + state + ", get_date=" + get_date + "]";
	}



}

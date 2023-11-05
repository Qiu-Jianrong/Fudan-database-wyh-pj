package cn.qiu.domain;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * Servlet implementation class user
 */
// @WebServlet("/user")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;// id
	private String username; // 用户名
	private String sex; // 性别
	private String tel; // 电话
	private String email; // 邮箱
	private String address; // 地址
	private String role; // 角色

	public User() {
		super();
	}

	public User(String id, String username, String sex, String tel , String email, String address) {
		super();
		this.id = id;
		this.username = username;
		this.sex = sex;
		this.tel = tel;
		this.email = email;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}	
	
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", tel=" + tel + ", email=" 
				+ email + ", address=" + address + ", role=" + role + "]";
	}

}

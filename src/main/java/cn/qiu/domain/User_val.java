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
public class User_val implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username; // 用户名
	private String password; // 密码
	private String role; // 角色

	public User_val() {
		super();
	}

	public User_val(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "user_val [username=" + username + ", password=" + password + ", role=" + role + "]";
	}

}

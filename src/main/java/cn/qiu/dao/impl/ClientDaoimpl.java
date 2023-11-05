package cn.qiu.dao.impl;

import java.io.IOException;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import cn.qiu.dao.ClientDao;
import cn.qiu.domain.*;

/**
 * Servlet implementation class ClientDao
 */
// @WebServlet("/ClientDao")
public class ClientDaoimpl implements ClientDao {
	private static final long serialVersionUID = 1L;
       
	@Override
	public User_val login(String username, String password, String role) throws Exception {
		User_val user = new User_val();
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，查看用户是否已经注册
		String sql = "select * from user_val where name = '" + username + "' and password = '" + password + "' and role = '" + role + "'";
		// String sql = "select * from user_val where name = '" + username + "'";		
		//4.将查询的结果返回过来
		ResultSet executeQuery = stat.executeQuery(sql);	
		if (executeQuery.next()) {
			user.setUsername(executeQuery.getString("name")); // in quota is the artribute name
			user.setPassword(executeQuery.getString("password"));
			user.setRole(executeQuery.getString("role"));
		} else {
		}
		return user;
	}

	@Override
	public boolean register1(User user) throws Exception {
		String id = user.getId();
		String username = user.getUsername();
		String sex = user.getSex();
		String tel = user.getTel();
		String email = user.getEmail();
		String address = user.getAddress();
   		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
		"root","fDu241530");
		
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，查看用户是否已经注册
		String sql = "select * from user where username = '" + username + "'";
		
		//4.将查询的结果返回过来
		ResultSet resultSet = stat.executeQuery(sql);

		if(resultSet.next() == false) {
			sql = "insert into user values(?, ?, ?, ?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, username);
			st.setString(3, sex);
			st.setString(4, tel);
			st.setString(5, email);
			st.setString(6, address);
			
			st.executeUpdate();
			return false;			
		}

		return true;
	}
	
	@Override
	public void register2(User_val user_val) throws Exception {
		String username = user_val.getUsername();
		String password = user_val.getPassword();
		String role = user_val.getRole();
		
   		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
		"root","fDu241530");
		
		//3.使用statement创建一个会话，运行SQL语句
		//定义SQL语句，插入对应值
		String sql = "insert into user_val values(?, ?, ?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, username);
		st.setString(2, password);
		st.setString(3, role);
		
		st.executeUpdate();	
	}

	@Override
	public boolean delete(String username) throws Exception {
		// TODO Auto-generated method stub
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，查看用户是否已经注册
		String sql = "select id from user where username = '" + username + "'";
		String id = null;
		ResultSet resultSet = stat.executeQuery(sql);
		if(resultSet.next())
			id = resultSet.getString("id");
		
		// 4.由于外码约束，先删除cart, order 和 user_val的
		sql = "delete from cart where u_id='" + id + "'";
		int res = stat.executeUpdate(sql);
		if(res == 0) {
			return false;
		}		
		
		sql = "delete from orders where u_id = '" + id + "'";		
		res = stat.executeUpdate(sql);
		if(res == 0) {
			return false;
		}
		
		sql = "delete from user_val where name = '" + username + "'";		
		res = stat.executeUpdate(sql);
		if(res == 0) {
			return false;
		}
		
		//5. 若删除成功，再删除user里的记录
		sql = "delete from user where username = '" + username + "'";
		res = stat.executeUpdate(sql);
		if(res == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean upgrade(String username) throws Exception {
		// TODO Auto-generated method stub
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，查看用户是否已经注册
		String sql = "update user_val set role = 'admin' where name = '" + username + "'";
				
		//4.返回成功与否
		int res = stat.executeUpdate(sql);
		if(res == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean downgrade(String username) throws Exception {
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，查看用户是否已经注册
		String sql = "update user_val set role = 'user' where name = '" + username + "'";
				
		//4.返回成功与否
		int res = stat.executeUpdate(sql);
		if(res == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean change_profile(User user) throws Exception {
		// TODO Auto-generated method stub
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，修改用户信息
		String sql = "update user set sex='" + user.getSex() + "',email='" + user.getEmail() +"',address='"+ user.getAddress() + "',tel='"+ user.getTel() + "' where username = '" + user.getUsername() + "'";
				
		int res = stat.executeUpdate(sql);
		if(res == 0)
			return false;
		return true;
	}

	@Override
	public User get_profile(String username) throws Exception {
		User user = new User();
		
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，查看用户是否已经注册
		String sql = "select * from user where username = '" + username + "'";
		
		//4.将查询的结果返回过来
		ResultSet executeQuery = stat.executeQuery(sql);	
		if (executeQuery.next()) {
			user.setUsername(executeQuery.getString("username")); // in quota is the artribute name
			user.setAddress(executeQuery.getString("address"));
			user.setEmail(executeQuery.getString("email"));
			user.setSex(executeQuery.getString("sex"));
			user.setTel(executeQuery.getString("tel"));
			user.setId(executeQuery.getString("ID"));
		} else {
		}
		return user;
	}

}

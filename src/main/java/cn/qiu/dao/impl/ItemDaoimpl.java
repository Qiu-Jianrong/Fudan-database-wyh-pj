package cn.qiu.dao.impl;

import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import cn.qiu.dao.ClientDao;
import cn.qiu.dao.ItemDao;
import cn.qiu.domain.*;

/**
 * Servlet implementation class ClientDao
 */
// @WebServlet("/ClientDao")
public class ItemDaoimpl implements ItemDao {
	private static final long serialVersionUID = 1L;

	@Override
	public List<Book> Search_by_ID(String key, int flag) throws Exception {
		// TODO Auto-generated method stub
		
		List<Book> li = new ArrayList<Book>();
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，查看用户是否已经注册
		String sql;	
		if(flag == 0)
			sql = "select * from book where id = '" + key + "'";
		else
			sql = "select * from book where id like '" + key + "%'";
		// String sql = "select * from user_val where name = '" + username + "'";		
		//4.将查询的结果返回过来
		ResultSet executeQuery = stat.executeQuery(sql);	
		while(executeQuery.next()) {
			// 每一次都要new, 否则将会改动已添加的元素！
			Book book = new Book();		
			// item.setid(executeQuery.getString("id")); // in quota is the artribute name
			// item.setimg(executeQuery.getString("img"));	
			book.setid(executeQuery.getString("id"));
			book.setnewness(executeQuery.getString("newness")); // in quota is the artribute name
			book.setnumber(Integer.parseInt(executeQuery.getString("number")));	
			book.setprice(Float.parseFloat(executeQuery.getString("price")));
			li.add(book);
			// System.out.print(item);
		}
		return li;
	}

	@Override
	public List<Book_inf> get_detail_profile(List<Book> books) throws Exception {
		// TODO Auto-generated method stub
		List<Book_inf> book_inf = new ArrayList<Book_inf>();
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，遍历查询信息。
		String sql;
		for(int i = 0; i < books.size();++i) {
			sql = "select * from book_inf where id = '" + books.get(i).getid() + "'";
			ResultSet executeQuery = stat.executeQuery(sql);
			executeQuery.next();
			// 每一次都要new, 否则将会改动已添加的元素！
			Book_inf item = new Book_inf();
			item.setid(executeQuery.getString("id")); // in quota is the artribute name
			item.setauthor(executeQuery.getString("author"));
			item.setpublisher(executeQuery.getString("publisher"));
			item.settitle(executeQuery.getString("title"));
			item.setcategory(Integer.parseInt(executeQuery.getString("category")));
			book_inf.add(item);
		}
		return book_inf;	
	}
	
	@Override
	public List<Item> get_profile(List<Book> items) throws Exception {
		// TODO Auto-generated method stub
		List<Item> book_pic = new ArrayList<Item>();
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，遍历查询信息。
		String sql;
		for(int i = 0; i < items.size();++i) {
			sql = "select * from item where id = '" + items.get(i).getid() + "'";
			ResultSet executeQuery = stat.executeQuery(sql);
			executeQuery.next();
			// 每一次都要new, 否则将会改动已添加的元素！
			Item item = new Item();
			item.setid(executeQuery.getString("id")); // in quota is the artribute name
			item.setimg(executeQuery.getString("img"));	
			item.set_Class(Integer.parseInt(executeQuery.getString("class")));
			book_pic.add(item);
		}
		return book_pic;		
	}

	@Override
	public List<Book> Search_by_name(String key) throws Exception {
		List<Book> li = new ArrayList<Book>();

		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，查看用户是否已经注册
		String sql = "select * from book_inf natural join book where title like '%" + key + "%'";
		// String sql = "select * from user_val where name = '" + username + "'";		
		//4.将查询的结果返回过来
		ResultSet executeQuery = stat.executeQuery(sql);	
		while(executeQuery.next()) {
			// 每一次都要new, 否则将会改动已添加的元素！
			Book book = new Book();		
			book.setid(executeQuery.getString("id"));
			book.setnewness(executeQuery.getString("newness")); // in quota is the artribute name
			book.setnumber(Integer.parseInt(executeQuery.getString("number")));	
			book.setprice(Float.parseFloat(executeQuery.getString("price")));
			li.add(book);
		}
		return li;
	}

	@Override
	public boolean add_cart(String id, String u_id, String newness) throws Exception {
		// TODO Auto-generated method stub
			
		//1.加载驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		String sql = "select number from book where id='" + id + "'";
		
		//4.将查询的结果返回过来,一定要next()!!!!!!!!!!!!
		ResultSet executeQuery = stat.executeQuery(sql);
		executeQuery.next();
		int num = Integer.parseInt(executeQuery.getString("number"));
		
		// 若无余额，则加购失败
		if(num == 0)
			return false;
		
		//若仍有余额，成功加购,注意用的是update,不是query！！！！！！
		// System.out.print(u_id);
		sql = "select * from cart where u_ID='" + u_id + "' and i_ID='" + id + "'and newness='" + newness + "'";
		executeQuery = stat.executeQuery(sql);
		if(executeQuery.next()) 
			sql = "update cart set number = number + 1 where u_ID='" + u_id + "' and i_ID='" + id + "'and newness='" + newness + "'";
		else
			sql = "insert into cart values('" + u_id + "','"+ id + "',1,'" + newness + "')";
		stat.executeUpdate(sql);
		/* 加购不需要更新库存！
		sql = "update book set number=number-1 where id='" + id + "'";
		stat.executeUpdate(sql);*/
		return true;
	}

	@Override
	public boolean buy_now(String id, String u_id, String newness, int buy_num) throws Exception {
		// TODO Auto-generated method stub
		//1.加载驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		String sql = "select number from book where id='" + id + "'and newness='" + newness + "'";
		
		//4.将查询的结果返回过来,一定要next()!!!!!!!!!!!!
		ResultSet executeQuery = stat.executeQuery(sql);
		executeQuery.next();
		
		int have_num = Integer.parseInt(executeQuery.getString("number"));
		
		// 若无余额，则加购失败
		if(have_num < buy_num)
			return false;
		
		//若余额足够，成功购买,注意用的是update,不是query！！！！！！
		// System.out.print(u_id);
		sql = "select * from orders where u_ID='" + u_id + "' and i_ID='" + id + "'and newness='" + newness + "'";
		executeQuery = stat.executeQuery(sql);
		if(executeQuery.next()) 
			sql = "update orders set number = number + " + buy_num + " where u_ID='" + u_id + "' and i_ID='" + id + "' and newness='" + newness + "'";
		else
			sql = "insert into orders values('" + u_id + "','"+ id + "','2023-5-28','未发货',1,'" + newness + "')" ;
		stat.executeUpdate(sql);
		// 更新库存！
		sql = "update book set number=number-" + buy_num + " where id='" + id + "'";
		stat.executeUpdate(sql);
		return true;
	}
	
	
	@Override
	public List<Orders> select_orders() throws Exception {
		// TODO Auto-generated method stub
		
		List<Orders> li = new ArrayList<Orders>();
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，查看用户是否已经注册
		String 	sql = "select * from orders";

		// String sql = "select * from user_val where name = '" + username + "'";		
		//4.将查询的结果返回过来
		ResultSet executeQuery = stat.executeQuery(sql);	
		while(executeQuery.next()) {
			// 每一次都要new, 否则将会改动已添加的元素！
			Orders order = new Orders();		
			order.seti_ID(executeQuery.getString("i_id")); // in quota is the artribute name
			order.setu_ID(executeQuery.getString("u_id"));
			order.setstate(executeQuery.getString("state"));
			order.setnum(Integer.parseInt(executeQuery.getString("number")));
			order.setget_date(executeQuery.getString("date_get"));
			order.setnewness(executeQuery.getString("newness"));
			li.add(order);
			// System.out.print(order);
		}
		return li;
	}

	@Override
	public List<Book> select_goods() throws Exception {
		List<Book> li = new ArrayList<Book>();
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，查看用户是否已经注册
		String 	sql = "select * from book";

		// String sql = "select * from user_val where name = '" + username + "'";		
		//4.将查询的结果返回过来
		ResultSet executeQuery = stat.executeQuery(sql);	
		while(executeQuery.next()) {
			// 每一次都要new, 否则将会改动已添加的元素！
			Book good = new Book();		
			good.setid(executeQuery.getString("id")); // in quota is the artribute name
			good.setnewness(executeQuery.getString("newness"));
			good.setnumber(Integer.parseInt(executeQuery.getString("number")));
			good.setprice(Float.parseFloat(executeQuery.getString("price")));
			li.add(good);
			// System.out.print(order);
		}
		return li;
	}

	@Override
	public List<Book> get_cart_items(String id) throws Exception {
		// TODO Auto-generated method stub
		List<Book> li = new ArrayList<Book>();
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，查看用户是否已经注册
		String 	sql = "select * from cart join book on (cart.i_id=book.id and cart.newness=book.newness) where u_id='" + id +"'";
	
		//4.将查询的结果返回过来
		ResultSet executeQuery = stat.executeQuery(sql);	
		while(executeQuery.next()) {
			// 每一次都要new, 否则将会改动已添加的元素！
			Book good = new Book();		
			good.setid(executeQuery.getString("id")); // in quota is the artribute name
			good.setnewness(executeQuery.getString("newness"));
			good.setnumber(Integer.parseInt(executeQuery.getString("cart.number")));// 这里是购买的num，不是库存
			good.setprice(Float.parseFloat(executeQuery.getString("price")));
			// System.out.print(good);
			li.add(good);
			
		}
		return li;
	}


	@Override
	public List<User> select_users() throws Exception {
		// TODO Auto-generated method stub
		List<User> li = new ArrayList<User>();
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，查看用户是否已经注册
		String 	sql = "select * from user";

		// String sql = "select * from user_val where name = '" + username + "'";		
		//4.将查询的结果返回过来
		ResultSet executeQuery = stat.executeQuery(sql);	
		while(executeQuery.next()) {
			// 每一次都要new, 否则将会改动已添加的元素！
			User user = new User();		
			user.setId(executeQuery.getString("id")); // in quota is the artribute name
			user.setUsername(executeQuery.getString("username"));
			user.setSex(executeQuery.getString("sex"));
			user.setAddress(executeQuery.getString("address"));
			user.setEmail(executeQuery.getString("email"));
			user.setTel(executeQuery.getString("tel"));
			li.add(user);
			// System.out.print(user);
		}
		return li;
	}
	
	@Override
	public boolean in_good(int in_number, String id, String newness) throws Exception {
		// TODO Auto-generated method stub
		// System.out.print(in_number);
		// System.out.print(id);
		// System.out.print(newness);
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，查看用户是否已经注册
		String sql = "update book set number = number + " + in_number + " where id='" + id + "' and newness='" + newness + "'";
	
		//4.将查询的结果返回过来
		int res = stat.executeUpdate(sql);
		if(res == 0) 
			return false;
		return true;
	}

	@Override
	public boolean set_price(double new_price, String id, String newness) throws Exception {
		// TODO Auto-generated method stub
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，查看用户是否已经注册
		String sql = "update book set price=" + new_price + " where id='" + id + "' and newness='" + newness + "'";
	
		//4.将查询的结果返回过来
		int res = stat.executeUpdate(sql);
		if(res == 0) 
			return false;
		return true;
	}

	@Override
	public boolean delete(String u_id, String i_id, String newness) throws Exception {
		// TODO Auto-generated method stub
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句，查看用户是否已经注册
		String sql = "delete from orders where u_id = '" + u_id + "' and i_id = '" + i_id  + "'and newness='" + newness + "'";
				
		//4.返回成功与否
		int res = stat.executeUpdate(sql);
		if(res == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean send(String u_id, String i_id, String newness) throws Exception {
		// TODO Auto-generated method stub
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
				
		//2.创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore_qiu?characterEncoding=UTF-8&serverTimezone=UTC",
				"root","fDu241530");
				
		//3.使用statement创建一个会话，运行SQL语句
		Statement stat = conn.createStatement();
		//定义SQL语句
		String sql = "update orders set state = '已发货' where u_id = '" + u_id + "' and i_id='" + i_id + "'and newness='" + newness + "'";
				
		//4.返回成功与否
		int res = stat.executeUpdate(sql);
		if(res == 0) {
			return false;
		}
		return true;
	}

}

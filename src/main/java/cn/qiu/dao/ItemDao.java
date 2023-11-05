package cn.qiu.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qiu.domain.*;

/**
 * Servlet implementation class ClientDao
 */
// @WebServlet("/ClientDao")
public interface ItemDao {
	// flag = 0,则精确搜索，否则按照大类搜索
	List<Book> Search_by_ID(String key, int flag) throws Exception;
	List<Book> Search_by_name(String key) throws Exception;
	
	List<Item> get_profile(List<Book> items) throws Exception;
	List<Book_inf> get_detail_profile(List<Book> books) throws Exception;
	
	boolean add_cart(String id, String u_id, String newness) throws Exception;
	boolean buy_now(String id, String u_id, String newness, int number) throws Exception;
	List<Orders> select_orders() throws Exception;
	List<Book> select_goods() throws Exception;
	List<User> select_users() throws Exception;
	List<Book> get_cart_items(String id) throws Exception;
	
	boolean in_good(int in_number, String id, String newness) throws Exception;
	boolean set_price(double new_price, String id, String newness) throws Exception;
	
	boolean delete(String u_id, String i_id, String newness) throws Exception;
	boolean send(String u_id, String i_id, String newness) throws Exception;
}

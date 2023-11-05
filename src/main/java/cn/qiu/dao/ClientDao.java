package cn.qiu.dao;

import java.io.IOException;
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
public interface ClientDao {
	
	
	User_val login(String username, String password, String role) throws Exception;
	boolean register1(User user) throws Exception;
	void register2(User_val user_val) throws Exception;
	
	boolean delete(String username) throws Exception;
	boolean upgrade(String username) throws Exception;
	boolean downgrade(String username) throws Exception;
	
	User get_profile(String username) throws Exception;
	boolean change_profile(User user) throws Exception;

}

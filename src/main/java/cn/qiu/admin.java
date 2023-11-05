package cn.qiu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qiu.dao.*;
import cn.qiu.dao.impl.ClientDaoimpl;
import cn.qiu.domain.*;

/**
 * Servlet implementation class admin
 */
@WebServlet("/admin")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.sendRedirect("admin.jsp");
		// 1.设置编码
		request.setCharacterEncoding("utf-8");
				
		// 2. 获取信息
		String op = request.getParameter("op");
		String username = request.getParameter("username");
		boolean flag = false;
				
		// 3.准备返回给前端的信息
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");		
		
		
		// 4. 操作用户
		ClientDaoimpl user_to_op = new ClientDaoimpl();
		if(op.equals("delete"))
			try {
				flag = user_to_op.delete(username);
				if(flag == true) {
					response.getWriter().write("删除成功!");
					response.getWriter().write("2s后将跳转到管理员面板...");
					response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/admin_panel.jsp");
				}
					
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if(op.equals("upgrade"))
			try {
				flag = user_to_op.upgrade(username);
				if(flag == true) {
					response.getWriter().write("升级成功!");
					response.getWriter().write("2s后将跳转到管理员面板...");
					response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/admin_panel.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				flag = user_to_op.downgrade(username);
				if(flag == true) {
					response.getWriter().write("降级成功!");
					response.getWriter().write("2s后将跳转到管理员面板...");
					response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/admin_panel.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

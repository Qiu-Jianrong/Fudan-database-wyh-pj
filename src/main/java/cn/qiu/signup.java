package cn.qiu;

import java.io.IOException;
import java.util.UUID;

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
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final ClientDao check = new ClientDaoimpl();
	private final ClientDao signin = new ClientDaoimpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置编码
		req.setCharacterEncoding("utf-8");
		try {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String sex = req.getParameter("sex");
			String tel = req.getParameter("tel");
			String address = req.getParameter("address");
			String email = req.getParameter("email");
			String role = "user";// 注册只能注册普通用户
			String id =  UUID.randomUUID().toString();
			boolean isExist = false;// 判断是否存在该用户

			if (!username.equals("") && !password.equals("")) {
				// 随机生成id
				User user = new User(id, username, sex, tel, address, email);
				isExist = check.register1(user);
				// isExist = true;
				if (isExist == true) {
					resp.setContentType("text/html;charset=utf-8");
					resp.getWriter().write("该用户已经注册，请直接登录");
					// resp.getWriter().write("<a href='" + req.getContextPath() + "/client/ClientServlet?op=category'>登录</a>");
				} else {
					User_val user_val = new User_val(username, password, role);
					signin.register2(user_val);
					resp.setContentType("text/html;charset=utf-8");
					resp.getWriter().write("注册成功!");
					resp.getWriter().write("2s后将跳转到首页...");
					resp.setHeader("Refresh", "2;URL=" + req.getContextPath() + "/book_show.jsp");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

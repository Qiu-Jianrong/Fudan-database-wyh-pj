package cn.qiu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qiu.dao.impl.ItemDaoimpl;
import cn.qiu.domain.Orders;
import cn.qiu.domain.User;

/**
 * Servlet implementation class select_users
 */
@WebServlet("/select_users")
public class select_users extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public select_users() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1.设置编码
		request.setCharacterEncoding("utf-8");
		
		// 2. 获取信息

		
		// 3.准备返回给前端的信息
		HttpSession session = request.getSession();//获取session变量
		// String message = null; //定义message变量
		response.setContentType("text/html;charset=utf-8");

		
		// 4. 设置session,返回
		ItemDaoimpl bs = new ItemDaoimpl();
		List<User> users = null;
		
		try {
			users = bs.select_users();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(users.isEmpty())
			session.setAttribute("no_user", "T");
		else
			session.setAttribute("no_user", "F");
		session.setAttribute("users", users);
		response.sendRedirect("admin_panel.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

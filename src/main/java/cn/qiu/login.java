package cn.qiu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qiu.dao.impl.ClientDaoimpl;
import cn.qiu.domain.*;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		String u = request.getParameter("username");
		String p = request.getParameter("password");
		String r = request.getParameter("role");
		
		// 3.准备返回给前端的信息
		HttpSession session = request.getSession();//创建session变量
		String message = null; //定义message变量
		response.setContentType("text/html;charset=utf-8");
		
		// 4. 检验用户
		ClientDaoimpl cl = new ClientDaoimpl();
		User_val check = new User_val();
		User inf = new User();
		
		try {
			check = cl.login(u, p, r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check.getUsername() != null && check.getUsername() != "") {
			// message = "T";
			try {
				inf = cl.get_profile(u);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("message", "T");
			session.setAttribute("user", true);
			session.setAttribute("u_id", inf.getId());
			session.setAttribute("username", u);
			session.setAttribute("address", inf.getAddress());
			session.setAttribute("email", inf.getEmail());
			session.setAttribute("sex", inf.getSex());
			session.setAttribute("tel", inf.getTel());
			session.setAttribute("role", r);
			// response.setContentType("text/html;charset=utf-8");
			response.sendRedirect("book_show.jsp");
		}
		else {
            // message = "F";
            session.setAttribute("message","F");
            // response.setContentType("text/html;charset=utf-8");
            response.sendRedirect("login.jsp");
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

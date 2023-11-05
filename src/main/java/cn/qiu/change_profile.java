package cn.qiu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qiu.dao.impl.ClientDaoimpl;
import cn.qiu.domain.User;
import cn.qiu.domain.User_val;

/**
 * Servlet implementation class change_profile
 */
@WebServlet("/my-account/change-profile")
public class change_profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public change_profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// 1.设置编码
		request.setCharacterEncoding("utf-8");
		
		// 2. 获取信息
		String u = request.getParameter("username");
		// String p = request.getParameter("password");
		String e = request.getParameter("email");
		String a = request.getParameter("address");
		String t = request.getParameter("tel");
		String s = request.getParameter("sex");
		
		// 3.准备返回给前端的信息
		HttpSession session = request.getSession();//获取session变量
		String message = null; //定义message变量
		response.setContentType("text/html;charset=utf-8");
		
		// 4. 更新资料
		ClientDaoimpl cl = new ClientDaoimpl();
		// User_val change_psssword = new User_val();
		User change = new User();
		change.setUsername(u);
		change.setEmail(e);
		change.setAddress(a);
		change.setTel(t);
		change.setSex(s);
		
		boolean success = false;
		try {
			success = cl.change_profile(change);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(success == true) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("修改成功!");
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("修改失败，用户不存在！");
		}
		
		// 5. 修改session
		User inf = new User();
		try {
			inf = cl.get_profile(u);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		session.setAttribute("address", inf.getAddress());
		session.setAttribute("email", inf.getEmail());
		session.setAttribute("sex", inf.getSex());
		session.setAttribute("tel", inf.getTel());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

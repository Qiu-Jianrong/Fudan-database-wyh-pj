package cn.qiu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qiu.dao.impl.ItemDaoimpl;

/**
 * Servlet implementation class set_price
 */
@WebServlet("/set_price")
public class set_price extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public set_price() {
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
		String new_price = request.getParameter("new_price");
		String id = request.getParameter("id");
		String newness = request.getParameter("newness");
		
		// 3.准备返回给前端的信息
		HttpSession session = request.getSession();//获取session变量
		// String message = null; //定义message变量
		response.setContentType("text/html;charset=utf-8");
		
		// 4. 检验用户
		ItemDaoimpl bs = new ItemDaoimpl();
		boolean flag = false;
		
		try {
			flag = bs.set_price(Float.parseFloat(new_price), id, newness);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag)
			session.setAttribute("set_price_success", "T");
		else
			session.setAttribute("set_price_success", "F");
		response.sendRedirect("good_management.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

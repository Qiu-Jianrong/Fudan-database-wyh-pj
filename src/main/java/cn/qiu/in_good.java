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
import cn.qiu.domain.Book;
import cn.qiu.domain.Item;

/**
 * Servlet implementation class in_good
 */
@WebServlet("/in_good")
public class in_good extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public in_good() {
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
		String in_number = request.getParameter("in_number");
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
			flag = bs.in_good(Integer.parseInt(in_number), id, newness);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag)
			session.setAttribute("in_success", "T");
		else
			session.setAttribute("in_success", "F");
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

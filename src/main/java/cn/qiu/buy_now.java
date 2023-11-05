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
 * Servlet implementation class buy_now
 */
@WebServlet("/buy_now")
public class buy_now extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buy_now() {
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
		String id = request.getParameter("id");
		String u_id = request.getParameter("u_id");
		String newness = request.getParameter("newness");
		int number = Integer.parseInt(request.getParameter("number"));
		// String u_id = "b8b9c8a4-6557-4cf7-bc75-04b360ebcfd9";
		// System.out.print(u_id.equals("114"));
		
		
		// 3.准备返回给前端的信息
		HttpSession session = request.getSession();//创建session变量
		response.setContentType("text/html;charset=utf-8");
		
		// 4. 购买逻辑
		ItemDaoimpl buy_now = new ItemDaoimpl();
		boolean flag = false;
		//若未登录，则显然不可
		if(u_id.equals("")) {
			session.setAttribute("buy_now_success", "N");
		}
		else {
			try {
				flag = buy_now.buy_now(id, u_id, newness, number);
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag) {
				session.setAttribute("buy_now_success", "T");
				// response.setContentType("text/html;charset=utf-8");
            
			}
			else
				session.setAttribute("buy_now_success", "F");
		}
		response.sendRedirect("book_show.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

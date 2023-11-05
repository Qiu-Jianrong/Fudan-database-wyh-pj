package cn.qiu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qiu.dao.impl.ClientDaoimpl;
import cn.qiu.dao.impl.ItemDaoimpl;

/**
 * Servlet implementation class good_management
 */
@WebServlet("/order_management")
public class order_management extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public order_management() {
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
		String op = request.getParameter("op");
		String u_id = request.getParameter("u_id");
		String i_id = request.getParameter("i_id");
		String newness = request.getParameter("newness");
		boolean flag = false;
				
		// 3.准备返回给前端的信息
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");		
		
		
		// 4. 操作订单
		ItemDaoimpl good_to_op = new ItemDaoimpl();
		if(op.equals("delete"))
			try {
				flag = good_to_op.delete(u_id, i_id, newness);
				if(flag == true) {
					response.getWriter().write("删除成功!");
					response.getWriter().write("2s后将跳转到订单管理页面...");
					response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/order_management.jsp");
				}
					
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if(op.equals("send"))
			try {
				flag = good_to_op.send(u_id, i_id, newness);
				if(flag == true) {
					response.getWriter().write("发货成功!\n");
					response.getWriter().write("2s后将跳转到订单管理页面...");
					response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/order_management.jsp");
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

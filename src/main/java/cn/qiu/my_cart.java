package cn.qiu;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qiu.dao.impl.ClientDaoimpl;
import cn.qiu.dao.impl.ItemDaoimpl;
import cn.qiu.domain.Book;
import cn.qiu.domain.Book_inf;
import cn.qiu.domain.Item;
import cn.qiu.domain.User;
import cn.qiu.domain.User_val;

/**
 * Servlet implementation class my_cart
 */
@WebServlet("/my_cart")
public class my_cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public my_cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		// 2.获取信息
		String id = request.getParameter("id");
		// System.out.print(id);
		
		// 3.准备返回给前端的信息
		HttpSession session = request.getSession();//创建session变量
		response.setContentType("text/html;charset=utf-8");
		
		// 4. 检验用户
		ItemDaoimpl cl = new ItemDaoimpl();
		List<Book> items = null;
		List<Item> i_inf = null;
		List<Book_inf> i_inf_2 = null;
		
		try {
			items = cl.get_cart_items(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			i_inf = cl.get_profile(items);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			try {
				i_inf_2 = cl.get_detail_profile(items);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		double sum = 0;
		for(int i = 0; i < items.size();++i) {
			sum = sum + items.get(i).getprice();
		}
			
		if(items.isEmpty())
			session.setAttribute("no_item", "T");
		else
			session.setAttribute("no_item", "F");
		// System.out.print(items);
		session.setAttribute("cart_items", items);
		session.setAttribute("cart_items_img", i_inf);
		session.setAttribute("cart_items_name", i_inf_2);
		session.setAttribute("sum", sum);
		response.setContentType("text/html;charset=utf-8");
		response.sendRedirect("my_cart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

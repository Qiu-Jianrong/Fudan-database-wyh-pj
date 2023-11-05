package cn.qiu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import cn.qiu.dao.impl.ClientDaoimpl;
import cn.qiu.dao.impl.ItemDaoimpl;
import cn.qiu.domain.User;
import cn.qiu.domain.User_val;
import cn.qiu.domain.Book;
import cn.qiu.domain.Item;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
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
		String key = request.getParameter("key");
		
		// 3.准备返回给前端的信息
		HttpSession session = request.getSession();//获取session变量
		// String message = null; //定义message变量
		response.setContentType("text/html;charset=utf-8");
		//为保证每次刷新都能重新更新库存
		session.setAttribute("search_key", key);
		
		// 4. 检验用户
		ItemDaoimpl bs = new ItemDaoimpl();
		List<Book> i_search = null;
		List<Item> i_inf = null;
		
		try {
			if(key.charAt(0) == '@') {// 按照id搜索
				// 去除头部id标识符
				key = key.substring(1);
				if (key.charAt(0) == '@') {// 按照id所属的类搜索
					key = key.substring(1);
					i_search = bs.Search_by_ID(key, 1);
				}
				else
					i_search = bs.Search_by_ID(key, 0);
			}
			else
				i_search = bs.Search_by_name(key);
			i_inf = bs.get_profile(i_search);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i_search.isEmpty())
			session.setAttribute("no_match", 1);
		else
			session.setAttribute("no_match", 0);
		session.setAttribute("items", i_inf);
		session.setAttribute("books", i_search);
		response.sendRedirect("book_show.jsp");
		// request.getRequestDispatcher("/book_show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

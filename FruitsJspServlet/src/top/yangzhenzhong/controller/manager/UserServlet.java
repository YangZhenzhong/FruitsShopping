package top.yangzhenzhong.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.yangzhenzhong.bean.User;
import top.yangzhenzhong.biz.UserBiz;
import top.yangzhenzhong.biz.impl.UserBizImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet.admin.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     UserBiz uBiz = new UserBizImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getParameter("action");
		switch (action) {
		case "show":
			show(request,response);
			break;

		default:
			break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> uList = uBiz.getAll();
		request.setAttribute("uList",uList);
		request.getRequestDispatcher("admin/user_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

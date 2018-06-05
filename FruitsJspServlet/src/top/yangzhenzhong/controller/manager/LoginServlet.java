package top.yangzhenzhong.controller.manager;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import top.yangzhenzhong.bean.Sort;
import top.yangzhenzhong.biz.AdminBiz;
import top.yangzhenzhong.biz.SortBiz;
import top.yangzhenzhong.biz.impl.AdminBizImpl;
import top.yangzhenzhong.biz.impl.SortBizImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		AdminBiz biz = new AdminBizImpl();
		Map<String,Object> map = biz.login(username, pwd);
		String flag = (String) map.get("flag");
		HttpSession session = request.getSession();
		if("OK".equals(flag)){
			session.setAttribute("manager",session);
			SortBiz sBiz = new SortBizImpl();
			List<Sort> sList = sBiz.getAll();
			session.setAttribute("sList",sList );
			response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
		}else{
			response.sendRedirect("adminLogin.jsp");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

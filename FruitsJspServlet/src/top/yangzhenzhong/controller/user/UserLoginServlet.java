package top.yangzhenzhong.controller.user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ndktools.javamd5.Mademd5;

import top.yangzhenzhong.bean.User;
import top.yangzhenzhong.biz.UserBiz;
import top.yangzhenzhong.biz.impl.UserBizImpl;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet.qian.do")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserBiz uBiz = new UserBizImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "phoneLogin":
			phoneLogin(request,response);
			break;

		default:
			break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void phoneLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String u_phone=request.getParameter("u_phone");
		Mademd5 md5 = new Mademd5();
		String u_pwd = md5.toMd5(request.getParameter("u_pwd"));
		Map<String,Object> map = uBiz.getByPhone(u_phone,u_pwd);
		String flag = (String) map.get("flag");
		HttpSession session = request.getSession();
		if("OK".equals(flag)){
			
			User u = (User) map.get("user");
			session.setAttribute("user",u);
			response.sendRedirect(request.getContextPath()+"/shell651/index.jsp");
		}else{
			session.setAttribute("message","账号或密码不正确");
			response.sendRedirect(request.getContextPath()+"/shell651/login.jsp");
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

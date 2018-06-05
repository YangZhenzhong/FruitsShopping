package top.yangzhenzhong.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ndktools.javamd5.Mademd5;

import top.yangzhenzhong.bean.User;
import top.yangzhenzhong.biz.UserBiz;
import top.yangzhenzhong.biz.impl.UserBizImpl;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet.qian.do")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserBiz uBiz = new UserBizImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_phone = request.getParameter("u_phone");
		String u_pwdNo = request.getParameter("u_pwd");
		Mademd5 md5 = new Mademd5();
		String u_pwd = md5.toMd5(u_pwdNo);
//		System.out.println(u_phone);
//		System.out.println(u_pwd);
		User u =new User();
		u.setU_phone(u_phone);
		u.setU_pwd(u_pwd);
		int i = uBiz.registU(u);
		if(i>0){
			response.sendRedirect(request.getContextPath()+"/shell651/login.jsp");
		}else{
			request.setAttribute("message","注册失败");
			request.getRequestDispatcher("shell651/reg.jsp").forward(request, response);
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

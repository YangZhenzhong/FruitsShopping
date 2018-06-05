package top.yangzhenzhong.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import top.yangzhenzhong.bean.Order;
import top.yangzhenzhong.biz.OrderBiz;
import top.yangzhenzhong.biz.impl.OrderBizImpl;

/**
 * Servlet implementation class FruitPayServlet
 */
@WebServlet("/FruitPayServlet.qian.do")
public class FruitPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    OrderBiz oBiz = new OrderBizImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FruitPayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch (action) {
		case "yibao":
			yibao(request,response);
			break;
		case "nopay":
			nopay(request,response);
			break;
		default:
			break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void nopay(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int o_id = Integer.parseInt(request.getParameter("o_id"));
		HttpSession session = request.getSession();
		Order order = oBiz.getDetail(o_id);
		session.setAttribute("order", order);
		response.sendRedirect(request.getContextPath()+"/QueRenXiaDan.qian.do?action=success");
	}

	private void yibao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int o_id = Integer.parseInt(request.getParameter("o_id"));
		HttpSession session = request.getSession();
		Order order = oBiz.getDetail(o_id);
		session.setAttribute("order", order);
		response.sendRedirect(request.getContextPath()+"/shell651/orderpay.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

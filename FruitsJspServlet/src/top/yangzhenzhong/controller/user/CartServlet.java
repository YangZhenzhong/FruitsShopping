package top.yangzhenzhong.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import top.yangzhenzhong.bean.Cart;
import top.yangzhenzhong.bean.Fruit;
import top.yangzhenzhong.bean.User;
import top.yangzhenzhong.biz.CartBiz;
import top.yangzhenzhong.biz.impl.CartBizImpl;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet.qian.do")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CartBiz cBiz = new CartBizImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		case "show":
			show(request,response);
			break;
		case "plus":
			plus(request,response);
			break;
		case "reduce":
			reduce(request,response);
			break;
		case "deleteAll":
			deleteAll(request,response);
			break;
		case "addCart":
			addCart(request,response);
			break;
		default:
			break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		User u = (User) session.getAttribute("user");
		int f_id = Integer.parseInt(request.getParameter("f_id"));
		Fruit f = new Fruit();
		f.setF_id(f_id);
		Cart cart = new Cart();
		cart.setU_id(u.getU_id());
		cart.setFruit(f);
		cart.setC_num(1);
		cBiz.addCart(cart);
		show(request,response);
	}

	private void deleteAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session  = request.getSession();
		User u = (User) session.getAttribute("user");
		int u_id = u.getU_id();
		cBiz.deleteAll(u_id);
		ajaxShow(request,response);
	}

	private void reduce(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String c_strId = request.getParameter("c_id");
		int c_id = Integer.parseInt(c_strId);
		cBiz.reduceCartNum(c_id);
		ajaxShow(request,response);
	}

	private void plus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String c_strId = request.getParameter("c_id");
		int c_id = Integer.parseInt(c_strId);
		cBiz.plusCartNum(c_id);
		ajaxShow(request,response);
	}

	private void ajaxShow(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session  = request.getSession();
		User u = (User) session.getAttribute("user");
		List<Cart> cList = cBiz.showCart(u.getU_id());
		int total= 0;
		for(Cart c:cList){
			total=total+c.getFruit().getF_price()*c.getC_num();
//			System.out.println(c);
		}
		List<Object> jsonList = new ArrayList<Object>();
		jsonList.add(cList);
		jsonList.add(total);
		JSONArray json = JSONArray.fromObject(jsonList);
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		User u = (User) session.getAttribute("user");
		List<Cart> cList = cBiz.showCart(u.getU_id());
		int total= 0;
		for(Cart c:cList){
			total=total+c.getFruit().getF_price()*c.getC_num();
//			System.out.println(c);
		}
		request.setAttribute("cList",cList);
		request.setAttribute("total", total);
		request.getRequestDispatcher("shell651/shopcar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}

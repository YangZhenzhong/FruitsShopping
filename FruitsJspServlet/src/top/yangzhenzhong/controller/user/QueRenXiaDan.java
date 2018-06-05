package top.yangzhenzhong.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import top.yangzhenzhong.bean.Cart;
import top.yangzhenzhong.bean.Comment;
import top.yangzhenzhong.bean.Local;
import top.yangzhenzhong.bean.Order;
import top.yangzhenzhong.bean.State;
import top.yangzhenzhong.bean.User;
import top.yangzhenzhong.biz.CartBiz;
import top.yangzhenzhong.biz.LocalBiz;
import top.yangzhenzhong.biz.OrderBiz;
import top.yangzhenzhong.biz.impl.CartBizImpl;
import top.yangzhenzhong.biz.impl.LocalBizImpl;
import top.yangzhenzhong.biz.impl.OrderBizImpl;

/**
 * Servlet implementation class QueRenXiaDan
 */
@WebServlet("/QueRenXiaDan.qian.do")
public class QueRenXiaDan extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CartBiz cBiz = new CartBizImpl();  
    LocalBiz locBiz = new LocalBizImpl();
    OrderBiz oBiz = new OrderBizImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueRenXiaDan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		switch (action) {
		case "show":
			showOrder(request,response);
			break;
		case "addLoc":
			addLoc(request,response);
			break;
		case "queRen":
			jiesuan(request,response);
			break;
		case "showOrderRs":
			showOrderResult(request,response);
			break;
		case "detail":
			detail(request,response);
			break;
		case "quxiao":
			quxiao(request,response);
			break;
		case "success":
			success(request,response);
		default:
			break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void success(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("成功支付");
		HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute("order");
		//成功支付
		int state_id = 2;
		int o_id = order.getO_id();
		//
		Comment comm = new Comment();
		comm.setOrder(order);
		comm.setComm_pointer(1);
		comm.setComm_comment("暂时未评论");
		comm.setComm_flag(0);
		oBiz.successPay(o_id, state_id, comm);
		showOrderResult(request,response);
	}

	private void quxiao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int o_id = Integer.parseInt(request.getParameter("o_id"));
		int state_id = 3;
		try {
			oBiz.quxiao(o_id,state_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		showOrderResult(request,response);
	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int o_id = Integer.parseInt(request.getParameter("o_id"));
		Order o  = oBiz.getDetail(o_id);
		request.setAttribute("order", o);
		request.getRequestDispatcher("shell651/ordercon.jsp").forward(request, response);
		
	}

	private void jiesuan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		try{
			int loc_id =	Integer.parseInt(request.getParameter("loc_id"));
			String[] cidList = request.getParameterValues("c_id");
			int total = Integer.parseInt(request.getParameter("total"));
			List<Integer> cidL = new ArrayList<Integer>();
			for(int i=0;i<cidList.length;i++){
				cidL.add(Integer.parseInt(cidList[i]));
			}
			Order o = new Order();
			Local loc = new Local();
			loc.setLoc_id(loc_id);
			o.setLoc(loc);
			o.setO_date(new Date());
			State state = new State();
			state.setState_id(1);
			o.setState(state);
			o.setTotal(total);
			o.setU_id(u.getU_id());
			oBiz.addOrder(o, cidL);
			showOrderResult(request,response);
		}catch(Exception e){
			session.setAttribute("message", "Are you kidding me?");
			showOrder(request,response);
		}
	}

	private void showOrderResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		Map<Integer,Object> map = oBiz.getUserOrder(u.getU_id());
		@SuppressWarnings("unchecked")
		List<Order> orderLNo = (List<Order>) map.get(1);
		for(Order o :orderLNo){
			System.out.println(o);
		}
		System.out.println("--------");
		@SuppressWarnings("unchecked")
		List<Order> orderLS = (List<Order>) map.get(2);
		for(Order o :orderLS){
			System.out.println(o);
		}
		System.out.println("--------");
		@SuppressWarnings("unchecked")
		List<Order> orderLQ = (List<Order>) map.get(3);
		for(Order o :orderLQ){
			System.out.println(o);
		}
		System.out.println("--------");
		request.setAttribute("orderLNo",orderLNo);
		request.setAttribute("orderLS",orderLS);
		request.setAttribute("orderLQ", orderLQ);
		request.getRequestDispatcher("shell651/myorder.jsp").forward(request, response);
	}

	private void addLoc(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session  = request.getSession();
		User u = (User) session.getAttribute("user");
		int u_id = u.getU_id();
		String loc_name = request.getParameter("loc_name");
		String loc_phone = request.getParameter("loc_phone");
		String local = request.getParameter("local"); 
		Local loc = new Local();
		loc.setLoc_name(loc_name);
		loc.setLocal(local);
		loc.setPhone(loc_phone);
		loc.setU_id(u_id);
		List<Local> locList = locBiz.add(loc);
		JSONArray json = JSONArray.fromObject(locList);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}

	private void showOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		User u = (User) session.getAttribute("user");
		List<Cart> cList = cBiz.showCart(u.getU_id());
		int total= 0;
		for(Cart c:cList){
			total=total+c.getFruit().getF_price()*c.getC_num();
//			System.out.println(c);
		}
		List<Local> locList = locBiz.getAll(u.getU_id());
		request.setAttribute("cList",cList);
		request.setAttribute("locList",locList);
		request.setAttribute("total",total);
		request.getRequestDispatcher("shell651/xiadan.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

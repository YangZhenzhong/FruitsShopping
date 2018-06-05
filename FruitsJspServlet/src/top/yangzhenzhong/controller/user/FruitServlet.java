package top.yangzhenzhong.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import top.yangzhenzhong.bean.Fruit;
import top.yangzhenzhong.bean.Sort;
import top.yangzhenzhong.biz.FruitBiz;
import top.yangzhenzhong.biz.SortBiz;
import top.yangzhenzhong.biz.impl.FruitBizImpl;
import top.yangzhenzhong.biz.impl.SortBizImpl;
import util.RuleEnum;
import util.SelectUtil;

/**
 * Servlet implementation class FruitServlet
 */
@WebServlet(name = "ShowFruitServlet", urlPatterns = { "/ShowFruitServlet.qian.do" })
public class FruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    FruitBiz fBiz = new FruitBizImpl();
    SortBiz sortBiz = new SortBizImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FruitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		switch (action) {
		case "show":
			showAll(request,response);
			break;
		case "detail":
			detail(request,response);
			break;
		case "ajaxShowSortId":
			ajaxShowSortId(request,response);
			break;
		case "ajaxShowPaixu":
			ajaxShowPaixu(request,response);
			break;
		case "ajaxShowSearch":
			ajaxShowSearch(request,response);
			break;
		default:
			break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int f_id = 	Integer.parseInt(request.getParameter("f_id"));
			FruitBiz fBiz = new FruitBizImpl();
			Fruit f  = fBiz.getById(f_id);
			request.setAttribute("f", f);
			request.getRequestDispatcher("shell651/content.jsp").forward(request, response);
			
	}

	private void ajaxShowSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SelectUtil sUtil = new SelectUtil();
		String key  = request.getParameter("key");
		sUtil.setKey(key);
		List<Fruit> fList = fBiz.getAll(sUtil);
		JSONArray json = JSONArray.fromObject(fList);
		 PrintWriter out = response.getWriter();
		 out.print(json);
//		 System.out.println(json);
		 out.flush();
		 out.close();
	}

	private void ajaxShowPaixu(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SelectUtil sUtil = new SelectUtil();
		int s_id = 1;
		try{
		s_id = Integer.parseInt(request.getParameter("s_id"));
		
		}catch(Exception e){}
		
		String colName = request.getParameter("row");
		String rule = request.getParameter("rule");
		if(rule.equals("ASC")){
			sUtil.setRule(RuleEnum.ASC);
		}
		if(rule.equals("DESC")){
			sUtil.setRule(RuleEnum.DESC);
		}
		sUtil.setS_id(s_id);
		sUtil.setColName(colName);
		
		List<Fruit> fList = fBiz.getAll(sUtil);
		JSONArray json = JSONArray.fromObject(fList);
		 PrintWriter out = response.getWriter();
		 out.print(json);
//		 System.out.println(json);
		 out.close();
	}

	private void ajaxShowSortId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SelectUtil sUtil = new SelectUtil();
		int s_id = 1;
		try{
		s_id = Integer.parseInt(request.getParameter("s_id"));
		}catch(Exception e){}
		sUtil.setS_id(s_id);
		List<Fruit> fList = fBiz.getByFruit(sUtil);
		JSONArray json = JSONArray.fromObject(fList);
		 PrintWriter out = response.getWriter();
		 out.print(json);
//		 System.out.println(json);
		 out.close();
	}

	private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SelectUtil sUtil = new SelectUtil();
		List<Sort> sortList = sortBiz.getAll();
		List<Fruit> fList = fBiz.getAll(sUtil);
		request.setAttribute("fList",fList);
		request.setAttribute("sortList",sortList);
		request.getRequestDispatcher("shell651/shop.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

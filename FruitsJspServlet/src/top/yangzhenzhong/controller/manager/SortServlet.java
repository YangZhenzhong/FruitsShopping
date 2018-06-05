package top.yangzhenzhong.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.yangzhenzhong.bean.Sort;
import top.yangzhenzhong.biz.SortBiz;
import top.yangzhenzhong.biz.impl.SortBizImpl;

/**
 * Servlet implementation class SortServlet
 */
@WebServlet("/SortServlet.do")
public class SortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortServlet() {
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
		String action = request.getParameter("action");
		System.out.println(action);
		switch (action) {
		case "show":
			show(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
		case "update":
			update(request,response);
			break;
		case "add":
			add(request,response);
			break;
		default:
			break;
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		SortBiz sBiz = new SortBizImpl();
		Sort s = new Sort();
		String s_name = request.getParameter("s_name");
		System.out.println(s_name+"ffsda");
		s.setS_name(s_name);
		boolean flag = sBiz.add(s);
		if(flag){
			request.setAttribute("message","添加成功");
			show(request,response);
		}else{
			request.setAttribute("message","添加失败");
			try {
				request.getRequestDispatcher("admin/sort_post.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		SortBiz sBiz = new SortBizImpl();
		Sort s = new Sort();
		int s_id = Integer.parseInt(request.getParameter("s_id"));
		String s_name = request.getParameter("s_name");
		s.setS_id(s_id);
		s.setS_name(s_name);
		System.out.println(s);
		boolean flag = sBiz.update(s);
		if(flag){
			request.setAttribute("message","更新成功");
		}else{
			request.setAttribute("message","更新失败");
		}
		show(request,response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		SortBiz sBiz = new SortBizImpl();
		int s_id =Integer.parseInt(request.getParameter("s_id"));
		boolean flag = sBiz.delete(s_id);
		if(flag){
			request.setAttribute("message","删除成功");
		}else{
			request.setAttribute("message","删除失败");
		}
		show(request,response);
		
	}

	private void show(HttpServletRequest request, HttpServletResponse response) {
		SortBiz sBiz = new SortBizImpl();
		List<Sort> sList = sBiz.getAll();
		request.setAttribute("sList",sList);
		try {
			for(Sort s:sList){
				System.out.println(s);
			}
			request.getRequestDispatcher("admin/sort.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

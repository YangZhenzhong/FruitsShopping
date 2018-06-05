package top.yangzhenzhong.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.yangzhenzhong.bean.Comment;
import top.yangzhenzhong.biz.CommentBiz;
import top.yangzhenzhong.biz.impl.CommentBizImpl;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet.admin.do")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CommentBiz commBiz = new CommentBizImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
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
		case "delete":
			delete(request,response);
			break;

		default:
			break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int comm_id =	Integer.parseInt(request.getParameter("comm_id"));
		commBiz.delete(comm_id);
		show(request,response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Comment> commList = commBiz.getAll();
		request.setAttribute("commList",commList);
		request.getRequestDispatcher("admin/comm_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

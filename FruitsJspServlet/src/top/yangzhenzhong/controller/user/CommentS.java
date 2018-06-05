package top.yangzhenzhong.controller.user;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import top.yangzhenzhong.bean.Comment;
import top.yangzhenzhong.bean.User;
import top.yangzhenzhong.biz.CommentBiz;
import top.yangzhenzhong.biz.impl.CommentBizImpl;

/**
 * Servlet implementation class CommentS
 */
@WebServlet("/CommentServlet.qian.do")
public class CommentS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CommentBiz commBiz = new CommentBizImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentS() {
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
		case "showU":
			showUserComm(request,response);
			break;
		case "writeComm":
			writeComm(request,response);
		default:
			break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	private void writeComm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int comm_id = Integer.parseInt(request.getParameter("comm_id"));
		String comm_comment = request.getParameter("comm_comment");
		int comm_flag = Integer.parseInt(request.getParameter("comm_flag"));
		Comment comm = new Comment();
		comm.setComm_comment(comm_comment);
		comm.setComm_flag(comm_flag);
		comm.setComm_id(comm_id);
		commBiz.writeComm(comm);
		showUserComm(request,response);
	}

	private void showUserComm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		Map<Integer,Object> map = commBiz.getUComment(u.getU_id());
		@SuppressWarnings("unchecked")
		List<Comment> noCommL  = (List<Comment>) map.get(1);
		@SuppressWarnings("unchecked")
		List<Comment> yesCommL = (List<Comment>) map.get(2);
		request.setAttribute("noCommL",noCommL);
		request.setAttribute("yesCommL",yesCommL);
		request.getRequestDispatcher("shell651/myComm.jsp").forward(request, response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Comment> commList = commBiz.getAll();
		request.setAttribute("commList",commList);
		request.getRequestDispatcher("shell651/procomment.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

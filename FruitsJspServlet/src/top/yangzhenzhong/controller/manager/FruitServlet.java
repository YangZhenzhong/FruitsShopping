package top.yangzhenzhong.controller.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import net.sf.json.JSONArray;
import top.yangzhenzhong.bean.Fruit;
import top.yangzhenzhong.bean.Sort;
import top.yangzhenzhong.biz.FruitBiz;
import top.yangzhenzhong.biz.impl.FruitBizImpl;
import util.FileNameUtil;

/**
 * Servlet implementation class FruitServlet
 */
@WebServlet("/FruitServlet.admin.do")
@MultipartConfig
public class FruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
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
		String action = request.getParameter("action");
		System.out.println(action);
		switch (action) {
		case "showAjax":
			showAjax(request,response);
			break;
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
		case "detail":
			detail(request,response);
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
		request.getRequestDispatcher("admin/content_update.jsp").forward(request, response);
		
	}

	private void show(HttpServletRequest request, HttpServletResponse response) {
		FruitBiz fBiz = new  FruitBizImpl();
		String pStr = request.getParameter("page");
		int page=1;
		try{
			page=Integer.parseInt(pStr);
		}catch (Exception e) {
		}
		//每页显示几条
		int rows=5;
		//共有多少条数据
		int counts=fBiz.getNum();
		//共有多少页
		int totalP=counts%rows==0?counts/rows:counts/rows+1;
		List<Fruit> fList= fBiz.getPage(page,rows);
		request.setAttribute("fList",fList);
		HttpSession session = request.getSession();
		session.setAttribute("totalP", totalP);
		session.setAttribute("pL", page);
		try {
			request.getRequestDispatcher("admin/content.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		FruitBiz fBiz = new FruitBizImpl();
		String f_tuwen=request.getParameter("f_tuwen");
		
		String f_name = request.getParameter("f_name");
		int f_kucun =Integer.parseInt(request.getParameter("f_kucun"));
		int f_price = Integer.parseInt(request.getParameter("f_price"));
		int f_yuanjia = Integer.parseInt(request.getParameter("f_yuanjia"));
		int s_id =Integer.parseInt(request.getParameter("s_id"));
		String f_guige=request.getParameter("f_guige");
		Sort s = new Sort();
		s.setS_id(s_id);
		String picName = "";
		//接收文件上传来的图片
		Part part = request.getPart("f_pic");
		try{
		String realFileName=FileNameUtil.getRealFileName(part.getHeader("Content-Disposition"));
		String saveFileName=FileNameUtil.getUUIDFileName()+FileNameUtil.getFileType(realFileName);
		String path=request.getServletContext().getRealPath("shell651/images");
		picName="shell651/images/"+saveFileName;
		part.write(path+"/"+saveFileName);
		}catch(Exception e){}
		
		
		
		
		Fruit f = new Fruit(s, f_guige, f_tuwen, f_kucun, f_price, f_yuanjia,picName, f_name);
		fBiz.add(f);
		show(request,response);
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		FruitBiz fBiz = new FruitBizImpl();
		String f_tuwen=request.getParameter("f_tuwen");
		
		String f_name = request.getParameter("f_name");
		int f_kucun =Integer.parseInt(request.getParameter("f_kucun"));
		int f_price = Integer.parseInt(request.getParameter("f_price"));
		int f_yuanjia = Integer.parseInt(request.getParameter("f_yuanjia"));
		int s_id =Integer.parseInt(request.getParameter("s_id"));
		String f_guige=request.getParameter("f_guige");
		Sort s = new Sort();
		s.setS_id(s_id);
		String picName = "";
		//接收文件上传来的图片
		Part part = request.getPart("f_pic");
		try{
		String realFileName=FileNameUtil.getRealFileName(part.getHeader("Content-Disposition"));
		String saveFileName=FileNameUtil.getUUIDFileName()+FileNameUtil.getFileType(realFileName);
		String path=request.getServletContext().getRealPath("shell651/images");
		picName="shell651/images/"+saveFileName;
		part.write(path+"/"+saveFileName);
		}catch(Exception e){
			picName=request.getParameter("f.f_picName");
		}
		int f_id =	Integer.parseInt(request.getParameter("f_id"));
		
		
		
		
		Fruit f = new Fruit( f_id,s, f_guige, f_tuwen, f_kucun, f_price, f_yuanjia,picName, f_name);
		fBiz.update(f);
		show(request,response);
		
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		int f_id = Integer.parseInt(request.getParameter("f_id"));
		FruitBiz fBiz = new FruitBizImpl();
		fBiz.delete(f_id);
		show(request,response);
	}

	private void showAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FruitBiz fBiz = new  FruitBizImpl();
		System.out.println("haha");
		String pStr = request.getParameter("page");
		int page=1;
		try{
			page=Integer.parseInt(pStr);
		}catch (Exception e) {
		}
		//每页显示几条
		int rows=5;
		//共有多少条数据z
		int counts=fBiz.getNum();
		//共有多少页
		int totalP=counts%rows==0?counts/rows:counts/rows+1;
		List<Fruit> fList= fBiz.getPage(page, rows);
		JSONArray fLJson = JSONArray.fromObject(fList);
		PrintWriter out = response.getWriter();
		out.write(fLJson.toString());
		HttpSession session = request.getSession();
		session.setAttribute("totalP", totalP);
		session.setAttribute("pL", page);
		System.out.println(page);
		out.flush();
		out.close();
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

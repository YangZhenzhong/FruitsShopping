package top.yangzhenzhong.controller.manager;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.yangzhenzhong.bean.Order;
import top.yangzhenzhong.bean.QingDan;
import top.yangzhenzhong.biz.OrderBiz;
import top.yangzhenzhong.biz.impl.OrderBizImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet.admin.do")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    OrderBiz oBiz = new OrderBizImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "show":
			show(request,response);
			break;
		case "print":
			printOrder(request,response);
			break;
		default:
			break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void printOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int o_id = Integer.parseInt(request.getParameter("o_id"));
		
		Order order =oBiz.getDetail(o_id);
		String path = request.getServletContext().getRealPath("printOrder");
		File file = new File(path+File.separator+"order---"+order.getO_id()+".txt");
		try {
			System.setOut(new PrintStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("***************************************");
		System.out.println("订单号："+order.getO_id()+"");
		System.out.println("收货人："+order.getLoc().getLoc_name()+"");
		System.out.println("手机号："+order.getLoc().getPhone()+"");
		System.out.println("收获地址："+order.getLoc().getLoc_name());
		System.out.println("商品清单");
		int i =1;
		for(QingDan qd:order.getDetailL()){
			System.out.println(i+"、商品名称："+qd.getFruit().getF_name()+",数量："+qd.getQd_num());
		}
		System.out.println("***************************************");
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
//		 InputStream in = new FileInputStream(path+File.separator+"订单---"+order.getO_id()+".txt");  
//		 PrintWriter out = response.getWriter(); 
	     response.sendRedirect(request.getContextPath()+File.separator+"printOrder"+File.separator+"order---"+order.getO_id()+".txt");    
//	        //写文件  
//	        int b;  
//	        while((b=in.read())!= -1)  
//	        {  
//	            out.print(b);  
//	        }  
//	        out.print("<a href='"+request.getContextPath()+File.separator+"printOrder"+File.separator+"订单---"+order.getO_id()+".txt'>下载</a>");
//	        in.close();  
//	        out.close();  
	        
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> oList= oBiz.getAll();
		request.setAttribute("oList", oList);
		request.getRequestDispatcher("admin/order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}

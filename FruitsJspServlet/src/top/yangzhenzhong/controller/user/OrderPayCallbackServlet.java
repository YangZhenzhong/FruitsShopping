package top.yangzhenzhong.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.PaymentUtil;


@WebServlet("/orderpaycallback.do")
public class OrderPayCallbackServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public OrderPayCallbackServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hmac=request.getParameter("hmac") ; // 支付网关发来的加密验证码
		String p1_MerId=request.getParameter("p1_MerId") ; // 商户编号
		String r0_Cmd=request.getParameter("r0_Cmd"); // 业务类型
		String r1_Code=request.getParameter("r1_Code"); // 支付结果
		String r2_TrxId=request.getParameter("r2_TrxId"); // 易宝支付交易流水号
		String r3_Amt=request.getParameter("r3_Amt"); // 支付金额
		String r4_Cur=request.getParameter("r4_Cur") ; // 交易币种
		String r5_Pid=request.getParameter("r5_Pid"); // 商品名称
		String r6_Order=request.getParameter("r6_Order"); // 商户订单号
		String r7_Uid=request.getParameter("r7_Uid"); // 易宝支付会员ID
		String r8_MP=request.getParameter("r8_MP"); // 商户扩展信息
		String r9_BType=request.getParameter("r9_BType") ;// 交易结果返回类型
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";// 密钥
		System.out.println(hmac + p1_MerId + r0_Cmd + r1_Code + r2_TrxId
				+ r3_Amt + r4_Cur + r5_Pid + r6_Order + r7_Uid + r8_MP
				+ r9_BType + keyValue);
		boolean bool = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
				r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
				r8_MP, r9_BType, keyValue);
		if (bool) {
			//支付成功,进行支付成功之后对数据库的操作
			System.out.println(r6_Order);
			System.out.println("??????");
			//QueRenXiaDan.qian.do?action=success
			response.sendRedirect(request.getContextPath()+"/adminLogin.jsp");
		} else {
			//支付失败
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

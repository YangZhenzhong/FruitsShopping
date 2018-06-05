package top.yangzhenzhong.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.PaymentUtil;
@WebServlet("/orderpay.do")
public class OrderPayServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public OrderPayServlet() {
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
		StringBuffer s=new StringBuffer();
		String ordersId=request.getParameter("ordersId");//订单编号
		System.out.println(ordersId);
		String pd_FrpId=request.getParameter("pd_FrpId");//银行代码
		
		// 测试商户：商户编号
				String p1_MerId = "10001126856";
		// 测试商户：密钥
				String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
				// 测试商户：商户接收支付成功数据的地址，这个是要手工改的，支付成功后的处理action
				String p8_Url = "http://120.79.85.207:8080/FruitsJspServlet/orderpaycallback.do";
				// 获取订单号
				String p2_Order = ordersId;
				// 获取支付金额
				String p3_Amt = "0.01";// 测试写死
				// 获取用户所选择的银行
				String p0_Cmd = "Buy"; // 业务类型。Buy为在线支付
				String p4_Cur = "CNY"; // 交易币种。CNY为人民币
				String p7_Pdesc = ""; // 商品描述
				String p6_Pcat = ""; // 商品种类
				String p5_Pid = ""; // 商品ID
				String p9_SAF = "0"; // 送货地址。0为不需要，1为需要
				String pa_MP = ""; // 商户扩展信息
				String pr_NeedResponse = "0"; // 应答机制
				// 秘钥
				String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
						p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
						pd_FrpId, pr_NeedResponse, keyValue);// hmac
				s = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");

				s.append("p0_Cmd=").append(p0_Cmd).append("&");
				s.append("p1_MerId=").append(p1_MerId).append("&");
				s.append("p2_Order=").append(p2_Order).append("&");
				s.append("p3_Amt=").append(p3_Amt).append("&");
				s.append("p4_Cur=").append(p4_Cur).append("&");
				s.append("p5_Pid=").append(p5_Pid).append("&");
				s.append("p6_Pcat=").append(p6_Pcat).append("&");
				s.append("p7_Pdesc=").append(p7_Pdesc).append("&");
				s.append("p8_Url=").append(p8_Url).append("&");
				s.append("p9_SAF=").append(p9_SAF).append("&");
				s.append("pa_MP=").append(pa_MP).append("&");
				s.append("pd_FrpId=").append(pd_FrpId).append("&");
				s.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
				s.append("hmac=").append(hmac);
				System.out.println(s.toString());
				response.sendRedirect(s.toString());
				
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

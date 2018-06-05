package top.yangzhenzhong.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class UserAccessFilter
 */
@WebFilter("/UserAccessFilter")
public class UserAccessFilter implements Filter {
	List<String> list = new ArrayList<String>();
    /**
     * Default constructor. 
     */
    public UserAccessFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 强制servletRequest,servletResponse的转换
				HttpServletRequest req = (HttpServletRequest) request;
				HttpServletResponse res = (HttpServletResponse) response;
				// 取得请求路径:/XiaoMi_0516/productdetail.jsp
				String uri = req.getRequestURI();
				// 得到productdetail.jsp
				uri = uri.replace("/FruitsJspServlet/", "");

				// 登录成功后一定会在session里放用户信息，
				HttpSession session = req.getSession();
				if (session.getAttribute("user") == null) {// 没有登录
					if (list.contains(uri)) {
						res.sendRedirect(req.getContextPath() + "/shell651/login.jsp");
						return;
					}
				}
				
				chain.doFilter(req, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		list.add("CartServlet.qian.do");
	}

}

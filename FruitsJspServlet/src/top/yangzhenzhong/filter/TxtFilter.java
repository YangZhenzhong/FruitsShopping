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
 * Servlet Filter implementation class TxtFilter
 */
@WebFilter("/TxtFilter")
public class TxtFilter implements Filter {
	List<String> list = new ArrayList<String>();
    /**
     * Default constructor. 
     */
    public TxtFilter() {
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
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 取得请求路径:/XiaoMi_0516/productdetail.jsp
		String uri = req.getRequestURI();
		// 得到productdetail.jsp
		 String houzhui = uri.substring(uri.lastIndexOf(".") + 1);

		// 登录成功后一定会在session里放用户信息，
		if(list.contains(houzhui)){
			response.setContentType("text/plain;charset=UTF-8");
		}
		
		chain.doFilter(req, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		list.add("txt");
	}

}

package accounts;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		if (session != null) {
			// TODO Think about something else?
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("/TMS/dashboard.html");
			return;
		}
		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

}

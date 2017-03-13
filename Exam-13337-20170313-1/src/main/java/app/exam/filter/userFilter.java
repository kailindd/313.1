package app.exam.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/userFilter")
public class userFilter implements Filter {

   
    public userFilter() {
      
    }

	
	public void destroy() {
		
	}


	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest   request= (HttpServletRequest) req;
		HttpServletResponse  response= (HttpServletResponse) res;
		
		Object user= request.getSession().getAttribute("user");
		if(user==null){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}

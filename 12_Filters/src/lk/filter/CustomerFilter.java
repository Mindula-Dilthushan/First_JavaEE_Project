package lk.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/customer")
public class CustomerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Customer Filter Initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // HttpServletResponse http= (HttpServletResponse) servletResponse;
        // http.sendRedirect("index.jsp");

        System.out.println("Customer Do Filter Called");
        servletRequest.setAttribute("x", "Institute");// add  some new information to request object

        filterChain.doFilter(servletRequest, servletResponse);//forward request to servlet with request and response object

        //can modify response object if we want
        servletResponse.setContentType("application/json"); // add a response content type before sending the response

    }

    @Override
    public void destroy() {
        System.out.println("Customer Filter Destroyed");
    }
}

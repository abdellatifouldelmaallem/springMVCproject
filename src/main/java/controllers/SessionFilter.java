package controllers;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin/*"})
public class SessionFilter extends HttpFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter INIT");
    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
       // String loginURI = request.getContextPath() + "/";

        boolean loggedIn = session != null && session.getAttribute("email") != null;
        if(loggedIn){
            chain.doFilter(request, response);
        }else {
            response.getWriter().write("404 Error Sorry this page NOT FOUND");
            response.setStatus(HttpServletResponse.SC_OK);


        }
    }
}

package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static helper.Sessions.*;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/handleliste")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        if (isLoggedIn(httpRequest)) {
            chain.doFilter(request, response);
            return;
        }
        HttpSession session = getNewSession(httpRequest);

        session.setAttribute("message", "Du må være logget inn for å bruke handlelisten");
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendRedirect("login");
    }
}

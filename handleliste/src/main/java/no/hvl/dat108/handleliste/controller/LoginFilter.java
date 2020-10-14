package no.hvl.dat108.handleliste.controller;

import no.hvl.dat108.handleliste.Handleliste.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static no.hvl.dat108.handleliste.helper.Sessions.getNewSession;
import static no.hvl.dat108.handleliste.helper.Sessions.isLoggedIn;

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

        session.setAttribute("message", Loc.NOT_LOGGED_IN);
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendRedirect(UrlPattern.LOGIN);
    }
}

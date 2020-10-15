package no.hvl.dat108.handleliste.controller;

import no.hvl.dat108.handleliste.Handleliste.Loc;
import no.hvl.dat108.handleliste.Handleliste.UrlPattern;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static no.hvl.dat108.handleliste.helper.Sessions.isLoggedIn;
import static no.hvl.dat108.handleliste.helper.Sessions.sessionExpired;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/handleliste")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        String message;

        if (sessionExpired(request)) {
            message = Loc.SESSION_EXPIRED;
        } else if (!isLoggedIn(session)) {
            message = Loc.NOT_LOGGED_IN;
        } else {
            chain.doFilter(req, resp);
            return;
        }
        if (session == null) session = request.getSession(true);
        session.setAttribute("message", message);
        response.sendRedirect(UrlPattern.LOGIN);
    }
}

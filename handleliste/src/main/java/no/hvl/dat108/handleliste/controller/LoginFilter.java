package no.hvl.dat108.handleliste.controller;

import no.hvl.dat108.handleliste.Handleliste;
import no.hvl.dat108.handleliste.Handleliste.UrlPattern;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/handleliste")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        String message;

        if (request.getRequestedSessionId() != null && !request.isRequestedSessionIdValid()) {
            message = "Utløpt sesjon, vennligst logg inn på nytt";
        } else if (session == null || session.getAttribute("user") == null) {
            message = Handleliste.Loc.NOT_LOGGED_IN;
        } else {
            chain.doFilter(req, resp);
            return;
        }
        if (session == null) session = request.getSession(true);
        session.setAttribute("message", message);
        response.sendRedirect(UrlPattern.LOGIN);
    }
}

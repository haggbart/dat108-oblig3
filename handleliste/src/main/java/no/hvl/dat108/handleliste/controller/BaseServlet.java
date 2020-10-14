package no.hvl.dat108.handleliste.controller;

import no.hvl.dat108.handleliste.helper.Sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        if (Sessions.initialized) return;
        Sessions.TIMEOUT_SECONDS = Integer.parseInt(getServletContext().getInitParameter("sessionTimeoutSeconds"));
    }
}

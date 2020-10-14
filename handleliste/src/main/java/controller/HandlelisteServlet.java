package controller;


import helper.Handleliste.*;
import service.HandlelisteService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HandlelisteServlet", urlPatterns = "/handleliste")
public class HandlelisteServlet extends HttpServlet {

    @EJB
    private HandlelisteService handlelisteService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String beskrivelse = request.getParameter("beskrivelse");
        if (beskrivelse != null) {
            handlelisteService.addItem(beskrivelse);
            response.sendRedirect(UrlPattern.HANDLELISTE);
            return;
        }

        String itemId = request.getParameter("item");
        if (itemId != null) {
            handlelisteService.deleteItem(itemId);
        }
        response.sendRedirect(UrlPattern.HANDLELISTE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("handleliste", handlelisteService.getItems());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/handleliste.jsp");
        requestDispatcher.forward(request, response);
    }
}

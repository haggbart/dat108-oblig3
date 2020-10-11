package controller;


import model.Item;
import service.HandlelisteService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HandlelisteServlet", urlPatterns = "/handleliste")
public class HandlelisteServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HandlelisteService handlelisteService = new HandlelisteService(request, response);

        String beskrivelse = request.getParameter("beskrivelse");
        if (beskrivelse != null) {
            handlelisteService.addItem(beskrivelse);
            return;
        }

        String itemId = request.getParameter("item");
        if (itemId != null) {
            handlelisteService.deleteItem(itemId);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HandlelisteService handlelisteService = new HandlelisteService(request, response);
        handlelisteService.getItems();
    }
}

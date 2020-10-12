package controller;


import dao.ItemDao;
import service.HandlelisteService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HandlelisteServlet", urlPatterns = "/handleliste")
public class HandlelisteServlet extends HttpServlet {

    @EJB
    private ItemDao itemDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HandlelisteService handlelisteService = new HandlelisteService(itemDao, request, response);

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

//        response.setContentType("text/plain");
//        PrintWriter out = response.getWriter();

//        List<Item> handleliste = itemDao.getAll();
//        handleliste.forEach(out::println);
//
//        List<Item> handleliste = itemDao.getAll();
//        handleliste.forEach(System.out::println);

        HandlelisteService handlelisteService = new HandlelisteService(itemDao, request, response);
        handlelisteService.getItems();
    }
}

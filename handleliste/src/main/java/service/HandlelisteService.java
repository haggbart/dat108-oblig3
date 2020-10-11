package service;

import dao.ItemDao;
import model.Item;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HandlelisteService {

    private final ItemDao itemDao;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public HandlelisteService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        // ny entitymanager for hver request
        itemDao = new ItemDao();
    }

    public void addItem(String beskrivelse) throws IOException {


        beskrivelse = StringEscapeUtils.escapeHtml4(beskrivelse).strip();
        if (beskrivelse.isEmpty() || beskrivelse.length() >= 30) {
            response.sendRedirect("handleliste");
            return;
        }

        Item item = new Item(beskrivelse);
        itemDao.add(item);
        response.sendRedirect("handleliste");
    }

    public void deleteItem(String itemId) throws IOException {
        int id = Integer.parseInt(itemId);
        Item item = itemDao.get(id);
        if (item != null)
            itemDao.delete(item);
        response.sendRedirect("handleliste");
    }

    public void getItems() throws ServletException, IOException {

        List<Item> handleliste = itemDao.getAll();
        request.setAttribute("handleliste", handleliste);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/handleliste.jsp");
        requestDispatcher.forward(request, response);
    }
}

package service;

import dao.ItemDao;
import model.Item;
import org.apache.commons.text.StringEscapeUtils;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Stateless
public class HandlelisteService {

    @EJB
    private ItemDao itemDao;

    public HandlelisteService() {}

    public void addItem(HttpServletResponse response, String beskrivelse) throws IOException {

        beskrivelse = StringEscapeUtils.escapeHtml4(beskrivelse).strip();
        if (beskrivelse.isEmpty() || beskrivelse.length() >= 30) {
            response.sendRedirect("handleliste");
            return;
        }

        Item item = new Item(beskrivelse);
        itemDao.add(item);
        response.sendRedirect("handleliste");
    }

    public void deleteItem(HttpServletResponse response, String itemId) throws IOException {
        int id = Integer.parseInt(itemId);
        itemDao.delete(id);
        response.sendRedirect("handleliste");
    }

    public void getItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Item> handleliste = itemDao.getAll();
        request.setAttribute("handleliste", handleliste);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/handleliste.jsp");
        requestDispatcher.forward(request, response);
    }
}

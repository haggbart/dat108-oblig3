package service;

import dao.ItemDao;
import model.Item;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

import static helper.Utils.tryParse;
import static org.apache.commons.text.StringEscapeUtils.escapeHtml4;

@Stateless
public class HandlelisteService {

    @EJB
    private ItemDao itemDao;

    public void addItem(String beskrivelse) {
        beskrivelse = escapeHtml4(beskrivelse).strip();
        if (beskrivelse.isEmpty() || beskrivelse.length() >= 30) {
            return;
        }
        Item item = new Item(beskrivelse);
        itemDao.save(item);
    }

    public void deleteItem(String itemId) {
        int id = tryParse(itemId);
        if (id == -1) return;

        Item item = itemDao.get(id);
        if (item != null)
            itemDao.delete(item);
    }

    public List<Item> getItems() {
        return itemDao.getAll();
    }
}

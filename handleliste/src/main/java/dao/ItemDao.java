package dao;

import model.Item;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ItemDao {

    @PersistenceContext(name = "studentPU")
    private EntityManager em;

    public Item get(int id) {
        return em.find(Item.class, id);
    }

    public List<Item> getAll() {
        return em.createNamedQuery("Item.getAll", Item.class).getResultList();
    }

    public void add(Item item) {
        em.persist(item);
    }

    public void delete(Item item) {
        em.remove(item);
    }
}

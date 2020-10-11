package dao;

import model.Item;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class ItemDao implements Dao<Item> {

    private final EntityManager em = emf.createEntityManager();

    @Override
    public Item get(int id) {
        return Optional.ofNullable(em.find(Item.class, id)).orElse(null);
    }

    @Override
    public List<Item> getAll() {
        return em.createNamedQuery("Item.getAll", Item.class).getResultList();
    }

    @Override
    public void add(Item item) {
       executeInsideTransaction(em, em -> em.persist(item));
    }

    public void delete(Item item) {
        executeInsideTransaction(em, em -> em.remove(item));
    }
}

package no.hvl.dat108.handleliste.dao;


import no.hvl.dat108.handleliste.model.Item;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ItemDaoImpl implements ItemDao {

    @PersistenceContext
    private EntityManager em;

    public Item get(int id) {
        return em.find(Item.class, id);
    }

    public List<Item> getAll() {
        return em.createNamedQuery("Item.getAll", Item.class).getResultList();
    }

    public void save(Item item) {
        em.persist(item);
    }

    public void delete(Item item) {
        em.remove(item);
    }
}

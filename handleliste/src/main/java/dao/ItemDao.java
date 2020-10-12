package dao;

import model.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.function.Consumer;

public class ItemDao {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("handleliste");
    private EntityManager em;

    public Item get(int id) {
        em = emf.createEntityManager();
        try {
            return em.find(Item.class, id);

        } finally {
            em.close();
        }
    }

    public List<Item> getAll() {
        em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Item.getAll", Item.class).getResultList();

        } finally {
            em.close();
        }
    }

    public void add(Item item) {
        executeInsideTransaction(em -> em.persist(item));
    }

    public void delete(int id) {
        executeInsideTransaction(em -> {
            Item item = em.find(Item.class, id);
            if (item == null) return;
            em.remove(item);
        });
    }

    public void executeInsideTransaction(Consumer<EntityManager> action) {
        em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}

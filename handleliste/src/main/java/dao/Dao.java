package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.function.Consumer;

public interface Dao<T> {

    // all fields defined in an Interface are implicitly static and final
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("handleliste");

    T get(int id);

    List<T> getAll();

    void add(T t);

    void delete (T t);

    default void executeInsideTransaction(EntityManager em, Consumer<EntityManager> action) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}

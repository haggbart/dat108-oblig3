import model.Item;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DatabaseTest {



    @Test
    void database() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("handleliste");

        EntityManager em = emf.createEntityManager();




        try {
            List<Item> handleliste = em.createQuery("SELECT i FROM Item i", Item.class).getResultList();

            for (Item item : handleliste) {
                System.out.println(item);
            }
        } finally {
            em.close();
        }
    }
}

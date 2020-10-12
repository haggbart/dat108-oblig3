package dao;

import model.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemDaoTest {

    ItemDao itemDao = new ItemDao();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void get() {
        Item item = itemDao.get(1);
        System.out.println(item);
        assertNotNull(item);
    }

    @Test
    void getAll() {
        List<Item> handleliste = itemDao.getAll();
        assertNotNull(handleliste);
        handleliste.forEach(System.out::println);
    }

    @Test
    void add() {
        Item item = new Item("Sukker");
        itemDao.add(item);
        System.out.println(item);
        System.out.println(item.getId());
    }

    @Test
    void delete() {
        Item item = itemDao.get(12);
        assertNotNull(item);
        itemDao.delete(12);

        item = itemDao.get(0);
        assertNull(item);
    }
}

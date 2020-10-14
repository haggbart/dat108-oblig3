package dao;

import model.Item;

import java.util.List;

public interface ItemDao {

    Item get(int id);

    List<Item> getAll();

    void save(Item item);

    void delete(Item item);
}

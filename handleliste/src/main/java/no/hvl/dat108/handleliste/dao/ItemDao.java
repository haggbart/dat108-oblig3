package no.hvl.dat108.handleliste.dao;


import no.hvl.dat108.handleliste.model.Item;

import java.util.List;

public interface ItemDao {

    Item get(int id);

    List<Item> getAll();

    void save(Item item);

    void delete(Item item);
}

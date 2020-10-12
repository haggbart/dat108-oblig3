package model;

import javax.persistence.*;

@Entity
@Table(schema = "dat108oblig3", name = "item")
@NamedQuery(name = "Item.getAll", query = "select i from Item i")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String beskrivelse;

    public Item() {}

    public Item(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return beskrivelse;
    }
}

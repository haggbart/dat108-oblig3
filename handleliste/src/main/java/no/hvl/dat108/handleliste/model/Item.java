package no.hvl.dat108.handleliste.model;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Item.getAll", query = "select i from Item i order by i.id")
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

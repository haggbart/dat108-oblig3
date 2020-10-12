package model;

import javax.persistence.*;

@Entity
@Table(name = "item", schema = "dat108oblig3", catalog = "postgres")
public class ItemEntity {
    private int id;
    private String beskrivelse;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "beskrivelse")
    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemEntity that = (ItemEntity) o;

        if (id != that.id) return false;
        if (beskrivelse != null ? !beskrivelse.equals(that.beskrivelse) : that.beskrivelse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (beskrivelse != null ? beskrivelse.hashCode() : 0);
        return result;
    }
}

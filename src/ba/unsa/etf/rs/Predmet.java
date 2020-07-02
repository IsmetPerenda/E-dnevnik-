package ba.unsa.etf.rs;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Predmet {
    SimpleIntegerProperty id;
    SimpleStringProperty naziv;
    SimpleObjectProperty<Profesor> profesorId;

    public Predmet(int id, String naziv, Profesor profesorId) {
        this.id = new SimpleIntegerProperty(id);
        this.naziv = new SimpleStringProperty(naziv);
        this.profesorId = new SimpleObjectProperty<Profesor>(profesorId);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNaziv() {
        return naziv.get();
    }

    public SimpleStringProperty nazivProperty() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }

    public Profesor getProfesorId() {
        return profesorId.get();
    }

    public SimpleObjectProperty<Profesor> profesorIdProperty() {
        return profesorId;
    }

    public void setProfesorId(Profesor profesorId) {
        this.profesorId.set(profesorId);
    }
}

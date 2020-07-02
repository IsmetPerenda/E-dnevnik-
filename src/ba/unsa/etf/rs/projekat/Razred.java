package ba.unsa.etf.rs.projekat;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Razred {

    SimpleIntegerProperty id,brojUcenika;
    SimpleStringProperty naziv;

    public Razred(int id, int brojUcenika, String naziv) {
        this.id = new SimpleIntegerProperty(id);
        this.brojUcenika = new SimpleIntegerProperty(brojUcenika);
        this.naziv = new SimpleStringProperty(naziv);
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

    public int getBrojUcenika() {
        return brojUcenika.get();
    }

    public SimpleIntegerProperty brojUcenikaProperty() {
        return brojUcenika;
    }

    public void setBrojUcenika(int brojUcenika) {
        this.brojUcenika.set(brojUcenika);
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
}

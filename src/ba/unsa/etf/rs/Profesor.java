package ba.unsa.etf.rs;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Profesor {

    SimpleIntegerProperty id;
    SimpleStringProperty ime,prezime,email,lozinka;
    SimpleObjectProperty<LocalDate> datumRodjenja,datumZaposlenja;

    public Profesor(int id, String ime, String prezime, String email, String lozinka,LocalDate datumRodjenja, LocalDate datumZaposlenja) {
        this.id = new SimpleIntegerProperty(id);
        this.ime = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.email = new SimpleStringProperty(email);
        this.lozinka = new SimpleStringProperty(lozinka);
        this.datumRodjenja = new SimpleObjectProperty<LocalDate>(datumRodjenja);
        this.datumZaposlenja = new SimpleObjectProperty<LocalDate>(datumZaposlenja);
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

    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getLozinka() {
        return lozinka.get();
    }

    public SimpleStringProperty lozinkaProperty() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka.set(lozinka);
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja.get();
    }

    public SimpleObjectProperty<LocalDate> datumRodjenjaProperty() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja.set(datumRodjenja);
    }

    public LocalDate getDatumZaposlenja() {
        return datumZaposlenja.get();
    }

    public SimpleObjectProperty<LocalDate> datumZaposlenjaProperty() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(LocalDate datumZaposlenja) {
        this.datumZaposlenja.set(datumZaposlenja);
    }
}

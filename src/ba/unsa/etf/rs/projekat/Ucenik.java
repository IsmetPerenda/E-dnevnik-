package ba.unsa.etf.rs.projekat;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Ucenik {
    SimpleIntegerProperty id;
    SimpleStringProperty ime,prezime,email,adresa,opcina,lozinka;
    SimpleObjectProperty<LocalDate> datumRodjenja;
    SimpleObjectProperty<Razred> razredId;

    public Ucenik(int id, String ime, String prezime, String email, String adresa, String opcina, String lozinka, LocalDate datumRodjenja, Razred razredId) {
        this.id = new SimpleIntegerProperty(id);
        this.ime = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.email = new SimpleStringProperty(email);
        this.adresa = new SimpleStringProperty(adresa);
        this.opcina = new SimpleStringProperty(opcina);
        this.lozinka = new SimpleStringProperty(lozinka);
        this.datumRodjenja = new SimpleObjectProperty<LocalDate>(datumRodjenja);
        this.razredId = new SimpleObjectProperty<Razred>(razredId);

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

    public String getAdresa() {
        return adresa.get();
    }

    public SimpleStringProperty adresaProperty() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa.set(adresa);
    }

    public String getOpcina() {
        return opcina.get();
    }

    public SimpleStringProperty opcinaProperty() {
        return opcina;
    }

    public void setOpcina(String opcina) {
        this.opcina.set(opcina);
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

    public Razred getRazredId() {
        return razredId.get();
    }

    public SimpleObjectProperty<Razred> razredIdProperty() {
        return razredId;
    }

    public void setRazredId(Razred razredId) {
        this.razredId.set(razredId);
    }
}

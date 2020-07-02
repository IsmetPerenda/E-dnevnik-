package ba.unsa.etf.rs.projekat;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Bodovi {
    SimpleIntegerProperty id;
    SimpleDoubleProperty brojBodova;
    SimpleObjectProperty<Ucenik> ucenikId;
    SimpleObjectProperty<Zadace> zadacaId;

    public Bodovi(int id, double brojBodova, Ucenik ucenikId, Zadace zadacaId) {
        this.id = new  SimpleIntegerProperty(id);
        this.brojBodova = new SimpleDoubleProperty(brojBodova);
        this.ucenikId = new  SimpleObjectProperty<Ucenik> (ucenikId);;
        this.zadacaId = new SimpleObjectProperty<Zadace>(zadacaId);
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

    public double getBrojBodova() {
        return brojBodova.get();
    }

    public SimpleDoubleProperty brojBodovaProperty() {
        return brojBodova;
    }

    public void setBrojBodova(double brojBodova) {
        this.brojBodova.set(brojBodova);
    }

    public Ucenik getUcenikId() {
        return ucenikId.get();
    }

    public SimpleObjectProperty<Ucenik> ucenikIdProperty() {
        return ucenikId;
    }

    public void setUcenikId(Ucenik ucenikId) {
        this.ucenikId.set(ucenikId);
    }

    public Zadace getZadacaId() {
        return zadacaId.get();
    }

    public SimpleObjectProperty<Zadace> zadacaIdProperty() {
        return zadacaId;
    }

    public void setZadacaId(Zadace zadacaId) {
        this.zadacaId.set(zadacaId);
    }
}
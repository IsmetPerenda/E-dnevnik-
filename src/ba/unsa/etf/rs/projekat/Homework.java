package ba.unsa.etf.rs.projekat;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Homework {
    SimpleIntegerProperty id;
    SimpleStringProperty nazivZadace;
    SimpleObjectProperty<Predmet> predmetId;

    public Homework(int id, String nazivZadace, Predmet predmetId) {
        this.id = new SimpleIntegerProperty(id);
        this.nazivZadace = new SimpleStringProperty(nazivZadace);
        this.predmetId = new SimpleObjectProperty<Predmet>(predmetId);
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

    public String getNazivZadace() {
        return nazivZadace.get();
    }

    public SimpleStringProperty nazivZadaceProperty() {
        return nazivZadace;
    }

    public void setNazivZadace(String nazivZadace) {
        this.nazivZadace.set(nazivZadace);
    }

    public Predmet getPredmetId() {
        return predmetId.get();
    }

    public SimpleObjectProperty<Predmet> predmetIdProperty() {
        return predmetId;
    }

    public void setPredmetId(Predmet predmetId) {
        this.predmetId.set(predmetId);
    }
}

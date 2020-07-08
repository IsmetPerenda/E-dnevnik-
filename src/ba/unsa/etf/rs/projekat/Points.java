package ba.unsa.etf.rs.projekat;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Points {
    SimpleIntegerProperty id;
    SimpleDoubleProperty brojBodova;
    SimpleObjectProperty<Student> ucenikId;
    SimpleObjectProperty<Homework> zadacaId;

    public Points(int id, double brojBodova, Student studentId, Homework zadacaId) {
        this.id = new  SimpleIntegerProperty(id);
        this.brojBodova = new SimpleDoubleProperty(brojBodova);
        this.ucenikId = new  SimpleObjectProperty<Student> (studentId);;
        this.zadacaId = new SimpleObjectProperty<Homework>(zadacaId);
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

    public Student getUcenikId() {
        return ucenikId.get();
    }

    public SimpleObjectProperty<Student> ucenikIdProperty() {
        return ucenikId;
    }

    public void setUcenikId(Student studentId) {
        this.ucenikId.set(studentId);
    }

    public Homework getZadacaId() {
        return zadacaId.get();
    }

    public SimpleObjectProperty<Homework> zadacaIdProperty() {
        return zadacaId;
    }

    public void setZadacaId(Homework zadacaId) {
        this.zadacaId.set(zadacaId);
    }
}
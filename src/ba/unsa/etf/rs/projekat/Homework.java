package ba.unsa.etf.rs.projekat;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Homework {
    SimpleIntegerProperty id;
    SimpleStringProperty nameOfHomework;
    SimpleObjectProperty<Subject> predmetId;
    SimpleDoubleProperty points;
    SimpleStringProperty state;

    public Homework(int id, String nameOfHomework, Subject predmetId, double points,String state) {
        this.id = new SimpleIntegerProperty(id);
        this.nameOfHomework = new SimpleStringProperty(nameOfHomework);
        this.predmetId = new SimpleObjectProperty<Subject>(predmetId);
        this.points = new SimpleDoubleProperty(points);
        this.state = new SimpleStringProperty(state);
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

    public String getNameOfHomework() {
        return nameOfHomework.get();
    }

    public SimpleStringProperty nameOfHomeworkProperty() {
        return nameOfHomework;
    }

    public void setNameOfHomework(String nameOfHomework) {
        this.nameOfHomework.set(nameOfHomework);
    }

    public Subject getPredmetId() {
        return predmetId.get();
    }

    public SimpleObjectProperty<Subject> predmetIdProperty() {
        return predmetId;
    }

    public void setPredmetId(Subject predmetId) {
        this.predmetId.set(predmetId);
    }

    public double getPoints() {
        return points.get();
    }

    public SimpleDoubleProperty pointsProperty() {
        return points;
    }

    public void setPoints(double points) {
        this.points.set(points);
    }

    public String getState() {
        return state.get();
    }

    public SimpleStringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }
}

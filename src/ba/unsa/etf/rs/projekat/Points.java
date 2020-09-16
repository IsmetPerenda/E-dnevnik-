package ba.unsa.etf.rs.projekat;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Points {
    SimpleIntegerProperty id;
    SimpleDoubleProperty numberOfPoints;
    SimpleObjectProperty<Student> studetntId;
    SimpleObjectProperty<Homework> homeworkId;

    public Points(int id, double numberOfPoints, Student studentId, Homework homeworkId) {
        this.id = new SimpleIntegerProperty(id);
        this.numberOfPoints = new SimpleDoubleProperty(numberOfPoints);
        this.studetntId = new SimpleObjectProperty<Student>(studentId);
        ;
        this.homeworkId = new SimpleObjectProperty<Homework>(homeworkId);
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

    public double getNumberOfPoints() {
        return numberOfPoints.get();
    }

    public SimpleDoubleProperty numberOfPointsProperty() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(double numberOfPoints) {
        this.numberOfPoints.set(numberOfPoints);
    }

    public Student getStudetntId() {
        return studetntId.get();
    }

    public SimpleObjectProperty<Student> studetntIdProperty() {
        return studetntId;
    }

    public void setStudetntId(Student studetntId) {
        this.studetntId.set(studetntId);
    }

    public Homework getHomeworkId() {
        return homeworkId.get();
    }

    public SimpleObjectProperty<Homework> homeworkIdProperty() {
        return homeworkId;
    }

    public void setHomeworkId(Homework homeworkId) {
        this.homeworkId.set(homeworkId);
    }
}
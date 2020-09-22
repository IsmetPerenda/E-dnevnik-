package ba.unsa.etf.rs.projekat;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Schedule {
    SimpleIntegerProperty id;
    SimpleObjectProperty<Student> studentID;
    SimpleObjectProperty<Subject> subjectID;

    public Schedule(int id, Student studentID, Subject subjectID) {
        this.id = new SimpleIntegerProperty(id);
        this.studentID = new SimpleObjectProperty<Student>(studentID);
        this.subjectID = new SimpleObjectProperty<Subject>(subjectID);
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

    public Student getStudentID() {
        return studentID.get();
    }

    public SimpleObjectProperty<Student> studentIDProperty() {
        return studentID;
    }

    public void setStudentID(Student studentID) {
        this.studentID.set(studentID);
    }

    public Subject getSubjectID() {
        return subjectID.get();
    }

    public SimpleObjectProperty<Subject> subjectIDProperty() {
        return subjectID;
    }

    public void setSubjectID(Subject subjectID) {
        this.subjectID.set(subjectID);
    }
}

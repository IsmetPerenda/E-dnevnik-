package ba.unsa.etf.rs.projekat;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;
public class ClassRoom {




    SimpleIntegerProperty id,numberOfStudents,year;
    SimpleStringProperty name;


    public ClassRoom(int id, int numberOfStudents, String name,int year) {
        this.id = new SimpleIntegerProperty(id);
        this.numberOfStudents = new SimpleIntegerProperty(numberOfStudents);
        this.name = new SimpleStringProperty(name);
        this.year = new SimpleIntegerProperty(year);
    }

    @Override
    public String toString() {
        return  getName();
    }

    public int getYear() {
        return year.get();
    }

    public SimpleIntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        yearProperty().set(year);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        idProperty().set(id);
    }

    public int getNumberOfStudents() {
        return numberOfStudents.get();
    }

    public SimpleIntegerProperty numberOfStudentsProperty() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        if(numberOfStudents>30)throw new IllegalArgumentException("Ne možete imati preko 30 ucenika!");
        numberOfStudentsProperty().set(numberOfStudents);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        nameProperty().set(name);
    }


}
package ba.unsa.etf.rs.projekat;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Professor {

    SimpleIntegerProperty id;
    SimpleStringProperty name,surname,email,password;
    SimpleObjectProperty<LocalDate> dateOfBirth,dateOfStartWorking;

    public Professor(int id, String name, String surname, LocalDate dateOfBirth, LocalDate dateOfStartWorking, String email, String password) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.dateOfBirth = new SimpleObjectProperty<LocalDate>(dateOfBirth);
        this.dateOfStartWorking = new SimpleObjectProperty<LocalDate>(dateOfStartWorking);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
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

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
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

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth.get();
    }

    public SimpleObjectProperty<LocalDate> dateOfBirthProperty() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public LocalDate getDateOfStartWorking() {
        return dateOfStartWorking.get();
    }

    public SimpleObjectProperty<LocalDate> dateOfStartWorkingProperty() {
        return dateOfStartWorking;
    }

    public void setDateOfStartWorking(LocalDate dateOfStartWorking) {
        this.dateOfStartWorking.set(dateOfStartWorking);
    }
}

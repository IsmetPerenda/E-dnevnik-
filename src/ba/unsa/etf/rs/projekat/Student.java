package ba.unsa.etf.rs.projekat;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Student {
    SimpleIntegerProperty id;
    SimpleStringProperty name,surname,email,adress, municipality,password;
    SimpleObjectProperty<LocalDate> dateOfBirth;
    SimpleObjectProperty<ClassRoom> classroomId;

    @Override
    public String toString() {
        return getName() + " "+ getSurname();
    }

    public Student(int id, String name, String surname, String adress, LocalDate dateOfBirth, String municipality, String email, String password, ClassRoom classroomId) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.email = new SimpleStringProperty(email);
        this.adress = new SimpleStringProperty(adress);
        this.municipality = new SimpleStringProperty(municipality);
        this.password = new SimpleStringProperty(password);
        this.dateOfBirth = new SimpleObjectProperty<LocalDate>(dateOfBirth);
        this.classroomId = new SimpleObjectProperty<ClassRoom>(classroomId);

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

    public String getAdress() {
        return adress.get();
    }

    public SimpleStringProperty adressProperty() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress.set(adress);
    }

    public String getMunicipality() {
        return municipality.get();
    }

    public SimpleStringProperty municipalityProperty() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality.set(municipality);
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

    public ClassRoom getClassroomId() {
        return classroomId.get();
    }

    public SimpleObjectProperty<ClassRoom> classroomIdProperty() {
        return classroomId;
    }

    public void setClassroomId(ClassRoom classroomId) {
        this.classroomId.set(classroomId);
    }
}

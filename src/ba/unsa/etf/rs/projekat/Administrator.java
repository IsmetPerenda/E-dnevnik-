package ba.unsa.etf.rs.projekat;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Administrator {
    SimpleStringProperty email,password;
    SimpleIntegerProperty id;

    public Administrator(int id,String email, String password) {
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.id = new SimpleIntegerProperty(id);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        emailProperty().set(email);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        passwordProperty().set(password);
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
}
package ba.unsa.etf.rs.projekat;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Subject {



    public class Predmet {
        SimpleIntegerProperty id;
        SimpleStringProperty name;
        SimpleObjectProperty<Professor> profesorId;

        public Predmet(int id, String name, Professor professorId) {
            this.id = new SimpleIntegerProperty(id);
            this.name = new SimpleStringProperty(name);
            this.profesorId = new SimpleObjectProperty<Professor>(professorId);
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

        public String getNaziv() {
            return name.get();
        }

        public SimpleStringProperty nazivProperty() {
            return name;
        }

        public void setNaziv(String naziv) {
            this.name.set(naziv);
        }

        public Professor getProfesorId() {
            return profesorId.get();
        }

        public SimpleObjectProperty<Professor> profesorIdProperty() {
            return profesorId;
        }

        public void setProfesorId(Professor professorId) {
            this.profesorId.set(professorId);
        }
    }

}

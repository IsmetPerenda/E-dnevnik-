package ba.unsa.etf.rs.projekat;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;
public class ClassRoom {




        SimpleIntegerProperty id,numberOfStudents;
        SimpleStringProperty name;

        public ClassRoom(int id, int numberOfStudents, String name) {
            this.id = new SimpleIntegerProperty(id);
            this.numberOfStudents = new SimpleIntegerProperty(numberOfStudents);
            this.name = new SimpleStringProperty(name);
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

        public int getNumberOfStudents() {
            return numberOfStudents.get();
        }

        public SimpleIntegerProperty numberOfStudentsProperty() {
            return numberOfStudents;
        }

        public void setNumberOfStudents(int numberOfStudents) {
            this.numberOfStudents.set(numberOfStudents);
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


}

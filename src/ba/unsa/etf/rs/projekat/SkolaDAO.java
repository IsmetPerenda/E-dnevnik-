package ba.unsa.etf.rs.projekat;

import javafx.collections.ObservableList;

public interface SkolaDAO {
    ObservableList<Student> getStudents();
    ObservableList<Professor> getProfesors();
    ObservableList<Subject> getSubject();
    ObservableList<Homework> getHomework();
    ObservableList<ClassRoom> getClassroom();
    ObservableList<Points> getPoints();
    ObservableList<Administrator>getAdmin();
    void addStudents(Student student);
    void changeStudents(Student student);
    void deleteStudents(Student student);
    void addHomework(Homework homework);
    void changeHomework(Homework homework);
    void deleteHomework(Homework homework);
    void addClassroom(ClassRoom classRoom);
    void changeClassroom(ClassRoom classRoom);
    void deleteClassroom(ClassRoom classRoom);
    void addPoints(Points points);
    void changePoints(Points points);
    void deletePoints(Points points);

    void close();
}

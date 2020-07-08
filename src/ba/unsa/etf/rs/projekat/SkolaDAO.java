package ba.unsa.etf.rs.projekat;

import javafx.collections.ObservableList;

public interface SkolaDAO {
    ObservableList<Student> getStudents();
    ObservableList<Professor> getProfesors();
    ObservableList<Subject> getSubject();
    ObservableList<Homework> getHomework();
    ObservableList<ClassRoom> getClassroom();
    ObservableList<Points> getPoints();
    void addStudents(Student student);
    void changeStudents(Student student);
    void deleteStudents(Student student);
    void addProfesor(Professor professor);
    void changeProfesor(Professor professor);
    void deleteProfesor(Professor professor);
    void addSubject(Subject subject);
    void changeSubject(Subject subject);
    void deleteSubject(Subject subject);
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

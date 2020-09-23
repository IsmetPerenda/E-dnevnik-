package ba.unsa.etf.rs.projekat;

import javafx.beans.Observable;
import javafx.collections.ObservableList;

public interface SkolaDAO {
    ObservableList<Student> getStudents();
    ObservableList<Professor> getProfesors();
    ObservableList<Subject> getSubject(Professor professor);
    ObservableList<Homework> getHomework();
    ObservableList<ClassRoom> getClassroom();
    ObservableList<Points> getPoints();
    ObservableList<Administrator>getAdmin();
    ObservableList<ClassRoom>getFreeClassRoom();
    ObservableList<Schedule>getSchedule();
    ObservableList<Student>getStudentsInSubjects(Professor professor);
    ObservableList<Student>getStudentsFromClassroom(ClassRoom classroom);
    ObservableList<Student>getStudentsOnSubject(Subject subject);
    void addStudents(Student student);
    void changeStudents(Student student);
    void deleteStudents(Student student);
    void addHomework(Homework homework);
    void changeHomework(Homework homework);
    void deleteHomework(Homework homework);
    void addClassroom(ClassRoom classRoom);
    void changeClassroom(ClassRoom classRoom);
    void deleteStudentsFromClassroom(ClassRoom classRoom);
    void deleteClassroom(ClassRoom classRoom);
    void addPoints(Points points);
    void changePoints(Points points);
    void deletePoints(Points points);

    void close();

    void changePassword(Student novi);

    void changePassword(Professor novi);

    void changePassword(Administrator novi);
}

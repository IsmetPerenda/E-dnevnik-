package ba.unsa.etf.rs.projekat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class SkolaDAOBase implements SkolaDAO {
    private Connection connection;

    private PreparedStatement selektujUcenikeIzRazreda,selektujUcenikeNaPredmetu,dajAdmina,dajUcenika,dajProfesora,dajPredmet,dajZadacu,dajRazred,dajBodove,dodajUcenika,odrediUcenika,dodajProfesora,dodajPredmet,dodajZadacu,odrediZadacu,dodajRazred,odrediRazred,dodajBodove,izmijeniUcenika,izmijeniProfesora,izmijeniPredmet,izmijeniZadacu,izmijeniRazred,izmijeniBodove,razrediUpit,dajLozinkuUcenik,dajLozinkuProfesor,dajLozinkuAdministrator,dajRasporedUpit,dajStudentaNaPredmetuUpit;
    public SkolaDAOBase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Skola.db");
            dajUcenika = connection.prepareStatement("select * from Ucenik order by prezime");
            dajProfesora = connection.prepareStatement("select * from Profesor order by prezime");
            dajPredmet = connection.prepareStatement("select * from Predmeti where profesor_id = ? order by id");
            dajRazred = connection.prepareStatement("select * from Razred order by godina ");
            dajZadacu = connection.prepareStatement("select * from Zadace order by id ");
            dajBodove = connection.prepareStatement("select * from Bodovi order by id ");
            dajAdmina = connection.prepareStatement("select * from Administrator order by id");

            dodajUcenika = connection.prepareStatement("insert into Ucenik values (?,?,?,?,?,?,?,?,?)");
            odrediUcenika = connection.prepareStatement("SELECT MAX(id)+1 FROM Ucenik");
            dodajZadacu = connection.prepareStatement("insert  into Zadace values (?,?,?,?)");
            odrediZadacu = connection.prepareStatement("SELECT MAX(id)+1 FROM Zadace");
            dodajBodove = connection.prepareStatement("insert  into Bodovi values (?,?,?,?)");
            dodajRazred = connection.prepareStatement("insert  into Razred values (?,?,?,?)");
            odrediRazred = connection.prepareStatement("SELECT MAX(id)+1 FROM Razred");

            izmijeniUcenika = connection.prepareStatement("update Ucenik set  ime=?,prezime=?,adresa=?,datum_rodjenja=?,opcina=?,email=?,lozinka=?,razred_id=?  where id = ?");
            izmijeniZadacu = connection.prepareStatement("update Zadace set naziv_zadace=?,predmet_id=?,bodovi=? where id=?");
            izmijeniRazred = connection.prepareStatement("update Razred set godina=?,naziv=?,broj_ucenika=? where id=?");
            izmijeniBodove = connection.prepareStatement("update Bodovi set ucenik_id=?,broj_bodova=?,zadaca_id=? where id=?");

            razrediUpit = connection.prepareStatement("select * from Razred where broj_ucenika  < 30");
            dajLozinkuUcenik = connection.prepareStatement("update Ucenik set lozinka=? where id=?");
            dajLozinkuAdministrator = connection.prepareStatement("update Administrator set lozinka=? where id=?");
            dajLozinkuProfesor = connection.prepareStatement("update Profesor set lozinka=? where id=?");

            dajRasporedUpit = connection.prepareStatement("select  * from Raspored");
            dajStudentaNaPredmetuUpit = connection.prepareStatement("select s.id,s.prezime,s.adresa,s.datum_rodjenja,s.opcina,s.email,s.lozinka,s.razred_id from Ucenik s,Raspored r,Predmeti p where s.id = r.ucenik_id and r.predmet_id = p.id and p.profesor_id=?");
            selektujUcenikeIzRazreda=connection.prepareStatement("select * from ucenik where razred_id=?");
            selektujUcenikeNaPredmetu = connection.prepareStatement(" select s.id,s.prezime,s.adresa,s.datum_rodjenja,s.opcina,s.email,s.lozinka,s.razred_id from Ucenik s, Raspored r where s.id =r.ucenik_id and r.predmet_id =?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Professor pretraziProfesora(int id) throws SQLException {
        PreparedStatement pretraga = connection.prepareStatement("select * from Profesor where id = ?");
        pretraga.setInt(1,id);
        ResultSet rs = pretraga.executeQuery();
        if(!rs.next())return null;
        return new Professor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(), rs.getDate(5).toLocalDate(), rs.getString(6), rs.getString(7));

    }
    private ClassRoom pretraziRazred(int id) throws SQLException {
        PreparedStatement pretraga = connection.prepareStatement("select * from Razred where id = ?");
        pretraga.setInt(1,id);
        ResultSet rs = pretraga.executeQuery();
        if(!rs.next())return null;
        return new ClassRoom(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getInt(4));

    }
    private Subject pretraziPredmet(int id) throws SQLException {
        PreparedStatement pretraga = connection.prepareStatement("select * from Predmet where id = ?");
        pretraga.setInt(1,id);
        ResultSet rs = pretraga.executeQuery();
        if(!rs.next())return null;
        return new Subject(rs.getInt(1), rs.getString(2), pretraziProfesora(rs.getInt(3)) );

    }
    private Student pretraziUcenika(int id) throws SQLException {
        PreparedStatement pretraga = connection.prepareStatement("select * from Ucenik where id = ?");
        pretraga.setInt(1,id);
        ResultSet x = pretraga.executeQuery();
        if(!x.next())return null;
        return new Student(x.getInt(1), x.getString(2), x.getString(3), x.getString(4),x.getDate(5).toLocalDate(), x.getString(6), x.getString(7), x.getString(8), pretraziRazred(x.getInt(9)));

    }
    private Homework pretraziZadacu(int id) throws SQLException {
        PreparedStatement pretraga = connection.prepareStatement("select * from Zadace where id = ?");
        pretraga.setInt(1,id);
        ResultSet x = pretraga.executeQuery();
        if(!x.next())return null;
        return new Homework(x.getInt(1), x.getString(2), pretraziPredmet(x.getInt(3)),x.getDouble(4));

    }
    @Override
    public ObservableList<Student> getStudents() {
        ObservableList<Student> students = FXCollections.observableArrayList();
        try {
            ResultSet x = dajUcenika.executeQuery();
            while (x.next()) {
                Student k = new Student(x.getInt(1), x.getString(2), x.getString(3), x.getString(4),x.getDate(5).toLocalDate(), x.getString(6), x.getString(7), x.getString(8), pretraziRazred(x.getInt(9)));
                students.add(k);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public ObservableList<Professor> getProfesors() {
        ObservableList<Professor> professors = FXCollections.observableArrayList();
        try {
            ResultSet x = dajProfesora.executeQuery();
            while (x.next()) {
                Professor k = new Professor(x.getInt(1), x.getString(2), x.getString(3), x.getDate(4).toLocalDate(), x.getDate(5).toLocalDate(), x.getString(6), x.getString(7));
                professors.add(k);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professors;
    }

    @Override
    public ObservableList<Subject> getSubject(Professor professor) {
        ObservableList<Subject> subjects = FXCollections.observableArrayList();
        try {
            dajPredmet.setInt(1,professor.getId());
            ResultSet x = dajPredmet.executeQuery();
            while (x.next()) {
                Subject k = new Subject(x.getInt(1), x.getString(2), pretraziProfesora(x.getInt(3)) );
                subjects.add(k);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjects;
    }

    @Override
    public ObservableList<Homework> getHomework() {
        ObservableList<Homework> homeworks = FXCollections.observableArrayList();
        try {
            ResultSet x = dajZadacu.executeQuery();
            while (x.next()) {
                Homework k = new Homework(x.getInt(1), x.getString(2), pretraziPredmet(x.getInt(3)),x.getDouble(4));
                homeworks.add(k);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return homeworks;
    }

    @Override
    public ObservableList<ClassRoom> getClassroom() {
        ObservableList<ClassRoom> classrooms = FXCollections.observableArrayList();
        try {
            ResultSet x = dajRazred.executeQuery();
            while (x.next()) {
                ClassRoom k = new ClassRoom(x.getInt(1), x.getInt(2), x.getString(3),x.getInt(4));
                classrooms.add(k);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classrooms;
    }

    @Override
    public ObservableList<Points> getPoints() {
        ObservableList<Points> points = FXCollections.observableArrayList();
        try {
            ResultSet x = dajBodove.executeQuery();
            while (x.next()) {
                Points k = new Points(x.getInt(1), x.getDouble(2),pretraziUcenika(x.getInt(3)), pretraziZadacu(x.getInt(4)) );
                points.add(k);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return points;
    }

    @Override
    public ObservableList<Administrator> getAdmin() {
        ObservableList<Administrator> admin = FXCollections.observableArrayList();
        try {
            ResultSet x = dajAdmina.executeQuery();
            while (x.next()) {
                Administrator k = new Administrator(x.getInt(1), x.getString(2),x.getString(3) );
                admin.add(k);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public ObservableList<ClassRoom> getFreeClassRoom()
    {             ObservableList<ClassRoom> classrooms = FXCollections.observableArrayList();
        try {
            ResultSet x = razrediUpit.executeQuery();
            while (x.next()) {
                ClassRoom k = new ClassRoom(x.getInt(1), x.getInt(2), x.getString(3),x.getInt(4));
                classrooms.add(k);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classrooms;
    }

    @Override
    public ObservableList<Schedule> getSchedule() {
        ObservableList<Schedule> schedules = FXCollections.observableArrayList();
        try {
            ResultSet x = dajRasporedUpit.executeQuery();
            while (x.next()) {
                Schedule k = new Schedule(x.getInt(1), pretraziUcenika(x.getInt(2)), pretraziPredmet(x.getInt(3)));
                schedules.add(k);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }

    @Override
    public ObservableList<Student> getStudentsInSubjects(Professor professor) {
        ObservableList<Student> students = FXCollections.observableArrayList();
        try {
            selektujUcenikeNaPredmetu.setInt(1,professor.getId());
                ResultSet x = selektujUcenikeNaPredmetu.executeQuery();
                while (x.next()) {
                    Student k = new Student(x.getInt(1), x.getString(2), x.getString(3), x.getString(4),x.getDate(5).toLocalDate(), x.getString(6), x.getString(7), x.getString(8), pretraziRazred(x.getInt(9)));
                    students.add(k);

                }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public ObservableList<Student> getStudentsFromClassroom(ClassRoom classroom) {
        ObservableList<Student> students = FXCollections.observableArrayList();
        try {
            selektujUcenikeIzRazreda.setInt(1,classroom.getId());
            ResultSet x = selektujUcenikeIzRazreda.executeQuery();
            while (x.next()) {
                Student k = new Student(x.getInt(1), x.getString(2), x.getString(3), x.getString(4),x.getDate(5).toLocalDate(), x.getString(6), x.getString(7), x.getString(8), pretraziRazred(x.getInt(9)));
                students.add(k);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public ObservableList<Student> getStudentsOnSubject(Subject subject) {
        ObservableList<Student> students = FXCollections.observableArrayList();
        try {
            selektujUcenikeNaPredmetu.setInt(1,subject.getId());
            ResultSet x = selektujUcenikeNaPredmetu.executeQuery();
            while (x.next()) {
                Student k = new Student(x.getInt(1), x.getString(2), x.getString(3), x.getString(4),x.getDate(5).toLocalDate(), x.getString(6), x.getString(7), x.getString(8), pretraziRazred(x.getInt(9)));
                students.add(k);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }


    @Override
    public void addStudents(Student student) {
        try {
            ResultSet rs = odrediUcenika.executeQuery();
            int id = 1;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            dodajUcenika.setInt(1, id);
            dodajUcenika.setString(2, student.getName());

            dodajUcenika.setString(3, student.getSurname());
            dodajUcenika.setString(4, student.getAdress());
            dodajUcenika.setDate(5, Date.valueOf(student.getDateOfBirth()));
            dodajUcenika.setString(6, student.getMunicipality());
            dodajUcenika.setString(7, student.getEmail());
            dodajUcenika.setString(8, student.getPassword());
            dodajUcenika.setInt(9, student.getClassroomId().getId());
            dodajUcenika.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeStudents(Student student) {
        try {

            izmijeniUcenika.setString(1,student.getName());
            izmijeniUcenika.setString(2,student.getSurname());
            izmijeniUcenika.setString(3,student.getAdress());
            izmijeniUcenika.setDate(4, Date.valueOf(student.getDateOfBirth()));
            izmijeniUcenika.setString(5,student.getMunicipality());
            izmijeniUcenika.setString(6,student.getEmail());
            izmijeniUcenika.setString(7,student.getPassword());
            izmijeniUcenika.setInt(8,student.getClassroomId().getId());
            izmijeniUcenika.setInt(9,student.getId());
            izmijeniUcenika.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteStudents(Student student) {

        PreparedStatement deleteStudentStatemant= null;
        try {
            deleteStudentStatemant = connection.prepareStatement("Delete from Ucenik where id=?;");
            deleteStudentStatemant.setInt(1,student.getId());
            deleteStudentStatemant.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }







    @Override
    public void addHomework(Homework homework) {
        try {
            ResultSet rs = odrediZadacu.executeQuery();
            int id = 1;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            dodajZadacu.setInt(1, id);
            dodajZadacu.setString(2, homework.getNameOfHomework());
            dodajZadacu.setInt(3, homework.getPredmetId().getId());
            dodajZadacu.setDouble(4, homework.getPoints());
            dodajZadacu.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeHomework(Homework homework) {

    }

    @Override
    public void deleteHomework(Homework homework) {
        PreparedStatement deleteHomeworkStatemant= null;
        try {
            deleteHomeworkStatemant = connection.prepareStatement("Delete from Zadace where id=?;");
            deleteHomeworkStatemant.setInt(1,homework.getId());
            deleteHomeworkStatemant.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addClassroom(ClassRoom classRoom) {
        try {
            ResultSet rs = odrediRazred.executeQuery();
            int id = 1;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            dodajRazred.setInt(1, id);
            dodajRazred.setInt(2, classRoom.getYear());
            dodajRazred.setString(3,classRoom.getName());
            dodajRazred.setInt(4, classRoom.getNumberOfStudents());

            dodajRazred.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeClassroom(ClassRoom classRoom) {
        try {

            izmijeniRazred.setInt(1,classRoom.getYear());
            izmijeniRazred.setString(2,classRoom.getName());
            izmijeniRazred.setInt(3,classRoom.getNumberOfStudents());
            izmijeniRazred.setInt(4,classRoom.getId());
            izmijeniRazred.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteStudentsFromClassroom(ClassRoom classRoom){

        try {
            PreparedStatement deleteStudentsStatemant = connection.prepareStatement("delete from Ucenik where razred_id= ?");
            deleteStudentsStatemant.setInt(1,classRoom.getId());
            deleteStudentsStatemant.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteClassroom(ClassRoom classRoom) {
        PreparedStatement deleteClassRoomStatemant= null;
        try {
            deleteClassRoomStatemant = connection.prepareStatement("Delete from Razred where id=?;");
            deleteClassRoomStatemant.setInt(1,classRoom.getId());
            deleteClassRoomStatemant.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPoints(Points points) {

    }

    @Override
    public void changePoints(Points points) {

    }

    @Override
    public void deletePoints(Points points) {
        PreparedStatement deletePointsStatemant= null;
        try {
            deletePointsStatemant = connection.prepareStatement("Delete from Bodovi where id=?;");
            deletePointsStatemant.setInt(1,points.getId());
            deletePointsStatemant.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changePassword(Student novi) {
        try {
            dajLozinkuUcenik.setString(1,novi.getPassword());
            dajLozinkuUcenik.setInt(2,novi.getId());
            dajLozinkuUcenik.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void changePassword(Professor novi) {
        try {
            dajLozinkuProfesor.setString(1,novi.getPassword());
            dajLozinkuProfesor.setInt(2,novi.getId());
            dajLozinkuProfesor.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void changePassword(Administrator novi) {
        try {
            dajLozinkuAdministrator.setString(1,novi.getPassword());
            dajLozinkuAdministrator.setInt(2,novi.getId());
            dajLozinkuAdministrator.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

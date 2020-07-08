package ba.unsa.etf.rs.projekat;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class SkolaDAOBase implements SkolaDAO {
    private Connection connection;
    private PreparedStatement dajUcenika,dajProfesora,dajPredmet,dajZadacu,dajRazred,dajBodove,dodajUcenika,dodajProfesora,dodajPredmet,dodajZadacu,dodajRazred,dodajBodove,izmijeniUcenika,izmijeniProfesora,izmijeniPredmet,izmijeniZadacu,izmijeniRazred,izmijeniBodove;
    public SkolaDAOBase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Skola.db");
            dajUcenika = connection.prepareStatement("select * from Ucenik order by prezime");
            dajProfesora = connection.prepareStatement("select * from Profesor order by prezime");
            dajPredmet = connection.prepareStatement("select * from Predmeti order by id");
            dajRazred = connection.prepareStatement("select * from Razred order by naziv ");
            dajZadacu = connection.prepareStatement("select * from Zadace order by id ");
            dajBodove = connection.prepareStatement("select * from Bodovi order by id ");

            dodajUcenika = connection.prepareStatement("insert into Ucenik values (?,?,?,?,?,?,?,?,?)");
            dodajProfesora = connection.prepareStatement("insert  into Profesor values (?,?,?,?,?,?)");
            dodajPredmet = connection.prepareStatement("insert  into Predmeti values (?,?,?)");
            dodajZadacu = connection.prepareStatement("insert  into Zadace values (?,?,?)");
            dodajBodove = connection.prepareStatement("insert  into Bodovi values (?,?,?,?)");
            dodajRazred = connection.prepareStatement("insert  into Razred values (?,?,?)");

            izmijeniUcenika = connection.prepareStatement("update Ucenik set  ime=?,prezime=?,adresa=?,datum_rodjenja=?,opcina=?,email=?,lozinka=?,razred_id=?  where id = ?");
            izmijeniProfesora = connection.prepareStatement("update Profesor set ime=?,prezime=?,datum_zaposlenja=?,datum_rodjenja=?,email=?,lozinka=? where id = ?");
            izmijeniPredmet = connection.prepareStatement("update Predmeti set naziv=?,profesor_id=? where id=?");
            izmijeniZadacu = connection.prepareStatement("update Zadace set naziv_zadace=?,predmet_id=? where id=?");
            izmijeniRazred = connection.prepareStatement("update Razred set godina=?,naziv=?,broj_ucenika=? where id=?");
            izmijeniBodove = connection.prepareStatement("update Bodovi set ucenik_id=?,broj_bodova=?,zadaca_id=? where id=?");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ObservableList<Student> getStudents() {
        return null;
    }

    @Override
    public ObservableList<Professor> getProfesors() {
        return null;
    }

    @Override
    public ObservableList<Subject> getSubject() {
        return null;
    }

    @Override
    public ObservableList<Homework> getHomework() {
        return null;
    }

    @Override
    public ObservableList<ClassRoom> getClassroom() {
        return null;
    }

    @Override
    public ObservableList<Points> getPoints() {
        return null;
    }

    @Override
    public void addStudents(Student student) {

    }

    @Override
    public void changeStudents(Student student) {

    }

    @Override
    public void deleteStudents(Student student) {

    }

    @Override
    public void addProfesor(Professor professor) {

    }

    @Override
    public void changeProfesor(Professor professor) {

    }

    @Override
    public void deleteProfesor(Professor professor) {

    }

    @Override
    public void addSubject(Subject subject) {

    }

    @Override
    public void changeSubject(Subject subject) {

    }

    @Override
    public void deleteSubject(Subject subject) {

    }

    @Override
    public void addHomework(Homework homework) {

    }

    @Override
    public void changeHomework(Homework homework) {

    }

    @Override
    public void deleteHomework(Homework homework) {

    }

    @Override
    public void addClassroom(ClassRoom classRoom) {

    }

    @Override
    public void changeClassroom(ClassRoom classRoom) {

    }

    @Override
    public void deleteClassroom(ClassRoom classRoom) {

    }

    @Override
    public void addPoints(Points points) {

    }

    @Override
    public void changePoints(Points points) {

    }

    @Override
    public void deletePoints(Points points) {

    }

    @Override
    public void close() {

    }
}

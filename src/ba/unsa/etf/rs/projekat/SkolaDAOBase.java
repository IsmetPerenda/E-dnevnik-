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
    public ObservableList<Ucenik> DajUcenike() {
        return null;
    }

    @Override
    public ObservableList<Profesor> DajProfesore() {
        return null;
    }

    @Override
    public ObservableList<Predmet> DajPredmet() {
        return null;
    }

    @Override
    public ObservableList<Zadace> DajZadace() {
        return null;
    }

    @Override
    public ObservableList<Razred> DajRazred() {
        return null;
    }

    @Override
    public ObservableList<Bodovi> DajBodove() {
        return null;
    }

    @Override
    public void DodajUcenika(Ucenik ucenik) {

    }

    @Override
    public void IzmijeniUcenika(Ucenik ucenik) {

    }

    @Override
    public void ObrisiUcenika(Ucenik ucenik) {

    }

    @Override
    public void DodajProfesora(Profesor profesor) {

    }

    @Override
    public void IzmijeniProfesora(Profesor profesor) {

    }

    @Override
    public void ObrisiProfesora(Profesor profesor) {

    }

    @Override
    public void DodajPredmet(Predmet predmet) {

    }

    @Override
    public void IzmijeniPredmet(Predmet predmet) {

    }

    @Override
    public void ObrisiPredmet(Predmet predmet) {

    }

    @Override
    public void DodajZadacu(Zadace zadace) {

    }

    @Override
    public void IzmijeniZadacu(Zadace zadace) {

    }

    @Override
    public void ObrisiZadacu(Zadace zadace) {

    }

    @Override
    public void DodajRazred(Razred razred) {

    }

    @Override
    public void IzmijeniRazred(Razred razred) {

    }

    @Override
    public void ObrisiRazred(Razred razred) {

    }

    @Override
    public void DodajBodove(Bodovi bodovi) {

    }

    @Override
    public void IzmijeniBodove(Bodovi bodovi) {

    }

    @Override
    public void ObrisiBodove(Bodovi bodovi) {

    }

    @Override
    public void close() {

    }
}

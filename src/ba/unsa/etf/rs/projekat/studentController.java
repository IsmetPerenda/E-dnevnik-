package ba.unsa.etf.rs.projekat;

public class studentController {

    private Student p;
    SkolaDAO dao = new SkolaDAOBase();

    public studentController(Student student) {
        p = student;

    }
}

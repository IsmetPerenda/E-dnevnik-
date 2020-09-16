package ba.unsa.etf.rs.projekat;

public class professorController {

    private Professor p;
    SkolaDAO dao = new SkolaDAOBase();
    public professorController(Professor professor) {
        p = professor;
    }
}

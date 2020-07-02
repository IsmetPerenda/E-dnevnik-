package ba.unsa.etf.rs.projekat;

import javafx.collections.ObservableList;

public interface SkolaDAO {
    ObservableList<Ucenik> DajUcenike();
    ObservableList<Profesor> DajProfesore();
    ObservableList<Predmet> DajPredmet();
    ObservableList<Zadace> DajZadace();
    ObservableList<Razred> DajRazred();
    ObservableList<Bodovi> DajBodove();
    void DodajUcenika(Ucenik ucenik);
    void IzmijeniUcenika(Ucenik ucenik);
    void ObrisiUcenika(Ucenik ucenik);
    void DodajProfesora(Profesor profesor);
    void IzmijeniProfesora(Profesor profesor);
    void ObrisiProfesora(Profesor profesor);
    void DodajPredmet(Predmet predmet);
    void IzmijeniPredmet(Predmet predmet);
    void ObrisiPredmet(Predmet predmet);
    void DodajZadacu(Zadace zadace);
    void IzmijeniZadacu(Zadace zadace);
    void ObrisiZadacu(Zadace zadace);
    void DodajRazred(Razred razred);
    void IzmijeniRazred(Razred razred);
    void ObrisiRazred(Razred razred);
    void DodajBodove(Bodovi bodovi);
    void IzmijeniBodove(Bodovi bodovi);
    void ObrisiBodove(Bodovi bodovi);

    void close();
}

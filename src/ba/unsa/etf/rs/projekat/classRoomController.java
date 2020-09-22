package ba.unsa.etf.rs.projekat;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class classRoomController implements Initializable {

    public TextField fldNaziv;
    public Button btnSpasi;
    public Spinner spinnerBrojUcenika;
    public static ClassRoom razred;
    public Spinner spinnerGodina;
    SkolaDAO dao = new SkolaDAOBase();
    public classRoomController(ClassRoom classRoom) {
        razred= classRoom;

    }

    public void actionSave(ActionEvent actionEvent) {
        boolean validno = true;
        if(fldNaziv.getText().isEmpty()){
            validno = false;
            fldNaziv.getStyleClass().removeAll("poljeIspravno");
            fldNaziv.getStyleClass().add("poljeNijeIspravno");
        }else{
            validno = true;
            fldNaziv.getStyleClass().removeAll("poljeNijeIspravno");
            fldNaziv.getStyleClass().add("poljeIspravno");
        }

        if(!validno)return;
        razred = new ClassRoom(1,(int)spinnerGodina.getValue(),fldNaziv.getText(),(int)spinnerBrojUcenika.getValue());
        Stage edit_add=(Stage)btnSpasi.getScene().getWindow();
        edit_add.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> brUcenika= new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30,0,1);
        this.spinnerBrojUcenika.setValueFactory(brUcenika);
        SpinnerValueFactory<Integer> godina= new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 9,1,1);
        this.spinnerGodina.setValueFactory(godina);
    }
}

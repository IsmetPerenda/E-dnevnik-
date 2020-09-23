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

public class homeworkController implements Initializable {
    public TextField fldNaziv;
    public Spinner spinnerBodovi;
    public Button btnSpasi;
    public Homework zadaca;
    SkolaDAO dao = new SkolaDAOBase();
    public homeworkController(Homework homework) {
        zadaca = homework;

    }

    public void actionSave(ActionEvent actionEvent) {

        Stage edit_add=(Stage)btnSpasi.getScene().getWindow();
        edit_add.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            SpinnerValueFactory<Integer> brBodova= new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10,0,1);
            this.spinnerBodovi.setValueFactory(brBodova);


    }
}

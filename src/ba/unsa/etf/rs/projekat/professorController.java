package ba.unsa.etf.rs.projekat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class professorController implements Initializable {


    public ListView listView;
    public ChoiceBox cbRazred;
    public ChoiceBox cbPredmet;
    private Professor p;
    SkolaDAO dao = new SkolaDAOBase();
    public professorController(Professor professor) {
        p = professor;
    }





    public void actionDodajZadacu(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodajZadacu.fxml"));
            homeworkController zadaca = new homeworkController(null);
            loader.setController(zadaca);
            root = loader.load();
            stage.setTitle("Zadaca");
            stage.setScene(new Scene(root, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
            stage.setResizable(true);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setItems(dao.getStudents());
        cbPredmet.setItems(dao.getSubject());
        cbRazred.setItems(dao.getClassroom());

    }
}

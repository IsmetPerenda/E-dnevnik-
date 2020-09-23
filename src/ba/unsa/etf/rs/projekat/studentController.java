package ba.unsa.etf.rs.projekat;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class studentController implements Initializable {

    public TableView<Homework> tbViewUcenik;
    public ChoiceBox cbUcenik;
    public TableColumn<Homework,String> cellZadace;
    public TableColumn cellBodovi;
    public Button btnOdjaviSe;

    private Student p;
    SkolaDAO dao = new SkolaDAOBase();

    public studentController(Student student) {
        p = student;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //  cbUcenik.setItems(dao.getSubject());
    }

    public void actionPromjeniLozinku(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/promjenaLozinke.fxml"));
            passwordChangeController razredcontroller = new passwordChangeController(p,dao);
            loader.setController(razredcontroller);
            root = loader.load();
            stage.setTitle("Promjena lozinke");
            stage.setScene(new Scene(root, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
            stage.setResizable(true);
            stage.showAndWait();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionOdjaviSe(ActionEvent actionEvent) {
        Stage change=(Stage)btnOdjaviSe.getScene().getWindow();
        change.close();
        Stage stage = new Stage();
        Parent root = null;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pocetna.fxml"));
            homescreenController razredcontroller = new homescreenController();
            loader.setController(razredcontroller);
            root = loader.load();
            stage.setTitle("Pocetna");
            stage.setScene(new Scene(root, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
            stage.setResizable(true);
            stage.showAndWait();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ba.unsa.etf.rs.projekat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class professorController implements Initializable {


    public ListView<Student> listView;
    public ChoiceBox<ClassRoom> cbRazred;
    public ChoiceBox<Subject> cbPredmet;
    public TreeTableColumn cellUcenik;
    public TreeTableColumn cellZadaca;
    public TreeTableColumn cellBodovi;
    public Button btnPromjeniLozinku;
    public TextField fldIme,fldPrezime,fldEmail;
    public Button btnOdjaviSe;
    private Professor p;
    SkolaDAO dao = new SkolaDAOBase();
    public professorController(Professor professor) {
        p = professor;
    }





    public void actionDodajZadacu(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/zadaca.fxml"));
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



        listView.setItems(dao.getStudentsInSubjects(p));
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            if(newKorisnik==null){
                fldIme.setText("");
                fldPrezime.setText("");
                fldEmail.setText("");


            }else{
                fldIme.setText(newKorisnik.getName());
                fldPrezime.setText(newKorisnik.getSurname());
                fldEmail.setText(newKorisnik.getEmail());
            }
        });
        cbPredmet.setItems(dao.getSubject(p));
        cbRazred.setItems(dao.getClassroom());

        cbPredmet.getSelectionModel().selectedItemProperty().addListener((obs, old, neww) -> {

             listView.setItems(dao.getStudentsOnSubject(neww));


        });
        cbRazred.getSelectionModel().selectedItemProperty().addListener((obs, old, neww) -> {
          listView.setItems(dao.getStudentsFromClassroom(neww));

        });

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

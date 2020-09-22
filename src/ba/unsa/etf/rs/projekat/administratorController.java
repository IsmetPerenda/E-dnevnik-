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
import java.util.Optional;
import java.util.ResourceBundle;

public class administratorController implements Initializable {
    public ListView<Student> listViewAdmin;
    public ListView<ClassRoom> listViewAdmin2;
    public TextField fldIme;
    public TextField fldPrezime;
    public TextField fldEmail;
    public TextField fldAdresa;
    public TextField fldOpcina;
    public DatePicker dpDatum;
    public ChoiceBox cbRazred;
    SkolaDAO dao = new SkolaDAOBase();
        Administrator admin;

    public administratorController(Administrator admin) {
        this.admin = admin;
    }

    public void actionDodajRazred(ActionEvent actionEvent) {

            Stage stage = new Stage();
            Parent root = null;
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodajRazred.fxml"));
                classRoomController razredcontroller = new classRoomController(null);
                loader.setController(razredcontroller);
                root = loader.load();
                stage.setTitle("Razred");
                stage.setScene(new Scene(root, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
                stage.setResizable(true);
                stage.showAndWait();
                if(classRoomController.razred == null)return;
                else{
                    dao.addClassroom(classRoomController.razred);

                    listViewAdmin2.setItems(dao.getClassroom());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listViewAdmin.setItems(dao.getStudents());
        listViewAdmin2.setItems(dao.getClassroom());
        cbRazred.setItems(dao.getFreeClassRoom());
    }

    public void actionIzmijeniRazred(ActionEvent actionEvent) {
        if(listViewAdmin2.getSelectionModel().getSelectedItem() != null) {
            Stage stage = new Stage();
            Parent root = null;
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodajRazred.fxml"));
                classRoomController razredcontroller = new classRoomController(listViewAdmin2.getSelectionModel().getSelectedItem());
                loader.setController(razredcontroller);
                root = loader.load();
                stage.setTitle("Razred");
                stage.setScene(new Scene(root, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
                stage.setResizable(true);
                stage.showAndWait();
                if (classRoomController.razred == null) return;
                else {
                    dao.changeClassroom(classRoomController.getRazred());

                    listViewAdmin2.setItems(dao.getClassroom());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("Niste odabrali razred za izmijenu!");
            error.setTitle("Izmijena nije uspjela");
            error.show();
        }
    }

    public void actionDodajUcenika(ActionEvent actionEvent) {
    }

    public void actionIzmijeniUcenika(ActionEvent actionEvent) {
    }

    public void actionObrisiRazred(ActionEvent actionEvent) {
        ClassRoom t =listViewAdmin2.getSelectionModel().getSelectedItem();
        if(t!=null) {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setContentText("Da li ste sigurni da želite obrisati razred,obrisat će se i svi učenici iz tog razreda?");
            confirm.setTitle("Obriši");
            Optional<ButtonType> result = confirm.showAndWait();
            if (result.get() == ButtonType.OK) {
                dao.deleteStudentsFromClassroom(t);
                dao.deleteClassroom(t);
            }
            confirm.close();
            listViewAdmin2.setItems(dao.getClassroom());
            listViewAdmin.setItems(dao.getStudents());

        }else{
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("Niste odabrali razred za brisanje!");
            error.setTitle("Brisanje nije uspjelo");
            error.show();
        }
    }

    public void actionObrisiUcenika(ActionEvent actionEvent) {
    }
}

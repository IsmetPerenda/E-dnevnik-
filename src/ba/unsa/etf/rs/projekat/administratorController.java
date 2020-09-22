package ba.unsa.etf.rs.projekat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class administratorController implements Initializable {
    public ListView listViewAdmin,listViewAdmin2;
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
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listViewAdmin.setItems(dao.getStudents());
        listViewAdmin2.setItems(dao.getClassroom());
        listViewAdmin.refresh();
        listViewAdmin2.refresh();
    }
}

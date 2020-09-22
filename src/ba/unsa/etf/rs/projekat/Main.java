package ba.unsa.etf.rs.projekat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

    public class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception{
/*
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/administrator.fxml"));
            primaryStage.setTitle("Studenti");
            primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            primaryStage.show();

 */            Stage stage = new Stage();
            administratorController cont = new administratorController(null);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/administrator.fxml"));
            loader.setController(cont);
            Parent root = loader.load();
            stage.setTitle("Administrator");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.show();
            //Stage edit_add = (Stage) buttonLogin.getScene().getWindow();
            //edit_add.close();
        }



        public static void main(String[] args) {
            launch(args);
        }
    }



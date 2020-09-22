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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pocetna.fxml"));
            homescreenController ctrl = new homescreenController();
            loader.setController(ctrl);
            Parent root = loader.load();
            primaryStage.setTitle("Pocetna");
            primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            primaryStage.show();

        }



        public static void main(String[] args) {
            launch(args);
        }
    }



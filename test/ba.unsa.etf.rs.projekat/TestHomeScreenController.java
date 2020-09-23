package ba.unsa.etf.rs.projekat;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ApplicationExtension.class)
class TestHomeScreenController {
        Stage theStage;
        homescreenController ctrl;

        @Start
        public void start (Stage stage) throws Exception {
            SkolaDAO dao = new SkolaDAOBase();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pocetna.fxml"));
            ctrl = new homescreenController();
            loader.setController(ctrl);
            Parent root = loader.load();
            stage.setTitle("Log In");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();
            stage.toFront();
            theStage = stage;
        }
        @Test
        void nonExistant(FxRobot robot){
            robot.clickOn("#textfldEmail");
            robot.write("mail@gmial.com");
            robot.clickOn("#textfldPassword");
            robot.write("pass");
            robot.clickOn("#buttonLogin");
            DialogPane dialogPane = robot.lookup(".dialog-pane").queryAs(DialogPane.class);
            Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
            robot.clickOn(okButton);
            String string = dialogPane.getContentText();
            boolean same = (string.equals("Unijeli ste pogresne informacije,niste ni profesor ni ucenik!"));
            assertTrue(same);
        }
    @Test
    void logInProfesor(FxRobot robot){
        robot.clickOn("#textfldEmail");
        robot.write("zjuric@etf.unsa.ba");
        robot.clickOn("#textfldPassword");
        robot.write("1234");
        robot.clickOn("#buttonLogin");
        DialogPane dialogPane = robot.lookup(".dialog-pane").queryAs(DialogPane.class);
        Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
        robot.clickOn(okButton);
        String string = dialogPane.getContentText();
        boolean same = (string.equals("Prijavili ste se kao profesor!"));
        assertTrue(same);
    }
    @Test
    void logInAdmin(FxRobot robot){
        robot.clickOn("#textfldEmail");
        robot.write("studentska.sluzba@etf.unsa.ba");
        robot.clickOn("#textfldPassword");
        robot.write("student");
        robot.clickOn("#buttonLogin");
        DialogPane dialogPane = robot.lookup(".dialog-pane").queryAs(DialogPane.class);
        Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
        robot.clickOn(okButton);
        String string = dialogPane.getContentText();
        boolean same = (string.equals("Prijavili ste se kao administrator!"));
        assertTrue(same);
    }
    @Test
    void logInStudent(FxRobot robot){
        robot.clickOn("#textfldEmail");
        robot.write("iperenda@gmail.com");
        robot.clickOn("#textfldPassword");
        robot.write("1234");
        robot.clickOn("#buttonLogin");
        DialogPane dialogPane = robot.lookup(".dialog-pane").queryAs(DialogPane.class);
        Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
        robot.clickOn(okButton);
        String string = dialogPane.getContentText();
        boolean content = (string.equals("Prijavili ste se kao učenik!"));
        assertTrue(content);
    }

}

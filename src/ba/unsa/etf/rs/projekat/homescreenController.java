package ba.unsa.etf.rs.projekat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class homescreenController {


    public Button buttonLogin;
    public TextField textfldEmail;
    public PasswordField textfldPassword;
    SkolaDAO dao = new SkolaDAOBase();

    public homescreenController() {
    }
    ObservableList<Professor> profesori = dao.getProfesors();
    ObservableList<Student> student = dao.getStudents();
    ObservableList<Administrator> admin = dao.getAdmin();
    public void PrijaviSe(ActionEvent actionEvent) throws IOException {


        boolean uspjesnoProfesor = false;
        boolean uspjesnoStudent = false;
        boolean uspjesnoAdmin = false;
        Professor k = null;
        Student x = null;
        Administrator a = null;
        for(int i = 0; i<profesori.size();i++){
            if(profesori.get(i).getEmail().equals(textfldEmail.getText()) && profesori.get(i).getPassword().equals(textfldPassword.getText())){k = profesori.get(i);uspjesnoProfesor = true;break;}
        }
        for(int i = 0; i<student.size();i++){
            if(student.get(i).getEmail().equals(textfldEmail.getText()) && student.get(i).getPassword().equals(textfldPassword.getText())){ x = student.get(i);uspjesnoStudent = true;break;}
        }
        for(int i = 0; i<admin.size();i++){
            if(admin.get(i).getEmail().equals(textfldEmail.getText()) && admin.get(i).getPassword().equals(textfldPassword.getText())){ a = admin.get(i);uspjesnoAdmin = true;break;}
        }
        if(uspjesnoProfesor == true){
            Stage stage=new Stage();
            professorController cont=new professorController(k);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/profesor.fxml"));
            loader.setController(cont);
            Parent root = loader.load();
            stage.setTitle("Profesor "+ k.getName()+ " " + k.getSurname());
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.show();
            Stage edit_add= (Stage)buttonLogin.getScene().getWindow();
            edit_add.close();
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setContentText("Prijavili ste se kao profesor!");
            info.setTitle("Dobro došli" + k.getName()+ " " + k.getSurname());
            info.show();

        }else if(uspjesnoStudent == true) {
            Stage stage = new Stage();
            studentController cont = new studentController(x);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ucenik.fxml"));
            loader.setController(cont);
            Parent root = loader.load();
            stage.setTitle("Ucenik "+x.getName()+" "+x.getSurname());
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.show();
            Stage edit_add = (Stage) buttonLogin.getScene().getWindow();
            edit_add.close();
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setContentText("Prijavili ste se kao učenik!");
            info.setTitle("Dobro došli" + x.getName()+ " " + x.getSurname());
            info.show();
        }else if(uspjesnoAdmin == true){
            Stage stage = new Stage();
            administratorController cont = new administratorController(a);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/administrator.fxml"));
            loader.setController(cont);
            Parent root = loader.load();
            stage.setTitle("Administrator");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.show();
            Stage edit_add = (Stage) buttonLogin.getScene().getWindow();
            edit_add.close();
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setContentText("Prijavili ste se kao administrator!");
            info.setTitle("Dobro došli u studentsku službu!");
            info.show();
        }
        else{
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("Unijeli ste pogresne informacije,niste ni profesor ni ucenik!");
            error.setTitle("Greška u Login-u!");
            error.show();
        }
        dao.close();
    }

}

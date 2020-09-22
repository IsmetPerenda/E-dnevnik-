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
import java.time.LocalDate;
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
    public ChoiceBox<ClassRoom> cbRazred;
    public Button btnOdjaviSe;
    SkolaDAO dao = new SkolaDAOBase();
        Administrator admin;

    public administratorController(Administrator admin) {
        this.admin = admin;
    }

    public void actionDodajRazred(ActionEvent actionEvent) {

            Stage stage = new Stage();
            Parent root = null;
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/razred.fxml"));
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
        listViewAdmin.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            if(newKorisnik==null){
                fldIme.setText("");
                fldPrezime.setText("");
                fldAdresa.setText("");
                fldEmail.setText("");
                fldOpcina.setText("");

            }else{
                fldIme.setText(newKorisnik.getName());
                fldPrezime.setText(newKorisnik.getSurname());
                fldAdresa.setText(newKorisnik.getAdress());
                fldEmail.setText(newKorisnik.getEmail());
                fldOpcina.setText(newKorisnik.getMunicipality());
    cbRazred.setValue(newKorisnik.getClassroomId());
                dpDatum.setValue(newKorisnik.getDateOfBirth());
            }
        });
    }
    public boolean eq(Student st,Student st2){
        if(!st.getName().equals(st2.getName()))return false;
        if(!st.getSurname().equals(st2.getSurname()))return false;
        if(!st.getAdress().equals(st2.getAdress()))return false;
        if(!st.getMunicipality().equals(st2.getMunicipality()))return false;
        if(!st.getEmail().equals(st2.getEmail()))return false;
        return true;

    }
    public void actionIzmijeniRazred(ActionEvent actionEvent) {
        if(listViewAdmin2.getSelectionModel().getSelectedItem() != null) {
            Stage stage = new Stage();
            Parent root = null;
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/razred.fxml"));
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
        boolean sveOk = true;


        if (fldIme.getText().trim().isEmpty()) {
            fldIme.getStyleClass().removeAll("poljeIspravno");
            fldIme.getStyleClass().add("poljeNijeIspravno");
            sveOk = false;
        } else {
            fldIme.getStyleClass().removeAll("poljeNijeIspravno");
            fldIme.getStyleClass().add("poljeIspravno");
        }
        if (fldPrezime.getText().trim().isEmpty()) {
            fldPrezime.getStyleClass().removeAll("poljeIspravno");
            fldPrezime.getStyleClass().add("poljeNijeIspravno");
            sveOk = false;
        } else {
            fldPrezime.getStyleClass().removeAll("poljeNijeIspravno");
            fldPrezime.getStyleClass().add("poljeIspravno");
        }
        if (fldAdresa.getText().trim().isEmpty()) {
            fldAdresa.getStyleClass().removeAll("poljeIspravno");
            fldAdresa.getStyleClass().add("poljeNijeIspravno");
            sveOk = false;
        } else {
            fldAdresa.getStyleClass().removeAll("poljeNijeIspravno");
            fldAdresa.getStyleClass().add("poljeIspravno");
        }
        if (fldEmail.getText().trim().isEmpty()) {
            fldEmail.getStyleClass().removeAll("poljeIspravno");
            fldEmail.getStyleClass().add("poljeNijeIspravno");
            sveOk = false;
        } else {
            fldEmail.getStyleClass().removeAll("poljeNijeIspravno");
            fldEmail.getStyleClass().add("poljeIspravno");
        }

        if (fldOpcina.getText().trim().isEmpty()) {
            fldOpcina.getStyleClass().removeAll("poljeIspravno");
            fldOpcina.getStyleClass().add("poljeNijeIspravno");
            sveOk = false;
        } else {
            fldOpcina.getStyleClass().removeAll("poljeNijeIspravno");
            fldOpcina.getStyleClass().add("poljeIspravno");
        }


        if (!sveOk) return;

        int v = 0;
        Student novi = new Student(1,fldIme.getText(),fldPrezime.getText(),fldAdresa.getText(), dpDatum.getValue(),fldOpcina.getText(),fldEmail.getText(),"1234",cbRazred.getSelectionModel().getSelectedItem());
        for(int i = 0; i<dao.getStudents().size();i++){
            if(eq(dao.getStudents().get(i),novi) == true) {
                v++;
            }
        }
        if(v != 0){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("Učenik već postoji");
            error.setTitle("Dodavanje neuspješno");
            error.show();
        }else{
            dao.addStudents(novi);
            ClassRoom r = novi.getClassroomId();
            r.setNumberOfStudents(r.getNumberOfStudents() + 1);
            dao.changeClassroom(r);
            listViewAdmin.setItems(dao.getStudents());
        }
    }

    public void actionIzmijeniUcenika(ActionEvent actionEvent) {
        boolean sveOk = true;
        Student t =listViewAdmin.getSelectionModel().getSelectedItem();
        if(t!=null) {

            if (fldIme.getText().trim().isEmpty()) {
                fldIme.getStyleClass().removeAll("poljeIspravno");
                fldIme.getStyleClass().add("poljeNijeIspravno");
                sveOk = false;
            } else {
                fldIme.getStyleClass().removeAll("poljeNijeIspravno");
                fldIme.getStyleClass().add("poljeIspravno");
            }
            if (fldPrezime.getText().trim().isEmpty()) {
                fldPrezime.getStyleClass().removeAll("poljeIspravno");
                fldPrezime.getStyleClass().add("poljeNijeIspravno");
                sveOk = false;
            } else {
                fldPrezime.getStyleClass().removeAll("poljeNijeIspravno");
                fldPrezime.getStyleClass().add("poljeIspravno");
            }
            if (fldAdresa.getText().trim().isEmpty()) {
                fldAdresa.getStyleClass().removeAll("poljeIspravno");
                fldAdresa.getStyleClass().add("poljeNijeIspravno");
                sveOk = false;
            } else {
                fldAdresa.getStyleClass().removeAll("poljeNijeIspravno");
                fldAdresa.getStyleClass().add("poljeIspravno");
            }
            if (fldEmail.getText().trim().isEmpty()) {
                fldEmail.getStyleClass().removeAll("poljeIspravno");
                fldEmail.getStyleClass().add("poljeNijeIspravno");
                sveOk = false;
            } else {
                fldEmail.getStyleClass().removeAll("poljeNijeIspravno");
                fldEmail.getStyleClass().add("poljeIspravno");
            }

            if (fldOpcina.getText().trim().isEmpty()) {
                fldOpcina.getStyleClass().removeAll("poljeIspravno");
                fldOpcina.getStyleClass().add("poljeNijeIspravno");
                sveOk = false;
            } else {
                fldOpcina.getStyleClass().removeAll("poljeNijeIspravno");
                fldOpcina.getStyleClass().add("poljeIspravno");
            }


            if (!sveOk) return;

            int v = 0;
            Student novi = new Student(0, fldIme.getText(), fldPrezime.getText(), fldAdresa.getText(), dpDatum.getValue(), fldOpcina.getText(), fldEmail.getText(), "1234", cbRazred.getSelectionModel().getSelectedItem());
            for (int i = 0; i < dao.getStudents().size(); i++) {
                if (eq(dao.getStudents().get(i), novi) == true) {
                    v++;
                }
            }
            if (v != 0) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setContentText("Učenik već postoji");
                error.setTitle("Dodavanje neuspješno");
                error.show();
            } else {
                dao.changeStudents(novi);
                listViewAdmin.setItems(dao.getStudents());
            }
        }else{
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("Niste odabrali učenika za izmijenu!");
            error.setTitle("Izmijena nije uspjela");
            error.show();
        }
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
        Student t =listViewAdmin.getSelectionModel().getSelectedItem();
        if(t!=null) {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setContentText("Da li ste sigurni da želite obrisati učenika?");
            confirm.setTitle("Obriši");
            Optional<ButtonType> result = confirm.showAndWait();
            if (result.get() == ButtonType.OK) {
                ClassRoom r = t.getClassroomId();
                r.setNumberOfStudents(r.getNumberOfStudents() - 1);
                dao.changeClassroom(r);
                dao.deleteStudents(t);

            }
            confirm.close();
            listViewAdmin2.setItems(dao.getClassroom());
            listViewAdmin.setItems(dao.getStudents());

        }else{
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("Niste odabrali učenika za brisanje!");
            error.setTitle("Brisanje nije uspjelo");
            error.show();
        }
    }

    public void generisiEmail(ActionEvent actionEvent){
        String string="";
        if(!fldIme.getText().isEmpty()){
            string = String.valueOf(fldIme.getText().charAt(0));
        }

        String username = "";
        username = username + string;
        String prezime = fldPrezime.getText();
        username = username + prezime + "@gmail.com";
        username = username.toLowerCase();
        username = username.replace("ž","z").replace("č","c").replace("ć","c").replace("š","s").replace("đ","d");
        fldEmail.setText(username);

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

package ba.unsa.etf.rs.projekat;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class passwordChangeController {

    public PasswordField fldStari;
    public PasswordField fldNovi;
    public PasswordField fldNoviPonovo;
    public Button btnOK;
    public Button btnCancel;
    SkolaDAO d;
    Student student;
    Professor professor;
    Administrator administrator;
    public passwordChangeController(Student d,SkolaDAO s) {
        this.student = d;
        this.d = s;
    }
    public passwordChangeController(Professor professor,SkolaDAO p){
        this.professor = professor;
        this.d = p;
    }
    public passwordChangeController(Administrator administrator,SkolaDAO a){
        this.administrator = administrator;
        this.d = a;
    }


    public void actionPromjeniLozinku(ActionEvent actionEvent) {

        boolean valid = true;
        if(student != null){

            if(!student.getPassword().equals(fldStari.getText())) {
                fldStari.getStyleClass().removeAll("poljeIspravno");
                fldStari.getStyleClass().add("poljeNijeIspravno");
                valid = false;
            }else{
                fldStari.getStyleClass().removeAll("poljeNijeIspravno");
                fldStari.getStyleClass().add("poljeIspravno");
            }
            if(!fldNovi.getText().equals(fldNoviPonovo.getText()) || fldNoviPonovo.getText().isEmpty() || fldNoviPonovo.getText().isEmpty()) {
                fldNovi.getStyleClass().removeAll("poljeIspravno");
                fldNovi.getStyleClass().add("poljeNijeIspravno");
                fldNoviPonovo.getStyleClass().removeAll("poljeIspravno");
                fldNoviPonovo.getStyleClass().add("poljeNijeIspravno");
                valid = false;
            }else{
                fldNovi.getStyleClass().removeAll("poljeNijeIspravno");
                fldNovi.getStyleClass().add("poljeIspravno");
                fldNoviPonovo.getStyleClass().removeAll("poljeNijeIspravno");
                fldNoviPonovo.getStyleClass().add("poljeIspravno");
            }
            if(valid){

                student.setPassword(fldNovi.getText());
                d.changePassword(student);
                Stage change=(Stage)btnOK.getScene().getWindow();
                change.close();
            }
        }else if(professor != null){

            if(!professor.getPassword().equals(fldStari.getText())) {
                fldStari.getStyleClass().removeAll("poljeIspravno");
                fldStari.getStyleClass().add("poljeNijeIspravno");
                valid = false;
            }else{
                fldStari.getStyleClass().removeAll("poljeNijeIspravno");
                fldStari.getStyleClass().add("poljeIspravno");
            }
            if(!fldNovi.getText().equals(fldNoviPonovo.getText()) || fldNoviPonovo.getText().isEmpty() || fldNoviPonovo.getText().isEmpty()) {
                fldNovi.getStyleClass().removeAll("poljeIspravno");
                fldNovi.getStyleClass().add("poljeNijeIspravno");
                fldNoviPonovo.getStyleClass().removeAll("poljeIspravno");
                fldNoviPonovo.getStyleClass().add("poljeNijeIspravno");
                valid = false;
            }else{
                fldNovi.getStyleClass().removeAll("poljeNijeIspravno");
                fldNovi.getStyleClass().add("poljeIspravno");
                fldNoviPonovo.getStyleClass().removeAll("poljeNijeIspravno");
                fldNoviPonovo.getStyleClass().add("poljeIspravno");
            }
            if(valid){

                professor.setPassword(fldNovi.getText());
                d.changePassword(professor);
                Stage change=(Stage)btnOK.getScene().getWindow();
                change.close();
            }
        }else if(administrator != null){
            if(!administrator.getPassword().equals(fldStari.getText())) {
                fldStari.getStyleClass().removeAll("poljeIspravno");
                fldStari.getStyleClass().add("poljeNijeIspravno");
                valid = false;
            }else{
                fldStari.getStyleClass().removeAll("poljeNijeIspravno");
                fldStari.getStyleClass().add("poljeIspravno");
            }
            if(!fldNovi.getText().equals(fldNoviPonovo.getText()) || fldNoviPonovo.getText().isEmpty() || fldNoviPonovo.getText().isEmpty()) {
                fldNovi.getStyleClass().removeAll("poljeIspravno");
                fldNovi.getStyleClass().add("poljeNijeIspravno");
                fldNoviPonovo.getStyleClass().removeAll("poljeIspravno");
                fldNoviPonovo.getStyleClass().add("poljeNijeIspravno");
                valid = false;
            }else{
                fldNovi.getStyleClass().removeAll("poljeNijeIspravno");
                fldNovi.getStyleClass().add("poljeIspravno");
                fldNoviPonovo.getStyleClass().removeAll("poljeNijeIspravno");
                fldNoviPonovo.getStyleClass().add("poljeIspravno");
            }
            if(valid){

                administrator.setPassword(fldNovi.getText());
                d.changePassword(administrator);
                Stage change=(Stage)btnOK.getScene().getWindow();
                change.close();
            }
        }
    }

    public void actionCancel(ActionEvent actionEvent) {
        Stage change=(Stage)btnCancel.getScene().getWindow();
        change.close();
    }



}



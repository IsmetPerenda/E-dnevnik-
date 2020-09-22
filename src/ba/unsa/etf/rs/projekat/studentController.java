package ba.unsa.etf.rs.projekat;

import javafx.beans.binding.Bindings;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class studentController implements Initializable {

    public TableView<Homework> tbViewUcenik;
    public ChoiceBox cbUcenik;
    public TableColumn<Homework,String> cellZadace;
    public TableColumn cellBodovi;
    private Student p;
    SkolaDAO dao = new SkolaDAOBase();

    public studentController(Student student) {
        p = student;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tbViewUcenik.setItems(dao.getHomework());
        cellZadace.setCellValueFactory(cellData ->  Bindings.createStringBinding(() -> cellData.getValue().getNameOfHomework()));
        cellBodovi.setCellValueFactory(new PropertyValueFactory("bodovi"));
        cbUcenik.setItems(dao.getSubject());
    }
}

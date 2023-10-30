
package proyectopilas;

import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrincipalController implements Initializable {
    
    public pila lista = new pila();
    Calendar calendario = new GregorianCalendar();
    int dia = calendario.get(Calendar.DATE);
    int mes = calendario.get(Calendar.MONTH);
    int año = calendario.get(Calendar.YEAR);
    int diav, mesv, añov;
    public static String fecha;
    
    @FXML
    private TableView<producto> tabla;
    @FXML
    private TableColumn<producto, String> id;
    @FXML
    private TableColumn<producto, String> nom;
    @FXML
    private TableColumn<producto, String> fechal;
    @FXML
    private TableColumn<producto, String> fechav;
    @FXML
    private TableColumn<producto, Float> preciou;
    
    public static ObservableList<producto> tablist = FXCollections.observableArrayList();
    
    @FXML
    private Button cerrar, registrar, menos10, menos1, mas1, mas10;
    
    @FXML
    private TextField idt, nomt, preciot, fechalt, fechavt;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calendario.add(Calendar.DATE, 31);
        diav = calendario.get(Calendar.DATE);
        mesv = calendario.get(Calendar.MONTH);
        añov = calendario.get(Calendar.YEAR);
        fecha = String.valueOf(diav) + "/" + String.valueOf(mesv+1) + "/" + String.valueOf(añov);
        fechavt.setText(fecha);
        calendario.add(Calendar.DATE, -31);
        dia = calendario.get(Calendar.DATE);
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR);
        fecha = String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año);
        fechalt.setText(fecha);
        
        id.setCellValueFactory(new PropertyValueFactory<producto, String>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<producto, String>("nom"));
        fechal.setCellValueFactory(new PropertyValueFactory<producto, String>("fechal"));
        fechav.setCellValueFactory(new PropertyValueFactory<producto, String>("fechav"));
        preciou.setCellValueFactory(new PropertyValueFactory<producto, Float>("preciou"));
        tabla.setItems(tablist);
        // TODO
    }    
    
}

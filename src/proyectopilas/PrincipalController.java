
package proyectopilas;

import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PrincipalController implements Initializable {
    
    
    Calendar calendario = new GregorianCalendar();
    
    @FXML
    private Button cerrar, registrar, menos10, menos1, mas1, mas10;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

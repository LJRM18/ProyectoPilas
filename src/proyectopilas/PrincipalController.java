
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

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
    
    @FXML
    private MenuItem idb, nomb, preciob, fechalb, fechavb, promedio, mayorpromedio, menorpromedio, mayorprecio, menorprecio;
    
    @FXML
    private void actionevent (ActionEvent e){
        Object evt = e.getSource();
        if(evt.equals(registrar)){
            producto produ = new producto(idt.getText(), nomt.getText(), fechalt.getText()
                    , fechavt.getText(), Float.parseFloat(preciot.getText()));
            lista.setPushProducto(produ);
            idt.setText("");
            nomt.setText("");
            preciot.setText("");
        }
        if(evt.equals(idb)){
            String id = JOptionPane.showInputDialog("Ingrese el ID de producto que desea buscar:");
            if (lista.sacarid(id) != null){
                producto buscar = lista.sacarid(id);
                JOptionPane.showMessageDialog(null, "El producto con el ID buscado es:\n"
                                                    + "ID: " + buscar.id + "\n"
                                                    + "Nombre: " + buscar.nom + "\n"
                                                    + "Fecha lote: " + buscar.fechal + "\n"
                                                    + "Fecha vencimiento: " + buscar.fechav + "\n"
                                                    + "Precio: " + buscar.preciou);
            }
        }
        if(evt.equals(nomb)){
            String nom = JOptionPane.showInputDialog("Ingrese el nombre de producto que desea buscar:");
            if (lista.sacarnombre(nom) != null){
                producto buscar = lista.sacarnombre(nom);
                JOptionPane.showMessageDialog(null, "El producto con el nombre buscado es:\n"
                                                    + "ID: " + buscar.id + "\n"
                                                    + "Nombre: " + buscar.nom + "\n"
                                                    + "Fecha lote: " + buscar.fechal + "\n"
                                                    + "Fecha vencimiento: " + buscar.fechav + "\n"
                                                    + "Precio: " + buscar.preciou);
            }
        }
        if(evt.equals(fechalb)){
            String fechal = JOptionPane.showInputDialog("Ingrese la fecha lote que desea buscar");
            lista.buscarFechal(fechal);
        }
        if(evt.equals(fechavb)){
            String fechav = JOptionPane.showInputDialog("Ingrese la fecha de vencimiento que desea buscar");
            lista.buscarFechav(fechav);
        }
        if(evt.equals(preciob)){
            float precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del producto que desea buscar"));
            lista.buscarprecio(precio);
        }
            if(evt.equals(menos10)){
            calendario.add(Calendar.DATE, -10);
            dia = calendario.get(Calendar.DATE);
            mes = calendario.get(Calendar.MONTH);
            año = calendario.get(Calendar.YEAR);
            fechalt.setText(String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año));
            calendario.add(Calendar.DATE, 31);
            diav = calendario.get(Calendar.DATE);
            mesv = calendario.get(Calendar.MONTH);
            añov = calendario.get(Calendar.YEAR);
            fechavt.setText(String.valueOf(diav) + "/" + String.valueOf(mesv+1) + "/" + String.valueOf(añov));
            calendario.add(Calendar.DATE, -31);
            fecha = String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año);
            lista.eliminarprodu();
        }
        if(evt.equals(menos1)){
            calendario.add(Calendar.DATE, -1);
            dia = calendario.get(Calendar.DATE);
            mes = calendario.get(Calendar.MONTH);
            año = calendario.get(Calendar.YEAR);
            fechalt.setText(String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año));
            calendario.add(Calendar.DATE, 31);
            diav = calendario.get(Calendar.DATE);
            mesv = calendario.get(Calendar.MONTH);
            añov = calendario.get(Calendar.YEAR);
            fechavt.setText(String.valueOf(diav) + "/" + String.valueOf(mesv+1) + "/" + String.valueOf(añov));
            calendario.add(Calendar.DATE, -31);
            fecha = String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año);
            lista.eliminarprodu();
        }
        if(evt.equals(mas1)){
            calendario.add(Calendar.DATE, 1);
            dia = calendario.get(Calendar.DATE);
            mes = calendario.get(Calendar.MONTH);
            año = calendario.get(Calendar.YEAR);
            fechalt.setText(String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año));
            calendario.add(Calendar.DATE, 31);
            diav = calendario.get(Calendar.DATE);
            mesv = calendario.get(Calendar.MONTH);
            añov = calendario.get(Calendar.YEAR);
            fechavt.setText(String.valueOf(diav) + "/" + String.valueOf(mesv+1) + "/" + String.valueOf(añov));
            calendario.add(Calendar.DATE, -31);
            fecha = String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año);
            lista.eliminarprodu();
        }
        if(evt.equals(mas10)){
            calendario.add(Calendar.DATE, 10);
            dia = calendario.get(Calendar.DATE);
            mes = calendario.get(Calendar.MONTH);
            año = calendario.get(Calendar.YEAR);
            fechalt.setText(String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año));
            calendario.add(Calendar.DATE, 31);
            diav = calendario.get(Calendar.DATE);
            mesv = calendario.get(Calendar.MONTH);
            añov = calendario.get(Calendar.YEAR);
            fechavt.setText(String.valueOf(diav) + "/" + String.valueOf(mesv+1) + "/" + String.valueOf(añov));
            calendario.add(Calendar.DATE, -31);
            fecha = String.valueOf(dia) + "/" + String.valueOf(mes+1) + "/" + String.valueOf(año);
            lista.eliminarprodu();
        }
        if(evt.equals(cerrar)){
            System.exit(0);
        }
    }
    
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

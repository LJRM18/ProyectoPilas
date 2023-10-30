
package proyectopilas;

import java.util.Stack;
import javax.swing.JOptionPane;

public class pila {
    private Stack<producto> pila;
    public pila (){
        this.pila = new Stack<>();
    }
    public void setPushProducto (producto p){
        if(sacarid(p.id) != null){
            JOptionPane.showMessageDialog(null, "Ya existe un producto con este ID!");
        }else if(sacarnombre(p.nom) != null){
            JOptionPane.showMessageDialog(null, "Ya existe un producto con este Nombre!");
        }else{
            pila.push(p);
            PrincipalController.tablist.add(p);
            JOptionPane.showMessageDialog(null, "Producto registrado!");
        }
    }
    public producto sacarid(String id){
        producto idprodu = new producto();
        int i = 0;
        while(i<pila.size()){
            idprodu = (producto) pila.get(i);
            if(idprodu.id.equals(id))
                return idprodu;
            i++;
        }
        idprodu = null;
        return idprodu;
    }
    public producto sacarnombre(String nombre){
        producto nomprodu = new producto();
        int i = 0;
        while(i<pila.size()){
            nomprodu = (producto) pila.get(i);
            if(nomprodu.nom.equals(nombre))
                return nomprodu;
            i++;
        }
        nomprodu = null;
        return nomprodu;
    }
        public void eliminarprodu(){
        String fecha = PrincipalController.fecha;
        producto eliminar = new producto();
        for (producto lista : pila){
            eliminar = vencido(fecha);
            while(eliminar != null){
                pila.remove(eliminar);
                PrincipalController.tablist.remove(eliminar);
                eliminar = vencido(fecha);
            }
        }
    }
    public producto vencido (String FechaV){
        producto aux = new producto();
        int i = 0;
        while(i<pila.size()){
            aux = (producto) pila.get(i);
            if(aux.fechav.equals(FechaV))
                return aux;
            i++;
        }
        aux = null;
        return aux;
    }
}

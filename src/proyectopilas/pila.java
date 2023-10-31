
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
    public void buscarFechal(String fechal){
        for(producto fecha : pila){
            if(fecha.fechal.equals(fechal)){
                JOptionPane.showMessageDialog(null, "El producto con la fecha lote buscada es:\n"
                                                    + "ID: " + fecha.id + "\n"
                                                    + "Nombre: " + fecha.nom + "\n"
                                                    + "Fecha lote: " + fecha.fechal + "\n"
                                                    + "Fecha vencimiento: " + fecha.fechav + "\n"
                                                    + "Precio: " + fecha.preciou);
            }
        }
    }
    public void buscarFechav(String fechav){
        for(producto fecha : pila){
            if(fecha.fechav.equals(fechav)){
                JOptionPane.showMessageDialog(null, "El producto con la fecha de vencimiento buscada es:\n"
                                                    + "ID: " + fecha.id + "\n"
                                                    + "Nombre: " + fecha.nom + "\n"
                                                    + "Fecha lote: " + fecha.fechal + "\n"
                                                    + "Fecha vencimiento: " + fecha.fechav + "\n"
                                                    + "Precio: " + fecha.preciou);
            }
        }
    }
    public void buscarprecio(float precio){
        for(producto preciob : pila){
            if(preciob.preciou == (precio)){
                JOptionPane.showMessageDialog(null, "El producto con el precio buscado es:\n"
                                                    + "ID: " + preciob.id + "\n"
                                                    + "Nombre: " + preciob.nom + "\n"
                                                    + "Fecha lote: " + preciob.fechal + "\n"
                                                    + "Fecha vencimiento: " + preciob.fechav + "\n"
                                                    + "Precio: " + preciob.preciou);
            }
        }
    }
    public float promedio(){
        float suma = 0;
        float promedio = 0;
        for (producto sum : pila){
            suma = sum.preciou + suma;
        }
        promedio = suma / pila.size();
        return promedio;
    }
    public void menorpromedio(){
        float promedio = promedio();
        for(producto menor : pila){
            if(menor.preciou < promedio){
                JOptionPane.showMessageDialog(null, "Los productos con un precio menor al promedio son:\n"
                                                    + "ID: " + menor.id + "\n"
                                                    + "Nombre: " + menor.nom + "\n"
                                                    + "Fecha lote: " + menor.fechal + "\n"
                                                    + "Fecha vencimiento: " + menor.fechav + "\n"
                                                    + "Precio: " + menor.preciou);
            }
        }
    }
    public void mayorpromedio(){
        float promedio = promedio();
        for(producto mayor : pila){
            if(mayor.preciou > promedio){
                JOptionPane.showMessageDialog(null, "Los productos con un precio menor al promedio son:\n"
                                                    + "ID: " + mayor.id + "\n"
                                                    + "Nombre: " + mayor.nom + "\n"
                                                    + "Fecha lote: " + mayor.fechal + "\n"
                                                    + "Fecha vencimiento: " + mayor.fechav + "\n"
                                                    + "Precio: " + mayor.preciou);
            }
        }
    }
    public void mayorprecio(){
        producto mayor = new producto();
        for (producto may : pila){
            if(may.preciou > mayor.preciou){
                mayor = may;
            }
        }
        for (producto may : pila){
            if(may.preciou == mayor.preciou){
                JOptionPane.showMessageDialog(null, "Los productos con mayor precio son:\n"
                                                    + "ID: " + may.id + "\n"
                                                    + "Nombre: " + may.nom + "\n"
                                                    + "Fecha lote: " + may.fechal + "\n"
                                                    + "Fecha vencimiento: " + may.fechav + "\n"
                                                    + "Precio: " + may.preciou);
            }
        }
    }
    public void menorprecio(){
        producto mayor = new producto();
        for (producto may : pila){
            if(may.preciou > mayor.preciou){
                mayor = may;
            }
        }
        for (producto men : pila){
            if(men.preciou < mayor.preciou){
                mayor = men;
            }
        }
        for (producto men : pila){
            if(men.preciou == mayor.preciou){
                JOptionPane.showMessageDialog(null, "Los productos con mayor precio son:\n"
                                                    + "ID: " + men.id + "\n"
                                                    + "Nombre: " + men.nom + "\n"
                                                    + "Fecha lote: " + men.fechal + "\n"
                                                    + "Fecha vencimiento: " + men.fechav + "\n"
                                                    + "Precio: " + men.preciou);
            }
        }
    }
}

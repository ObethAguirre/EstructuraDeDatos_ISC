package p;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class LES_Examen {
   
      LinkedList pila = new LinkedList();
      
      public void InsertarALKD(int dato){
        pila.add(dato);
        JOptionPane.showMessageDialog(null,"Se agrego correctamente el Empleado: "+dato);
        }
    public void Borrar(int nEm){
        JOptionPane.showMessageDialog(null, "Se elimino correctamente el Empleado"+pila.remove() );
        pila.pop();
    }
}

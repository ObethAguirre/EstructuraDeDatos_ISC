package ESTACIONAMIENTOS;
import java.util.Stack;
import javax.swing.JOptionPane;
public class TAREA_5 {


    /* 21291509 AGUIRRE GARCIA

    Crear de la clase Pila con objeto STRING dos PILAS(PILAPRIN Y PILATEMP) para poder manejar las placas de los vehiculos.
    Llegada de un vehiculo al estacionamiento principal PILAPRIN. Se inserta en esa pila.
    Salida de un vehiculo del estacionamiento principal, si no es el del top (peek()) pasar los vehiculos del estacionamiento principal(PILAPRIN)
       al estacionamiento temporal (PILATEMP) hasta encontrar el vehiculo a borrar del estacionamiento principal.
       Despues regresar los vehiculos del estacionamiento temporal(PILATEMP) al estacionamiento principal (PILAPRIN)
    Imprimir los vehiculos del estacionamiento principal PILAPRIN
    Indicar cuantos vehiculos hay en el estacionamiento principal PILAPRIN
    Mostrar el ultimo elemento insertado en el estacionamiento principal (PILAPRIN)
    Menu principal que mande llamar los metodos anteriores.

     */

    Stack<String> PILAPRINCIPAL, PILATEMPORAL;
    String placa;

    public TAREA_5() {
        this.placa = placa;
        this.PILAPRINCIPAL = PILAPRINCIPAL;
        PILAPRINCIPAL = new Stack<String>();
        this.PILATEMPORAL = PILATEMPORAL;
        PILATEMPORAL = new Stack<String>();
    }

    public boolean pilaPRINCIPALVacia() {
        if (!PILAPRINCIPAL.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pilaTEMPORALVacia() {
        if (!PILATEMPORAL.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //menu
    public void insertarPRINCIPAL() {
        placa = JOptionPane.showInputDialog("Escribe la placa a ingresar");
        PILAPRINCIPAL.push(placa);
    }

    public void insertarTEMPORAL() {
        PILATEMPORAL.push(PILAPRINCIPAL.pop());
    }

    public void regresarTEMPORALaPRINCIPAL() {
        while (!PILATEMPORAL.isEmpty()) {
            PILAPRINCIPAL.push(PILATEMPORAL.pop());
        }

    }

    public void eliminaElementoPRINCIPAL() {
        PILAPRINCIPAL.pop();

    }

    //menu
    public void mostrarEstacionamientoPrincipal() {
        if (!pilaPRINCIPALVacia()) {
            JOptionPane.showMessageDialog(null, "El estacionamiento principal esta vacio", "ESTACIONAMIENTO PRINCIPAL", JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrarPlacas = "";
            for (int i = 0; i < PILAPRINCIPAL.size(); i++) {
                mostrarPlacas += PILAPRINCIPAL.get(i) + "\n";
            }
            JOptionPane.showMessageDialog(null, "Autos en el estacionamiento principal : \n" + mostrarPlacas);
        }
    }

    public void mostrarEstacionamientoTemporal() {
        if (!pilaTEMPORALVacia()) {
            JOptionPane.showMessageDialog(null, "El estacionamiento temporal esta vacio", "ESTACIONAMIENTO TEMPORAL", JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrarPlacas = "";
            for (int i = 0; i < PILATEMPORAL.size(); i++) {
                mostrarPlacas += PILATEMPORAL.get(i) + "\n";
            }
            JOptionPane.showMessageDialog(null, "Autos en el estacionamiento temporal : \n" + mostrarPlacas);
        }
    }
    //menu

    public void cuantosElementos() {
        JOptionPane.showMessageDialog(null, "Hay " + PILAPRINCIPAL.size() + " carro(s).");
    }

    public void ultimoAuto() {
        JOptionPane.showMessageDialog(null, "El ultimo auto ingresado es " + PILAPRINCIPAL.peek());
    }

    //menu
    public void sacarAuto() {
        if (!pilaPRINCIPALVacia()) {
            JOptionPane.showMessageDialog(null, "El estacionamiento principal esta vacio", "ESTACIONAMIENTO PRINCIPAL", JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrarPlacas = "";
            for (int i = 0; i < PILAPRINCIPAL.size(); i++) {
                mostrarPlacas += PILAPRINCIPAL.get(i) + "\n";
            }

            placa = JOptionPane.showInputDialog("Autos guardados: \n" + mostrarPlacas + "\nEscribe las placas del auto que desea sacar:");

            while (!PILAPRINCIPAL.peek().equalsIgnoreCase(placa)) {
                insertarTEMPORAL();
            }
            eliminaElementoPRINCIPAL();
            JOptionPane.showMessageDialog(null, "VehÃ­culo con placa  [ " + placa + " ]  ha salido del estacionamiento principal.");
            regresarTEMPORALaPRINCIPAL();
        }
    }

}

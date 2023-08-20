package PILAS;
import java.util.Stack;
import javax.swing.JOptionPane;
public class TAREA_4 {


    /*
    Crea PILA
    De VacÃ­a PILA true o false
    De Inserta elemento en la PILA
    De borrar elemento de la PILA
    Imprimir todos los elementos de  la PILA.
    Imprimir el elemento del tope de la PILA.
    Imprimir la cantidad de elementos de la PILA.
    Menu principal que llame a los mÃ©todos anteriores,
    entendiendo que para borrar se tiene que validar el metodo de vacio antes de borrar.

     */

        Stack<Integer> PILA;
        int elemento;

        public TAREA_4() {
            this.elemento = elemento;
            this.PILA = PILA;
            PILA = new Stack<Integer>();
        }

        public boolean pilaVacia() {
            if (!PILA.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }

        public void insertarEnPila() {
            elemento = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un elemento a la pila"));
            PILA.push(elemento);
        }

        public void imprimirPila() {
//        System.out.println("Los datos de la memoriaDinamica son :");

            if (!pilaVacia()) {
                JOptionPane.showMessageDialog(null, "La pila esta vacia", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                String mostrar="";
                for (int i = 0; i < PILA.size(); i++) {
                    mostrar+=PILA.get(i)+"\n";
                }
                JOptionPane.showMessageDialog(null, "Elementos de la pila : \n"+mostrar);
            }
        }

        public void cantidadElementos() {
            JOptionPane.showMessageDialog(null, "La pila contiene " + PILA.size() + " elementos");
        }

        public void elementoTope() {
            if (!pilaVacia()) {
                JOptionPane.showMessageDialog(null, "La pila esta vacia", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Elemento tope es el "+PILA.peek());
            }
        }

        public void eliminaElemento() {
            if (!pilaVacia()) {
                JOptionPane.showMessageDialog(null, "La pila esta vacia", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Se ha eliminado el valor: " + PILA.pop());
            }
        }

        public void vaciaPila() {
            if (!pilaVacia()) {
                JOptionPane.showMessageDialog(null, "La pila esta vacia", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                PILA.clear();
                JOptionPane.showMessageDialog(null, "La pila se ha vaciado");
            }
        }


    }


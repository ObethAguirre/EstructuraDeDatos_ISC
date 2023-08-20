package COLAS;
import javax.swing.JOptionPane;
public class TAREA_7 {


    /*
    Desarrollar un programa en JAVA que defina una estructura COLA usando arreglos unidimensionales ejemplo: int cola[]; int inicio,fin, int maximo=100; para hacer un programa  con los METODOS:
        Crear la COLA
        De Vacia COLA true o false
        De llena COLA true o false
        De Inserta elemento en la COLA
        De borrar elemento de la COLA
        Imprimir los elementos de la COLA
        Imprimir el  primer elemento de la COLA
        Imprimir el Ã¹ltimo elemento de la COLA
        Imprimir la cantidad de elementos que contiene la COLA
        Menu principal que llame a los metodos anteriores, entendiendo que para insertar se tiene que llamar al metodo de lleno
                        antes de insertar y para borrar se tiene que validar el metodo de vacio antes de borrar.
                        USAR OPERACION MODULO PARA MOVER LOS APUNTADORES inicio y fin.

    EL PRIMERO QUE ENTRA PRIMERO QUE SALE

     */

        int cola[], inicio, fin, max;

        public TAREA_7(int max) {
            inicio = fin = 0;
            this.max = max;
            this.cola = new int[this.max + 1];
        }

        public boolean vacia() {
            return inicio == fin;
        }

        public boolean llena() {
            return (fin + 1) % max == inicio;
        }

        public void insertar() {
            int elemento;
            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa un valor", "ENTRADA", JOptionPane.QUESTION_MESSAGE));
            if (!llena()) {
                cola[fin] = elemento;
                fin = (fin + 1) % max;
            } else {
                JOptionPane.showMessageDialog(null, "La cola esta llena, no se pudo insertar el valor [ " + elemento + " ]", "ENTRADA", JOptionPane.ERROR_MESSAGE);
            }
        }

        public void borrar() {
            if (!vacia()) {
                JOptionPane.showMessageDialog(null, "Se ha borrado el elemento [" + cola[inicio] + " ]", "BORRAR", JOptionPane.OK_OPTION);
                inicio = (inicio + 1) % max;
            } else {
                JOptionPane.showMessageDialog(null, "La cola esta vacia", "BORRAR", JOptionPane.WARNING_MESSAGE);
            }
        }

        public void imprimirCola() {
            if (!vacia()) {
                int e = inicio;
                String mostrar = "";
                while (e != fin) {
                    mostrar += "[ " + cola[e] + " ]\n";
                    e = (e + 1) % max;
                }
                JOptionPane.showMessageDialog(null, "Elementos de la cola :\n" + mostrar);
            } else {
                JOptionPane.showMessageDialog(null, "La cola esta vacia", "IMPRIMIR", JOptionPane.WARNING_MESSAGE);
            }
        }

        public void imprimirPrimer() {
            if (!vacia()) {
                JOptionPane.showMessageDialog(null, "El primer elemento es [ " + cola[inicio] + " ]", "PRIMER ELEMENTO", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "La cola esta vacia", "PRIMER ELEMENTO", JOptionPane.WARNING_MESSAGE);
            }
        }

        public void imprimirUltimo() {
            if (!vacia()) {
                int i = (fin - 1 + max) % max;
                JOptionPane.showMessageDialog(null, "El ultimo elemento es [ " + cola[i] + " ]", "ULTIMO ELEMENTO", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "La cola esta vacia", "ULTIMO ELEMENTO", JOptionPane.WARNING_MESSAGE);
            }
        }

        public void cantidad() {
            int cantidad = (fin - inicio + max) % max;
            JOptionPane.showMessageDialog(null, "La cantidad de elementos es [ " + cantidad + " ]");
        }

    }


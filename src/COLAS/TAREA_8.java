package COLAS;
import java.util.LinkedList;
import javax.swing.JOptionPane;
public class TAREA_8 {


    /*
    Desarrollar un programa en JAVA que maneje una COLA usando memoria dinÃ¡mica con la clase
    LINKEDLIST
    LinkedList<Integer> cola= new LinkedList<Integer>();

        Y los metodos de:
        1. Crear la cola
        2. Verificar si esta vacia
        3. Insertar un elemento al final de la cola
        4. Borrar un elemento del inicio de la cola
        5. Imprimir todos los elementos de la cola
        6. Imprimir el primer elemento insertado
        7. Imprimir el Ãºltimo elemento insertado
        8. Imprimir la cantidad de elementos (tamaÃ±o) de la cola

    FECHA DE ENTREGA JUEVES 16 FEB 2023

     */

        LinkedList<Integer> cola = new LinkedList<Integer>();
        int elemento;

        // Este metodo ya esta creado isEmpty ,
        public boolean VerificarSiEstaVacia() {
            if (!cola.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }

        //Se puede insertar elementos donde queramos, para funcionamiento de una cola lo insertamos al final.

        public void insertarElementroAlFinal() {
            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa un elemento : "));
            JOptionPane.showMessageDialog(null, "Se ha aÃ±adido [ " + elemento + " ] a la cola.", "INSERTAR ELEMENTO",
                    JOptionPane.INFORMATION_MESSAGE);
            cola.add(elemento);
        }

        public void BorrarElementoDelInicio() {
            if (!VerificarSiEstaVacia()) {
                JOptionPane.showMessageDialog(null, "La cola esta vacia.", "BORRAR PRIMER ELEMENTO",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Se ha eliminado [ " + cola.pollFirst() + " ] de la cola.",
                        "BORRAR PRIMER ELEMENTO", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        public void ImprimirTodosElementos() {
            if (!VerificarSiEstaVacia()) {
                JOptionPane.showMessageDialog(null, "La cola esta vacia.", "IMPRIMIR TODOS LOS ELEMENTOS",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                String mostrar = "";
                mostrar = cola + "\n";
                JOptionPane.showMessageDialog(null, "Contenido : " + mostrar, "IMPRIMIR TODOS LOS ELEMENTOS",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

        public void ImprimirPrimerInsertado() {
            if (!VerificarSiEstaVacia()) {
                JOptionPane.showMessageDialog(null, "La cola esta vacia.", "IMPRIMIR PRIMER ELEMENTO INSERTADO",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Primer elemento de la cola[ " + cola.getFirst() + " ].",
                        "IMPRIMIR PRIMER ELEMENTO INSERTADO", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        public void ImprimirUltimoInsertado() {
            if (!VerificarSiEstaVacia()) {
                JOptionPane.showMessageDialog(null, "La cola esta vacia.", "IMPRIMIR ULTIMO ELEMENTO INSERTADO",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Utimo elemento de la cola [ " + cola.getLast() + " ].",
                        "IMPRIMIR ULTIMO ELEMENTO INSERTADO", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        public void ImprimirCantidadElementos() {
            if (!VerificarSiEstaVacia()) {
                JOptionPane.showMessageDialog(null, "La cola esta vacia.", "IMPRIMIR TAMAÃ‘O", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Se ha eliminado [ " + cola.size() + " ] de la cola.",
                        "IMPRIMIR TAMAÃ‘O", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        // Sirve para buscar si un elemento se encuentra en la cola
        public void Contains() {
            if (!VerificarSiEstaVacia()) {
                JOptionPane.showMessageDialog(null, "La cola esta vacia.", "BUSCAR ELEMENTO", JOptionPane.WARNING_MESSAGE);
            } else {
                int buscado = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un elemento a buscar : "));
                if (cola.contains(buscado)) {
                    JOptionPane.showMessageDialog(null, "Se ha encontrado el valor  [ " + buscado + " ] en la cola.",
                            "BUSCAR ELEMENTO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No ha encontrado el valor  [ " + buscado + " ] en la cola.",
                            "BUSCAR ELEMENTO", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        // BORRAR TODOS LOS ELEMENTOS DE LA COLA
        public void BorrarCola() {
            if (!VerificarSiEstaVacia()) {
                JOptionPane.showMessageDialog(null, "La cola esta vacia.", "BORRAR COLA", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "La cola se ha vaciado.", "BORRAR COLA", JOptionPane.WARNING_MESSAGE);
                cola.clear();
            }
        }
    }


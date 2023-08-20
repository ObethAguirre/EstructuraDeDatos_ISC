package EXAMEN_EXTRAORDINARIO;

import javax.swing.*;
import java.util.Stack;

public class EXAMEN_EXTRAORDINARIO {
    static String mostrar = "";
    Stack<Integer> PILA = new Stack<>();

    public EXAMEN_EXTRAORDINARIO() {

    }

    int numemp, tam;
    String nomemp;

    EXAMEN_EXTRAORDINARIO prev, ultimo, nc, temp, next;

    public EXAMEN_EXTRAORDINARIO(char estatus, int numemp, String nomemp) {
        this.nomemp = nomemp;
        this.numemp = numemp;
        prev = null;
        ultimo = null;
        nc = null;
        tam = 0;
    }

    static int ArbolCount = 0;
    EXAMEN_EXTRAORDINARIO izq, der, raiz = null;
    char estatus = 'a';


    //ALTA EN UN ARBOL
    public void InsertarArbol() {
        ArbolCount++;
        int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de empleado"));
        String nom = JOptionPane.showInputDialog(null, "Nombre de empleado");
        EXAMEN_EXTRAORDINARIO nodo_nuevo = new EXAMEN_EXTRAORDINARIO('a', num, nom);
        if (raiz == null) {
            raiz = nodo_nuevo;
        } else {
            EXAMEN_EXTRAORDINARIO auxiliar = raiz;
            EXAMEN_EXTRAORDINARIO padre;
            while (true) {
                padre = auxiliar;
                if (num < auxiliar.numemp) {
                    auxiliar = auxiliar.izq;
                    if (auxiliar == null) {
                        padre.izq = nodo_nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.der;
                    if (auxiliar == null) {
                        padre.der = nodo_nuevo;
                        return;
                    }
                }
            }
        }
    }

    //Recorridos de Arbol Binario:
    public void order(EXAMEN_EXTRAORDINARIO n) {
        if (n != null && n.estatus != 'b') {
            order(n.izq);
            order(n.der);
        }
        if (n != null && n.estatus == 'b') {
            order(n.izq);
            order(n.der);
        }
    }

    //PREORDER
    public void PREORDER(EXAMEN_EXTRAORDINARIO n) {
        if (n != null && n.estatus != 'b') {
            mostrar = mostrar + "Numero Empleado : " + n.numemp + "----- Nombre Empleado :" + n.nomemp + "\n";
            PREORDER(n.izq);
            PREORDER(n.der);
        }
        if (n != null && n.estatus == 'b') {
            PREORDER(n.izq);
            PREORDER(n.der);
        }
    }

    //INORDER
    public void INORDER(EXAMEN_EXTRAORDINARIO n) {
        if (n != null && n.estatus != 'b') {
            INORDER(n.izq);
            mostrar = mostrar + "Numero Empleado : " + n.numemp + "----- Nombre Empleado :" + n.nomemp + "\n";
            INORDER(n.der);
        }
        if (n != null && n.estatus == 'b') {
            INORDER(n.izq);
            INORDER(n.der);
        }
    }

    //POSTORDER
    public void post_orden(EXAMEN_EXTRAORDINARIO n) {
        if (n != null && n.estatus != 'b') {
            post_orden(n.izq);
            post_orden(n.der);
            mostrar = mostrar + "Numero Empleado : " + n.numemp + "----- Nombre Empleado :" + n.nomemp + "\n";
        }
        if (n != null && n.estatus == 'b') {
            post_orden(n.izq);
            post_orden(n.der);
        }
    }


    //Eliminar Nodo

    public EXAMEN_EXTRAORDINARIO obtenerNodoReemplazo(EXAMEN_EXTRAORDINARIO Reemplazo) {
        EXAMEN_EXTRAORDINARIO reemplazarPadre = Reemplazo;
        EXAMEN_EXTRAORDINARIO reemplazo = Reemplazo;
        EXAMEN_EXTRAORDINARIO aux = Reemplazo.der;
        while (aux != null) {
            reemplazarPadre = reemplazo;
            reemplazo = aux;
            aux = aux.izq;
        }
        if (reemplazo != Reemplazo.der) {
            reemplazarPadre.izq = reemplazo.der;
            reemplazo.der = Reemplazo.der;
        }
        return reemplazo;
    }

    public boolean EliminarNodo() {
        int Eliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Eliminar : "));
        EXAMEN_EXTRAORDINARIO aux = raiz, padre = raiz;
        Boolean es_izq = true;
        while (aux.numemp != Eliminar) {
            padre = aux;
            if (Eliminar < aux.numemp) {
                es_izq = true;
                aux = aux.izq;

            } else {
                es_izq = false;
                aux = aux.der;

            }
            if (aux == null) {
                return false;
            }
        }
        if (aux.izq == null && aux.der == null) {
            if (aux == raiz) {
                raiz = null;

            } else if (es_izq == true) {
                padre.izq = null;
            } else {
                padre.der = null;

            }
        } else if (aux.der == null) {
            if (aux == raiz) {
                raiz = aux.izq;

            } else if (es_izq) {
                padre.izq = aux.izq;

            } else {
                padre.der = aux.izq;

            }
        } else if (aux.izq == null) {
            if (aux == raiz) {
                raiz = aux.der;

            } else if (es_izq) {
                padre.izq = aux.der;

            } else {
                padre.der = aux.der;

            }
        } else {
            EXAMEN_EXTRAORDINARIO reemplazo = obtenerNodoReemplazo(aux);
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (es_izq) {
                padre.izq = reemplazo;
            } else {
                padre.der = reemplazo;
            }
            reemplazo.izq = aux.izq;
        }
        ArbolCount--;
        return true;
    }

    //Cantidad de nodos
    public void cantidadNodos() {
        JOptionPane.showMessageDialog(null, "Cantidad de nodos: " + ArbolCount);
    }

    //Pasar del arbol a LESC
    public void pasar_De_arbol_a_cola(EXAMEN_EXTRAORDINARIO n) {
        String mostrar = "";
        if (n != null && n.estatus != 'b') {
            pasar_De_arbol_a_cola(n.izq);
            if (nc == null) {
                nc = new EXAMEN_EXTRAORDINARIO(n.estatus, n.numemp, n.nomemp);
                nc.next = nc;
            }
            temp = nc.next;
            prev = nc;
            while ((temp != nc) && (temp.numemp < n.numemp)) {
                prev = temp;
                temp = temp.next;

            }
            tam++;
            n.next = prev.next;
            prev.next = n;
            pasar_De_arbol_a_cola(n.der);
        }
        if (n != null && n.estatus == 'b') {
            pasar_De_arbol_a_cola(n.izq);
            pasar_De_arbol_a_cola(n.der);
        }
    }

    //IMPRIMIR LESC
    public void imprimirLESC() {
        EXAMEN_EXTRAORDINARIO temp = nc.next;
        String cola = "";

        while (temp != nc) {
            cola += "-------------------------------" + "\nNumero Empleado : " + temp.numemp + "\nNombre Empleado: " + temp.nomemp + "\n -------------------------------";
            temp = temp.next;
        }
        JOptionPane.showMessageDialog(null, cola, "Mostrar LESC", JOptionPane.PLAIN_MESSAGE);
        cola = "";
    }

    //PASAR NUMEMP DE LESC A PILA
    public void insertarPILA() {
        EXAMEN_EXTRAORDINARIO first = nc.next;
        if (first == null) {
            // La lista está vacía
            JOptionPane.showMessageDialog(null, "la lista  esta vacia");
        }
        EXAMEN_EXTRAORDINARIO current = first;
        do {
            PILA.push(current.numemp);
            EXAMEN_EXTRAORDINARIO nextNode = current.next;
            // Borrar el nodo actual
            current.next = null;
            current = nextNode;
        } while (current != first);

        // Actualizar el nodo inicial para indicar que la lista está vacía
        first = null;
        tam--;
    }

    //eliminar elemento de LESC
    public void borrarLESC() {
        EXAMEN_EXTRAORDINARIO temporal, siguiente;
        temporal = nc.next;
        prev = nc;
        int numero_de_empleado = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de empleado que vas a borrar", "Borrar empleado", JOptionPane.WARNING_MESSAGE));
        if (temporal == null) {
            JOptionPane.showMessageDialog(null, "la lista  esta vacia");
        } else {
            while ((temporal != nc) && (temporal.numemp != numero_de_empleado)) {
                prev = temporal;
                temporal = temporal.next;
            }
            if (temporal == nc) {
                JOptionPane.showMessageDialog(null, "numero de empleado no existe");

            } else {
                prev.next = temporal.next;
                JOptionPane.showMessageDialog(null, "Numero de empleado: " + numero_de_empleado + " fue eliminado");
                tam--;
            }
        }
    }

    //Imprimir PILA
    public void MostrarPILA() {
        JOptionPane.showMessageDialog(null, PILA, "Mostrando PILA", JOptionPane.PLAIN_MESSAGE);
    }

    //TAMAÑO PILA Y LESC
    public void Tamaños() {
        JOptionPane.showMessageDialog(null, "Tamaño Pila : " + PILA.size() + "\n" + "Tamaño LESC : " + tam);
    }


    public static void main(String[] args) {
        int opcion;
        EXAMEN_EXTRAORDINARIO al = new EXAMEN_EXTRAORDINARIO();
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ricardo Francisco Moreno Luna\nMatricula:19506497\n"+
                    "0)\t Salir\n "+
                    "1)\tAlta en Arbol\n" +
                    "2)\tRecorridos de Arbol\n" +
                    "a.\tPreorder\n" +
                    "b.\tInorder\n" +
                    "c.\tPostorder\n" +
                    "3)\tEliminar de Arbol buscando por numemp=X\n" +
                    "4)\tNumero de Nodos del Arbol\n" +
                    "5)\tPasar de Arbol a LESC\n" +
                    "6)\tImprimir LESC\n" +
                    "7)\tPasar de LESC a PILA\n" +
                    "8)\tEliminar de LESC\n" +
                    "9)\tImprimir PILA\n" +
                    "10)\tTamaños de PILA y LESC\n"));
            switch (opcion) {
                case 1:
                    al.InsertarArbol();
                    break;
                case 2:
                    mostrar="Preorden\n";
                    al.PREORDER(al.raiz);
                    JOptionPane.showMessageDialog(null,mostrar);
                    mostrar="Inorder\n";
                    al.INORDER(al.raiz);
                    JOptionPane.showMessageDialog(null,mostrar);
                    mostrar="Postorder\n";
                    al.post_orden(al.raiz);
                    JOptionPane.showMessageDialog(null,mostrar);
                    break;
                case 3:
                    al.EliminarNodo();
                    break;
                case 4:
                    al.cantidadNodos();
                    break;
                case 5:
                    al.pasar_De_arbol_a_cola(al.raiz);
                    break;
                case 6:
                    al.imprimirLESC();
                    break;
                case 7:
                    al.insertarPILA();
                    break;
                case 8:
                    al.borrarLESC();
                    break;
                case 9:
                    al.MostrarPILA();
                    break;
                case 10:
                    al.Tamaños();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Inserte una opcion valida");
            }
        } while (opcion!=0);
    }
}

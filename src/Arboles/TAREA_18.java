package Arboles;

import javax.swing.*;
import java.util.LinkedList;

public class TAREA_18 {

    //linkedlist
  static   LinkedList<Integer> cola = new LinkedList<>();


    //arbol binario
    TAREA_18 izq, raiz = null, der;
    static int contador_De_arbol = 0;
    char estatus = 'a';
    static String com = "";
    int numero_empelado;
    float sueldo;
    String nombre_empleado;


    //lista encadenada simple circular
    static int contador_de_lista = 0;
    TAREA_18 siguiente;
  static TAREA_18 nc;
    TAREA_18 anterior;
    TAREA_18 temp;



   //CONSTRUCTOR DE ARBOL
    public TAREA_18(char estatus, int numero_empelado, float sueldo, String nombre_empleado) {

        this.estatus = estatus;
        this.numero_empelado = numero_empelado;
        this.sueldo = sueldo;
        this.nombre_empleado = nombre_empleado;
    }
    public TAREA_18() {

    }
//


    public void InsertarArbol() {
        //INSERTAMOS EN ARBOL
        contador_De_arbol++;
        String nombre = JOptionPane.showInputDialog(null, "Inserte el nombre");
        int numero_de_empleado = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de empleado:"));
        int s = Integer.parseInt(JOptionPane.showInputDialog(null, "Sueldo:"));
        TAREA_18 nodo_nuevo = new TAREA_18('a', numero_de_empleado, s, nombre);
        if (raiz == null) {
            raiz = nodo_nuevo;
        } else {
            TAREA_18 aux = raiz;
            TAREA_18 padre;
            while (true) {
                padre = aux;
                if (numero_de_empleado < aux.numero_empelado) {
                    aux = aux.izq;
                    if (aux == null) {
                        padre.izq = nodo_nuevo;
                        return;
                    }
                } else {
                    aux = aux.der;
                    if (aux == null) {
                        padre.der = nodo_nuevo;
                        return;
                    }
                }
            }
        }
    }

    public void InsertarListaEncadenadaSimple() {
        //INSERTAR EN LISTA SIMPLE CIRCULAR
        String nombre = JOptionPane.showInputDialog(null, "Inserte el nombre");
        int numero_de_empleado = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de empleado:"));
        int s = Integer.parseInt(JOptionPane.showInputDialog(null, "Sueldo:"));
        TAREA_18 nodo_nuevo = new TAREA_18('a', numero_de_empleado, s, nombre);

        if (nc == null) {
            nc = new TAREA_18();
            nc.siguiente = nc;
        }
        temp = nc.siguiente;
        anterior = nc;
        while ((temp != nc) && (temp.numero_empelado < nodo_nuevo.numero_empelado)) {
            anterior = temp;
            temp = temp.siguiente;

        }
        contador_de_lista++;
        nodo_nuevo.siguiente = anterior.siguiente;
        anterior.siguiente = nodo_nuevo;
    }



    public void ArboltoLista3(TAREA_18 nuevo_nodo) {
//AQUI SE PASAN DE ARBOL A LISTA
        if (nc == null) {
            nc = new TAREA_18();
            nc.siguiente = nc;
        }
        temp = nc.siguiente;
        anterior = nc;
        while ((temp != nc) && (temp.numero_empelado < nuevo_nodo.numero_empelado)) {
            anterior = temp;
            temp = temp.siguiente;

        }
        contador_de_lista++;
       nuevo_nodo.siguiente = anterior.siguiente;
        anterior.siguiente = nuevo_nodo;
    }

    public void ArboltoLista2(TAREA_18 n) {
        if (n != null && n.estatus != 'b') {
            ArboltoLista2(n.izq);
            //aqui va donde pasa  a lista

            ArboltoLista3(n);
            ArboltoLista2(n.der);
        }
        if (n != null && n.estatus == 'b') {
            ArboltoLista2(n.izq);
            ArboltoLista2(n.der);
        }
    }

public void ArboltoLinkedList(TAREA_18 n) {
    if (n != null && n.estatus != 'b') {
        ArboltoLinkedList(n.izq);
        //aqui va DE ARBOL Y pasa  a lista LINKEDLIST

       cola.add(n.numero_empelado);
        ArboltoLinkedList(n.der);
    }
    if (n != null && n.estatus == 'b') {
        ArboltoLinkedList(n.izq);
        ArboltoLinkedList(n.der);
    }
}
    public void ORDENAR(TAREA_18 n) {
        // ARBOL EN ORDEN
        if (n != null && n.estatus != 'b') {

            ORDENAR(n.izq);
            com = com + "Numero de empleado: " + n.numero_empelado + "\nSueldo: " + n.sueldo + "\n" + n.sueldo + "\nNombre: " + n.nombre_empleado + "\n----------------------------------------------------------------------------------------\n";

            ORDENAR(n.der);
        }
        if (n != null && n.estatus == 'b') {
            ORDENAR(n.izq);
            ORDENAR(n.der);
        }
    }
    public void MostrarListaEncadenadaSimple() {
        //IMPRMIR LISTA ENCADENADA SIMPLE
        TAREA_18 temp = nc.siguiente;
        String datos = "";
        while (temp != nc) {
            datos = datos + "Numero de empleado: " + temp.numero_empelado + "\nSueldo: " + temp.sueldo + "\n" + temp.sueldo + "\nNombre: " + temp.nombre_empleado + "\n----------------------------------------------------------------------------------------\n";
            temp = temp.siguiente;
        }
        JOptionPane.showMessageDialog(null, datos);
    }
    public void POSTORDER(TAREA_18 n) {
        //IMPRIMIR ARBOL EN POSTORDER IZQ-DER-DATO
        if (n != null && n.estatus != 'b') {
            POSTORDER(n.izq);
            POSTORDER(n.der);
            com = com + "Numero de empleado: " + n.numero_empelado + "\nSueldo: " + n.sueldo + "\n" + n.sueldo + "\nNombre: " + n.nombre_empleado + "\n----------------------------------------------------------------------------------------\n";

        }
        if (n != null && n.estatus == 'b') {
            POSTORDER(n.izq);
            POSTORDER(n.der);
        }
    }

    public void PREORDER(TAREA_18 n) {
        //IMPRIMIR EL ARBOL DE PREORDER DATO-IZQ-DER
        if (n != null && n.estatus != 'b') {
            com = com + "Numero de empleado: " + n.numero_empelado + "\nSueldo: " + n.sueldo + "\n" + n.sueldo + "\nNombre: " + n.nombre_empleado + "\n----------------------------------------------------------------------------------------\n";
            PREORDER(n.izq);
            PREORDER(n.der);

        }
        if (n != null && n.estatus == 'b') {
            PREORDER(n.izq);
            PREORDER(n.der);
        }

    }
    public int profundidad(TAREA_18 nodo) {
        //PROFUNDIDAD DEL ARBOL
        if (nodo == null) {
            return 0;
        } else {
            int profundidadIzquierda = profundidad(nodo.izq);
            int profundidadDerecha = profundidad(nodo.der);
            return 1 + Math.max(profundidadIzquierda, profundidadDerecha);//para irme al que mas se acerque
        }
    }
    public void ListaEncadenadaSimpletoArbol() {
        //SE LISTA ENCADENADA SIMPLE CIRCULAR A ARBOL
        TAREA_18 temp = nc.siguiente;
        String datos = "";
        while (temp != nc) {
ListaEncadenadaSimpletoArbol(temp);
            temp = temp.siguiente;
        }

    }
    public  void ListaEncadenadaSimpletoArbol(TAREA_18 nodo_nuevo){
        //DE LISTA ENCADENADA SIMPLE CIRCULAR A ARBOL
        contador_De_arbol++;
        if (raiz == null) {
            raiz = nodo_nuevo;
        } else {
            TAREA_18 aux = raiz;
            TAREA_18 padre;
            while (true) {
                padre = aux;
                if (nodo_nuevo.numero_empelado < aux.numero_empelado) {
                    aux = aux.izq;
                    if (aux == null) {
                        padre.izq = nodo_nuevo;
                        return;
                    }
                } else {
                    aux = aux.der;
                    if (aux == null) {
                        padre.der = nodo_nuevo;
                        return;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        TAREA_18 a = new TAREA_18();
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte una opcion:\n" +
                    "0.Salir del programa\n" +
                    "2.-Insertar en Arbol\n" +
                    "3.-Insertar en ListaEncadenadaSimple\n" +
                    "4.-Arbol to LinkedList\n" +
                    "5.-Recorridos del Arbol\n" +
                    "6.-Mostrar ListaEncadenadaSimple\n" +
                    "7.-Mostrar LinkedList\n" +
                    "8.-Tamaño ListaEncadenadaSimple\n" +
                    "9.-Numero Nodos Arbol\n" +
                    "10.-Profundidad Arbol\n" +
                    "11.-Eliminar ListaEncadenadaSimple to Arbol\n" +
                    "12.-ListaEncadenadaSimple to Arbol"));


            switch (op) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;

                case 2:
                    a.InsertarArbol();
                    break;
                case 3:
                    a.InsertarListaEncadenadaSimple();
                    break;
                case 4:
                    a.ArboltoLinkedList(a.raiz);

                    break;
                case 5:
                    com = "In-Orden\n\n";
                    a.ORDENAR(a.raiz);
                    JOptionPane.showMessageDialog(null, com);

                    com = "Post-Orden\n\n";
                    a.POSTORDER(a.raiz);
                    JOptionPane.showMessageDialog(null, com);
                    com = "Pre-Orden\n\n";
                    a.PREORDER(a.raiz);
                    JOptionPane.showMessageDialog(null, com);
                    break;
                case 6:
                    a.MostrarListaEncadenadaSimple();

                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, cola);
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null,"Cantidad de nodos que tiene la lista: "+ contador_de_lista);
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Cantidad de nodos que tiene la lista: "+contador_De_arbol);
                    break;
                case 10:

                    JOptionPane.showMessageDialog(null, "La profundidad del arbol es: "+a.profundidad(a.raiz));
                    break;
                case 11:
                    TAREA_18 p=null;
                    nc=p;
                    a.ArboltoLista2(a.raiz);
                    break;
                case 12:
                    a.ListaEncadenadaSimpletoArbol();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Inserte una opcion valida");


            }

        } while (op != 0);

    }
}


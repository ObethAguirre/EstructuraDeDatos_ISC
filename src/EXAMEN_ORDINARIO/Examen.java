package EXAMEN_ORDINARIO;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

public class Examen {
static String mostrar = "";
    //pila
    Stack<String> PILA = new Stack<>();
    LinkedList<String> COLA = new LinkedList<>();


    //ARBOL
    int placa;
    Examen izq, der, raiz = null;
    static int ArbolCount = 0;
    char estatus = 'a';

    public Examen(char estatus, int placa) {
        this.placa = placa;
        this.estatus = estatus;
    }

    public boolean pila() {
        if (!PILA.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //2)	Llegada de un auto a la clase Stack (PILA) con el objeto string.
    public void LlegadaApila() {
        String p = JOptionPane.showInputDialog(null, "Ingrese el numero de placa", "Ingresa Placa a PILA", JOptionPane.QUESTION_MESSAGE);
        PILA.push(p);
    }

    /*
    3)	Sacar un auto de la clase Stack (PILA) buscando la xplaca= placa
    y en el caso que no sea la del tope pasar a la Lista Encadenada Simple en forma de COLA de forma temporal,
    una vez que se encuentre el elemento a sacar de la Lista Encadenada Simple en forma de PILA
    regresar todos los elementos de la Lista Encadenada Simple en forma de COLA a la PILA.
     */

    public void SacarPilapasarCola() {
        if (PILA.isEmpty()) {
            JOptionPane.showMessageDialog(null, "En la PILA no hay nada", "PILA VACIA", JOptionPane.WARNING_MESSAGE);
        } else {

            String mostrarPlacas = "";
            for (int i = 0; i < PILA.size(); i++) {
                mostrarPlacas += PILA.get(i) + "\n";
            }

            String sacar = JOptionPane.showInputDialog(null, "Autos estacionados: \n" + mostrarPlacas + "\nIngresa una placa.", "BAJA DEL VEHICULO", JOptionPane.QUESTION_MESSAGE);
            //Recordar que .trim() es para eliminar espacios innecesarios
            sacar = sacar.trim();

            if (PILA.contains(sacar)) {
                while (!PILA.peek().equalsIgnoreCase(sacar)) {
                    COLA.add(PILA.pop());
                }
                JOptionPane.showMessageDialog(null, "El auto" + PILA.pop() + "ha salido", "Saliendo de Pila", JOptionPane.PLAIN_MESSAGE);

                //Ahora regresar de cola a pila
                while (!COLA.isEmpty()) {
                    PILA.push(COLA.pollFirst());
                }
            } else {
                JOptionPane.showMessageDialog(null, "La placa [" + sacar + "] no se ha encontrado.");
            }
        }
    }

    public void imprimirPila() {
        if (PILA.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El estacionamiento temporal esta vacio", "ESTACIONAMIENTO TEMPORAL", JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrarPlacas = "";
            for (int i = 0; i < PILA.size(); i++) {
                mostrarPlacas += PILA.get(i) + "\n";
            }
            JOptionPane.showMessageDialog(null, "Autos en el estacionamiento temporal : \n" + mostrarPlacas);
        }
    }

    public void tamañoPila() {
        JOptionPane.showMessageDialog(null, "Hay " + PILA.size() + " carro(s).");
    }

    /*
    5)	Alta de elemento al Arbol Binario de manera que los menores se carguen a la izquierda
    y los mayores a la derecha.
     */


    public void InsertarArbol() {
        //INSERTAMOS EN ARBOL
        ArbolCount++;
        int placa = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte la placa"));
        Examen nodo_nuevo = new Examen('a', placa);

        if (raiz == null) {
            raiz = nodo_nuevo;
        } else {
            Examen auxiliar = raiz;
            Examen padre;
            while (true) {
                padre = auxiliar;
                //MIENTRAS MATRICULA QUE INGRESEMOS SEA MENOR A LA QUE TENEMOS DENTRO
                //ENTONCES LA MANDAMOS A LA IZQUIERDA - PROERDER
                if (placa< auxiliar.placa) {
                    auxiliar = auxiliar.izq;
                    if (auxiliar == null) {
                        padre.izq = nodo_nuevo;
                        return;
                    }
                } else {
                    //EN CASO DE QUE SEA MAYOR LO MANDAMOS A LA DERECHA EN UN NODO
                    auxiliar = auxiliar.der;
                    if (auxiliar == null) {
                        padre.der = nodo_nuevo;
                        return;
                    }
                }
            }
        }
    }

    //6)	Recorridos de Arbol Binario:
    public void order(Examen n) {
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
    public void PREORDER(Examen n) {
        if (n != null && n.estatus != 'b') {
            mostrar = mostrar + "Placa : " + n.placa+"\n";
            PREORDER(n.izq);
            PREORDER(n.der);
        }
        if (n != null && n.estatus == 'b') {
            PREORDER(n.izq);
            PREORDER(n.der);
        }
    }

    public Examen() {
    }

    //INORDER
    public void INORDER(Examen n) {
        if (n != null && n.estatus != 'b') {
            INORDER(n.izq);
            mostrar = mostrar + "Placa: " + n.placa + "\n";
            INORDER(n.der);
        }
        if (n != null && n.estatus == 'b') {
            INORDER(n.izq);
            INORDER(n.der);
        }
    }

    //POSTORDER
    public void post_orden(Examen n) {
        if (n != null && n.estatus != 'b') {
            post_orden(n.izq);
            post_orden(n.der);
            mostrar = mostrar + "Placa: " + n.placa+"\n";
        }
        if (n != null && n.estatus == 'b') {
            post_orden(n.izq);
            post_orden(n.der);
        }
    }

    //Eliminar Nodo
    public Examen obtenerNodoReemplazo(Examen Reemplazo) {
        Examen reemplazarPadre = Reemplazo;
        Examen reemplazo = Reemplazo;
        Examen aux = Reemplazo.der;
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
        int placaEliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Placa a Eliminar : "));
        Examen aux = raiz, padre = raiz;
        Boolean es_izq = true;
        while (aux.placa != placaEliminar) {
            padre = aux;
            if (placaEliminar < aux.placa) {
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
            Examen reemplazo = obtenerNodoReemplazo(aux);
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

    public void ImprimirCola() {
        if (!COLA.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia.", "IMPRIMIR TODOS LOS ELEMENTOS",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrar = "";
            mostrar = COLA + "\n";
            JOptionPane.showMessageDialog(null, "Contenido : " + mostrar, "IMPRIMIR TODOS LOS ELEMENTOS",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void ImprimirPrimerInsertadoCOLA() {
        if (!COLA.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia.", "IMPRIMIR PRIMER ELEMENTO INSERTADO",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Primer elemento de la cola[ " + COLA.getFirst() + " ].",
                    "IMPRIMIR PRIMER ELEMENTO INSERTADO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void ImprimirUltimoInsertadoCOLA() {
        if (!COLA.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia.", "IMPRIMIR ULTIMO ELEMENTO INSERTADO",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Utimo elemento de la cola [ " + COLA.getLast() + " ].",
                    "IMPRIMIR ULTIMO ELEMENTO INSERTADO", JOptionPane.INFORMATION_MESSAGE);
        }
    }



    /*
 9)	Pasar el recorrido Inorder del Arbol Binario a una Lista Encadenada Simple en forma de COLA
 ( tomar en cuenta que el objeto del árbol es int y el de la Lista en forma de COLA es string)
  */
    public void pasar_De_arbol_a_cola(Examen n) {
        String mostrar="";
        if (n != null && n.estatus != 'b') {
            pasar_De_arbol_a_cola(n.izq);
      COLA.add(Integer.toString(n.placa));
            pasar_De_arbol_a_cola(n.der);
        }
        if (n != null && n.estatus == 'b') {
            pasar_De_arbol_a_cola(n.izq);
            pasar_De_arbol_a_cola(n.der);
        }
    }
    public void cantidadNodos() {
        JOptionPane.showMessageDialog(null, "Cantidad de nodos que ahi: " + ArbolCount);
    }

    public static void main(String[] args) {
        int opcion;
        Examen arbol = new Examen();
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1)\tObeth Rigoberto Aguirre Garcia\nMatricula:21291509\n" +
                    "2)\tLlegada de un auto a la clase Stack (PILA) con el objeto string.\n" +
                    "3)\tSacar un auto de la clase Stack (PILA)  \n" +
                    "4)\tImprimir la Pila clase Stack\n" +
                    "5)\tAlta de elemento al Arbol Binario\n" +
                    "6)\tRecorridos de Arbol Binario:\n" +
                    "a.\tPreorder\n" +
                    "b.\tInorder\n" +
                    "c.\tPostorder\n" +
                    "7)\tEliminar un nodo del Arbol Binario buscándolo por dato=X.\n" +
                    "8)\tContar el número de nodos activos del árbol binario.\n" +
                    "9)\tPasar el recorrido Inorder del Arbol Binario a una Lista Encadenada Simple en forma de COLA\n" +
                    "10)\tImprimir la Lista Encadenada Simple en forma de COLA.\n" +
                    "11)\tImprimir el primer y el último elemento insertado en la Lista Encadenada Simple en forma COLA.\n" +
                    "12)\tIndicar el tamaño de la clase Stack (PILA).\n"));
            switch (opcion) {
                case 2:
                    arbol.LlegadaApila();
                    break;
                case 3:
                    arbol.SacarPilapasarCola();
                    break;
                case 4:
                    arbol.imprimirPila();
                    break;
                case 5:
                    arbol.InsertarArbol();
                    break;
                case 6:
                     mostrar="Preorden\n";
                     arbol.PREORDER(arbol.raiz);
                    JOptionPane.showMessageDialog(null,mostrar);
                    mostrar="Inorder\n";
                    arbol.INORDER(arbol.raiz);
                    JOptionPane.showMessageDialog(null,mostrar);
                    mostrar="Postorder\n";
                    arbol.post_orden(arbol.raiz);
                    JOptionPane.showMessageDialog(null,mostrar);
                    break;
                case 7:
                    arbol.EliminarNodo();
                    break;
                case 8:
                    arbol.cantidadNodos();
                    break;
                case 9:
                    arbol.pasar_De_arbol_a_cola(arbol.raiz);
                    break;
                case 10:
                    arbol.ImprimirCola();
                    break;
                case 11:
                    JOptionPane.showMessageDialog(null, "Ultimo elemento COLA");
                    arbol.COLA.getLast() ;
                    JOptionPane.showMessageDialog(null, "Primer elemento COLA");
                    arbol.COLA.getFirst();
                    break;
                case 12:
                    arbol.tamañoPila();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Inserte una opcion valida");
            }
        }while (opcion != 0);
    }
    }



package SEGUNDO_PARCIAL_PRACTICO;

import javax.swing.*;

/*
NOMBRE: OBETH RIGOBERTO AGUIRRE GARCIA
MATRICULA: 21291509
TIPO DE EXAMÉN: IMPAR

LISTO -- 1)	Crear un árbol binario nulo, la lista encadenada simple (linkedlist) y la lista encadenada simple circular (clase nodoles).

LISTO -- 2)	Insertar un dato en el Arbol Binario, cargando a la izquierda los menores y a la derecha los mayores, por el campo de numart.

LISTO -- 3)	Eliminar lógicamente un nodo del Arbol Binario buscándolo por numart= X.

4)	Copiar los datos del Arbol Binario basándose en el recorrido Inorder, a la lista encadenada simple circular clase nodoles
    de manera que en la lista encadenada simple circular el primer nodo sea el menor por el campo de numart y así
    sucesivamente hasta dejar en el último nodo el mayor de numart. (manejar la les clase nodo como COLA).

LISTO -- 5)	Recorridos de Arbol Binario que imprima los campos de : numart,nomart, existencia; siempre y cuando el nodo no este dado de baja lógica.
    o	Preorder
    o	Inorder
    o	Postorder

LISTO -- 6)	Consultar un nodo del Arbol Binario buscándolo por numart=X.

LISTO -- 7)	Contar el número de nodos activos del árbol binario.

LISTO -- 8)	Encontrar la profundidad del árbol binario.

9)	Copiar los datos del árbol binario a la otra  Lista Encadenada Simple (linkedlist) manejando la lista tipo PILA,
    siendo el elemento del tope el mayor de numart y el último el menor de numart. Basarse en el recorrido inorder.

10)	Imprimir el contenido de la Lista Encadenada Simple Circular clase nodo con todos los campos.

11)	Imprimir el contenido de la Lista Encadenada Simple de linkedlist.

 */

public class Examen {

    static class ArbolBinario {
        NodoAB raiz;
        int contador = 0;
        public ArbolBinario() {
           this.raiz=null;
        }

        //2)
        public void insertar(int numart, String nomart, int existencia) {
            contador ++;
            NodoAB nuevoNodo = new NodoAB(numart, nomart, existencia);
            if (this.raiz == null) {
                this.raiz = nuevoNodo;
            } else {
                NodoAB actual = this.raiz;
                NodoAB padre;
                while (true) {
                    padre = actual;
                    if (numart < actual.numart) {
                        actual = actual.izq;
                        if (actual == null) {
                            padre.izq = nuevoNodo;
                            return;
                        }
                    } else {
                        actual = actual.der;
                        if (actual == null) {
                            padre.der = nuevoNodo;
                            return;
                        }
                    }
                }
            }
        }

        //3)
        public void eliminar_De_manera_logica(NodoAB n,int numart) {

            String com = "";
            if (n != null) {
                if (n.numart == numart) {
                    n.estatus = 'B';
                    contador --;
                    return;
                }
                eliminar_De_manera_logica(n.izq, numart);
                com = com + "La numero articulo: " + n.numart + " Nombre: " + n.nomart + "Existencia:" + n.existencia + "\n";
                eliminar_De_manera_logica(n.der, numart);
            }
        }

        public void orden(NodoAB n) {
            if (n != null && n.estatus != 'A') {

                orden(n.izq);
                orden(n.der);
            }
            if (n != null && n.estatus == 'A') {
                orden(n.izq);
                orden(n.der);
            }
        }

        public void preorder() {
            preorderRec(raiz);
        }

        private void preorderRec(NodoAB raiz) {
            if (raiz != null) {
                if (raiz.estatus != 'A') {
                    System.out.println(raiz.numart + ", " + raiz.nomart + ", " + raiz.existencia);
                }
                preorderRec(raiz.izq);
                preorderRec(raiz.der);
            }
        }

        public void postorder() {
            postorderRec(raiz);
        }

        private void postorderRec(NodoAB raiz) {
            if (raiz != null) {
                postorderRec(raiz.izq);
                postorderRec(raiz.der);
                if (raiz.estatus != 'A') {
                    System.out.println(raiz.numart + ", " + raiz.nomart + ", " + raiz.existencia);
                }
            }
        }

            public int profundidad(NodoAB nodo) {
                if (nodo == null) {
                    return 0;
                } else {
                    int profundidadIzquierda = profundidad(nodo.izq);
                    int profundidadDerecha = profundidad(nodo.der);
                    return 1 + Math.max(profundidadIzquierda, profundidadDerecha);
                }
            }

        public void cantidad_de_nodos() {
            JOptionPane.showMessageDialog(null, "Cantidad de nodos que ahi: " + contador);
        }

        public void buscar(int numart) {
            NodoAB actual = raiz;
            boolean encontrado = false;
            while (actual != null && !encontrado) {
                if (actual.numart == numart) {
                    encontrado = true;
                } else if (numart < actual.numart) {
                    actual = actual.izq;
                } else {
                    actual = actual.der;
                }
            }
            if (encontrado) {
                System.out.println("Nodo encontrado");
            } else {
                System.out.println("Nodo no encontrado");
            }
        }
    }

    class Lista{
        int contador_de_lista = 0;
        NodoLes nc;
        NodoLes anterior;
        NodoLes temp;
        public void insertar_en_lista() {
            int numart = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de articulo:", "ENTRADA", JOptionPane.QUESTION_MESSAGE));
            String nomart = JOptionPane.showInputDialog(null, "Inserte el nombre", "ENTRADA", JOptionPane.QUESTION_MESSAGE);
            int existencia = Integer.parseInt(JOptionPane.showInputDialog(null, "Existencia:", "ENTRADA", JOptionPane.QUESTION_MESSAGE));
            NodoLes nodo_nuevo = new NodoLes(numart,nomart,existencia);

            if (nc == null) {
                nc = nodo_nuevo;
                nc.next = nc;


            }
            temp = nc.next;
            anterior = nc;
            while ((temp != nc) && (temp.numart < nodo_nuevo.numart)) {
                anterior = temp;
                temp = temp.next;

            }
            contador_de_lista++;
            nodo_nuevo.next = anterior.next;
            anterior.next = nodo_nuevo;


        }
    }

    public static void main(String[] args) {
        Examen a = new Examen();
        ArbolBinario b = new ArbolBinario();
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "OBETH RIGOBERTO AGUIRRE GARCIA \nInserte una opcion:\n" +
                    "0.Salir del programa\n" +
                    "1.Insertar en Arbol\n" +
                    "2.Eliminar Logicamente del Arbol\n" +
                    "3.Copiar de Arbol a Lista \n" +
                    "4.In-order\n" +
                    "5.Post-Orden\n" +
                    "6.Pre-Orden\n" +
                    "7.Consultar del Arbol buscando\n" +
                    "8.Numero de nodos activoa\n" +
                    "9.Profundidad del arbol\n"+
                    "10.De Arbol a Binario\n"+
                    "11.-Imprimir LES\n"+
                    "12. Imprimir LinkedList\n"));
            switch (op) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;
                case 1:
                    int numart = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de articulo:", "ENTRADA", JOptionPane.QUESTION_MESSAGE));
                    String nomart = JOptionPane.showInputDialog(null, "Inserte el nombre", "ENTRADA", JOptionPane.QUESTION_MESSAGE);
                    int existencia = Integer.parseInt(JOptionPane.showInputDialog(null, "Existencia:", "ENTRADA", JOptionPane.QUESTION_MESSAGE));
                    b.insertar(numart,nomart,existencia);
                    break;
                case 2:
                    int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de articulo:", "ENTRADA", JOptionPane.QUESTION_MESSAGE));
                    b.eliminar_De_manera_logica(b.raiz,n);
                    break;
                case 3:
                    //no lo entendi
                    break;
                case 4:
                    b.orden(b.raiz);
                    break;
                case 5:
                    b.postorder();
                    break;
                case 6:
                    b.preorder();
                    break;
                case 7:
                    int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de articulo:", "ENTRADA", JOptionPane.QUESTION_MESSAGE));
                    b.buscar(num);
                    break;
                case 8:
                    b.cantidad_de_nodos();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "La profundidad del arbol es: "+b.profundidad(b.raiz));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Inserte una opcion valida");


            }

        } while (op != 0);

    }
}



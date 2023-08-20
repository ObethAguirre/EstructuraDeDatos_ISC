package p;
import java.util.*;
import javax.swing.*;

    public class Parcial_2 {
        static LinkedList <Integer> Pila = new LinkedList(); //Declaración LinkedList forma PILA

    public static class NodoArbol{    //Constructor Arbol
        int numart;
        String nomart;
        NodoArbol Rchild;
        NodoArbol Lchild;

        public NodoArbol(int d, String n){
            this.numart = d;
            this.nomart = n;
            this.Lchild = null;
            this.Rchild = null;
        }
    }

    //Variables para clase Arbol
      static int tamaño, altura;
      public static NodoArbol raiz, padre;

    public static class NodoLista{ //Constructor Lista DEC
        NodoLista next, prev = null;
        int numEmp;
        String nombre;

        public NodoLista (int a, String e){
          this.numEmp = a;
          this.nombre = e;
        }
    }

         //Variables Lista
        public static NodoLista inicio, ultimo = null;
        public static NodoLista ant, temp, ndata;
        public static int size = 0;

       public static void initialize(){
           JOptionPane.showMessageDialog(null, "¡Las estructuras de ÁRBOL, LDEC y PILA se han inicializado correctamente!");
       }

       //Insertar a LinkedList
       public static void insertLinkedList(int a){
           Pila.add(a);
           JOptionPane.showMessageDialog(null, "¡Se ha insertado correctamente " + a + "!");
       }


       //Eliminar dato LinkedList
       public static void deleteLinkedList(){
           JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente " + Pila.getLast());
           Pila.removeLast();
       }


      //Insertar a Arbol
        public static void insertarNodo(int d, String nom){
            NodoArbol nuevo = new NodoArbol(d, nom);
            NodoArbol aux;
            if (raiz == null){
            raiz = nuevo;
            }else{
             aux = raiz;
            while(true){
            padre=aux;
            if (d<aux.numart){
            aux=aux.Lchild;
            if (aux==null){
            padre.Lchild=nuevo;
            return;
            }
            }else{
            aux=aux.Rchild;
            if(aux==null){
            padre.Rchild=nuevo;
            return;
            }
            }
            }
            }
        }

       //Left - Data -Right
        public static void inOrder(NodoArbol r){
            if(r!=null){
            inOrder(r.Lchild);
                JOptionPane.showMessageDialog(null, "Numero de empleado: " + r.numart + "\nNombre del empleado: " + r.nomart);
            inOrder(r.Rchild);
            }
        }

        //Data - Left - Right
        public static void preOrder(NodoArbol r){
            if(r!=null){
                JOptionPane.showMessageDialog(null, "Numero de empleado: " + r.numart + "\nNombre del empleado: " + r.nomart);
            preOrder(r.Lchild);
            preOrder(r.Rchild);
            }
        }

    //Left - Right - Data
    public static void postOrder(NodoArbol r){
        if(r!=null){
                postOrder(r.Lchild);
                postOrder(r.Rchild);
                JOptionPane.showMessageDialog(null, "Numero de empleado: " + r.numart + "\nNombre del empleado: " + r.nomart);
        }
    }

    //Eliminar Nodo de Árbol
    public static boolean Eliminar(int d){
        NodoArbol aux = raiz;
        padre = raiz;
        boolean esHijoIzq = true;

        while(aux.numart !=d){
            padre=aux;
            if(d<aux.numart){
                esHijoIzq = true;
                aux=aux.Lchild;
            }
            else{
                esHijoIzq = false;
                aux=aux.Rchild;
            }
            if(aux==null){
                return false;
            }
        } //Fin Ciclo
        if(aux.Lchild == null && aux.Rchild == null){
            if(aux==raiz){
                raiz=null;
            }
            else if(esHijoIzq){
                padre.Lchild=null;
            }
            else{
                padre.Rchild=null;
            }
        }
        else if(aux.Rchild==null){
            if(aux==raiz){
                raiz=aux.Lchild;
            }
            else if(esHijoIzq){
                padre.Lchild = aux.Lchild;
            }
            else{
                padre.Rchild = aux.Lchild;
            }
        }
        else if(aux.Lchild==null){
            if(aux==raiz){
                raiz=aux.Rchild;
            }
            else if(esHijoIzq){
                padre.Lchild = aux.Rchild;
            }
            else{
                padre.Rchild = aux.Lchild;
            }
        }
        else{
            NodoArbol reemplazo = ObtenerNodoReemplazo(aux);
            if(aux==raiz){
                raiz=reemplazo;
            }
            else if(esHijoIzq){
                padre.Lchild=reemplazo;
            }
            else{
                padre.Rchild=reemplazo;
            }
            reemplazo.Lchild=aux.Lchild;
        }
        JOptionPane.showMessageDialog(null, "Se eliminó satisfactoriamente a: " + "\nNúmero de Empleado: " + aux.numart + "\nNombre del Empleado: " + aux.nomart);
        return true;
    }

    //En caso de reemplazar
    public static NodoArbol ObtenerNodoReemplazo(NodoArbol nodoReemp){
        NodoArbol reempPadre = nodoReemp;
        NodoArbol reemplazo = nodoReemp;
        NodoArbol aux = nodoReemp.Rchild;
        while(aux!=null){
            reempPadre = reemplazo;
            reemplazo = aux;
            aux=aux.Lchild;
        }
        if(reemplazo!=nodoReemp.Rchild){
            reempPadre.Lchild = reemplazo.Rchild;
            reemplazo.Lchild = nodoReemp.Rchild;
        }
        JOptionPane.showMessageDialog(null, "¡Nodo reemplazado satisfactoriamente!");
        return reemplazo;
    }

    //Nodos Activos
    public static int Size(NodoArbol r){
        if(r!=null){
            Size(r.Lchild);
            tamaño++;
               Size(r.Rchild);
        }
        return tamaño;
    }

    //Profundidad
    public static int retornarAltura(){
        altura=0;
       retornarAltura(raiz,1);
       return altura;
    }

    private static void retornarAltura(NodoArbol r, int nivel){
        if(r!=null){
            retornarAltura(r.Lchild, nivel+1);
            if(nivel>altura){
                altura=nivel;
            }
                retornarAltura(r.Rchild, nivel+1);
        }
    }


    //Insertar en Lista
    public static void insertarLista(int d, String s){

        ndata = new NodoLista(d, s);
        if(inicio == null){
          inicio = new NodoLista(0,  " ");
          inicio.next = inicio;
          inicio.prev = ultimo;
          ultimo = inicio;
            }
              temp=inicio.next;
              ant = inicio; 

          while((temp != inicio) && (temp.numEmp<ndata.numEmp)){
            ant = temp;
            temp = temp.next;
        }

                ultimo.next = ndata;
                ndata.next = inicio;
                ndata.prev = ultimo;
                ultimo = ndata;

            size++;
                JOptionPane.showMessageDialog(null, "Datos dados de alta: " + "\nNúmero de Empleado: " + ndata.numEmp + "\nNombre de empleado: " + ndata.nombre); 
    }

    //Arbol a Lista LDEC
    public static void Arbol_to_LDEC(NodoArbol r){ 
        //Arbol a LDEC
        if(r!=null){
            Arbol_to_LDEC(r.Lchild);
                insertarLista(r.numart, r.nomart);
                Arbol_to_LDEC(r.Rchild);
            }
        }

    //Arbol a Linked List
    public static LinkedList Arbol_to_LinkedList(NodoArbol r){
        //Arbol LinkedList
        if(r!=null){
           Arbol_to_LinkedList(r.Lchild);
                Pila.add(r.numart);
            Arbol_to_LinkedList(r.Rchild);
        }
        return Pila;
    }

    //Imprimir LinkedList Pila
      public static void printLL(){
                JOptionPane.showMessageDialog(null, Pila);
    }

      //Imprimir LDEC
            public static void PrintLDEC(){
            temp = inicio.next;
          while(temp != inicio){
                JOptionPane.showMessageDialog(null, "\nNúmero de empleado: " + temp.numEmp + "\nNombre del Empleado: " + temp.nombre);
                temp = temp.next;
            }
        }






    public static void main(String[] args) {
            //Menú
            int n1;
            String n2;
            int operador = 0;
            JOptionPane.showMessageDialog(null, "Examen Parcial Práctico 2 ");

            do{
                operador = Integer.parseInt(JOptionPane.showInputDialog(null, "0.- Salir\n"
                        + "1.- Inicializar Estructuras de Datos (Árbol, LDEC y Pila).\n"
                        + "2.- Insertar dato en Pila (LinkedList).\n"
                        + "3.- Eliminar dato en Pila (LinkedList).\n"
                        + "4.- Insertar datos en el Árbol.\n"
                        + "5.- Imprimir Árbol en PreOrder.\n"
                        + "6.- Imprimir Árbol en InOrder.\n"
                        + "7.- Imprimir Árbol en PostOrder.\n"
                        + "8.- Eliminar nodo del Árbol.\n"
                        + "9.- Nodos activos en el Árbol.\n"
                        + "10.- Profundidad del Árbol.\n"
                        + "11.- Insertar datos del Árbol hacia la LDEC.\n"
                        + "12.- Imprimir Pila (LinkedList).\n"
                        + "13.- Imprimir LDEC.\n"));            

                switch(operador){
                    case 0:
                        System.exit(0);
                        break;

                    case 1:
                        initialize();
                        break;

                    case 2:
                        n1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato entero a agregar a la Pila: "));
                        insertLinkedList(n1);
                        break;

                    case 3:
                        deleteLinkedList();
                        break;

                    case 4:
                        n1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de empleado a agregar al Árbol: "));
                        n2 = JOptionPane.showInputDialog("Ingrese el nombre del empleado a agregar al Árbol: ");
                        insertarNodo(n1, n2);
                        JOptionPane.showMessageDialog(null, "Se agregó correctamente a: \n" + "Número de Empleado: " + n1 + "\nNombre de Empleado: " + n2);
                        break;

                    case 5:
                        JOptionPane.showMessageDialog(null, "A continuación se imprimirán los datos del Árbol de forma PreOrder.");
                        preOrder(raiz);
                        break;

                         case 6:
                        JOptionPane.showMessageDialog(null, "A continuación se imprimirán los datos del Árbol de forma InOrder.");
                        inOrder(raiz);
                        break;

                        case 7:
                        JOptionPane.showMessageDialog(null, "A continuación se imprimirán los datos del Árbol de forma PostOrder.");
                        postOrder(raiz);
                        break;

                        case 8:
                            n1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de empleado a borrar en el Árbol."));
                            Eliminar(n1);
                            break;

                        case 9:
                            JOptionPane.showMessageDialog(null, "El número de nodos activos en el árbol es de: " + Size(raiz));
                            break;

                        case 10:
                            JOptionPane.showMessageDialog(null, "La profundidad en el árbol es de: " + retornarAltura());
                            break;

                        case 11:
                            Arbol_to_LDEC(raiz);
                            break;

                        case 12:
                              printLL();
                            break;

                        case 13:
                            PrintLDEC();
                            break;

                                        default:
                        JOptionPane.showMessageDialog(null,"Opción Inválida");
                        break;
            }
           }while (operador!=0);
    }
}

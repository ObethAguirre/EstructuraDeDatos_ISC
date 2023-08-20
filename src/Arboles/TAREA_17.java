package Arboles;

/*
Desarrollar un programa en JAVA que utilice la estructura de datos árbol binario con la clase:
class nodob {
     nodob izq;
     char estatus;
     int matricula;
     string nombre;
     nodob der;
}
Desarrollar el constructor de la clase nodob y los métodos de:
LISTO• Alta de elemento en el árbol binario, ordenado de manera que los menores queden a la izquierda y los mayores a la derecha,
    de acuerdo al dato de matricula.
LISTO• Baja de un elemento del árbol binario buscando el nodo con matricula =X, marcando solo el estatus a "B". BAJA LÓGICA.
• Baja de un elemento del árbol binario de manera que se elimine el nodo buscando por matricula=X, de manera que se suba a ese lugar que ocupaba el nodo borrado, el lemento que este a la derecha mas a la izquierda ó a la izquierda más a la derecha, manteniendo el ordenamiento de menor a mayor. BAJA FISICA.
• Recorrido PREORDER (DLR) Data – Left – Right
• Recorrido INORDER (LDR) Left – Data – Right
• Recorrido POSTORDER (LRD) Left – Rigth- Data
• Obtener la profundidad del arbol.
• Mostrar el nodo raíz del árbol binario con todos sus datos.
• Cantidad de nodos que tiene el árbol binario


 */
public class TAREA_17 {

    NodoArbol raiz, padre;
    int tam = 0;

    public TAREA_17() {
        raiz = null;
    }

    public void ingresar(int matricula, String nombre) {
        tam++;
        NodoArbol nuevo = new NodoArbol(matricula, nombre);
        NodoArbol aux;
        /*
        SI NO EXISTE UNA RAIZ
        ENTONCES CREAMOS NUEVO NODO PARA QUE SEA RAIZ
         */
        if (raiz == null) {
            raiz = nuevo;
        } else {
            /*
            EN CASO DE QUE EXISTA
             */
            aux = raiz;
            while (true) {
                padre = aux;
                //MIENTRAS MATRICULA QUE INGRESEMOS SEA MENOR A LA QUE TENEMOS DENTRO
                //ENTONCES LA MANDAMOS A LA IZQUIERDA - PROERDER
                if (matricula < aux.matricula) {
                    //MANDAMOS A LA IZQ
                    aux = aux.izq;
                    if (aux == null) {
                        padre.izq = nuevo;
                        return;
                    }
                } else {
                    //EN CASO DE QUE SEA MAYOR LO MANDAMOS A LA DERECHA
                    aux = aux.der;
                    if (aux == null) {
                        padre.der = nuevo;
                        return;
                    }
                }
            }
        }
    }

    public void bajaLogica(NodoArbol n, int matricula){
        String guardar = "";
        if (n != null){
            if (n.matricula == matricula){
                n.estatus ='B';
                tam--;
                return;
            }
            bajaLogica(n.izq, matricula);
            guardar += "Matricula : "+n.matricula + "Nombre : "+n.nombre + "\n";
            bajaLogica(n.der, matricula);
        }
    }


}



package LISTAS_SIMPLES;

import javax.swing.*;

/*
TIPO PILA
Efectuar un programa en JAVA que maneje una LISTA ENCADENADA SIMPLE (LES) usando memoria dinámica CON OBJETOS PUNTERO  con la clase NODO
CON LOS DATOS DE INT NUMEMP, STRING NOMBRE, INT DEPTO; FLOAT SUELDO; NODO  NEXT;
USAR LOS APUNTADORES TOP,TEMP,ANT;
    Y los métodos de:
	1. Crear la LES
	2. Verificar si esta vacía.                             --LISTO
	3. Insertar un elemento.                                --LISTO
	4. Borrar un elemento.                                  --LISTO
	5. Imprimir todos los elementos de PILA-LES             --LISTO
	6. Imprimir los nodos con el DEPTO igual a X            --LISTO
	7. Imprimir el ÚLTIMO elemento de la  PILA-LES          --LISTO
	8. Imprimir el tamaño (cantidad de nodos)  de la LES    --LISTO
	9. Imprimir los nodos con SUELDO >=XSAL                 --LISTO
	10. Método de invertir la PILA-LES                      --LISTO

 */
public class TAREA_11 {
    NodoEmpleados ultimoValor;
    int tam;

    JOptionPane panel = new JOptionPane();

    public TAREA_11() {
        ultimoValor = null;
        tam = 0;
    }

    public boolean pilaVacia() {
        //Si es asi return true de lo contrario false
        return ultimoValor == null;
    }

    public void insertarNodo(int numemp, String nombre, int depto, float sueldo) {
        NodoEmpleados nuevo_nodo = new NodoEmpleados(numemp, nombre, depto, sueldo);
        //Ahora nuestro apuntados se mueve al siguiente nodo dejando este detras del nuevo
        nuevo_nodo.next = ultimoValor;
        //Ahora nuestro nodo guarda la informacion
        ultimoValor = nuevo_nodo;
        tam++;
    }

    public void eliminarNodo() {
        if (pilaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila esta vacia", "Eliminar Nodo", JOptionPane.WARNING_MESSAGE);
        } else {
            //Mostramos el nodo a eliminar
            JOptionPane.showMessageDialog(null, "El nodo con los siguientes valores se ha elimnado :" + "\nNumero de departamento : " + ultimoValor.depto + "\nNumero de empleado : " + ultimoValor.numemp +
                    "\n Nombre : " + ultimoValor.nombre + "\n Sueldo :" + ultimoValor.sueldo, "Eliminar Nodo", JOptionPane.WARNING_MESSAGE);
            //Ahora eliminamos el ultimo valor que esta ingresado, se recorrerian los valores
            ultimoValor = ultimoValor.next;
            //disminuimos el tamaño
            tam--;
        }
    }

    public void mostrarUltimo() {
        if (pilaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila esta vacia", "Ultimo Nodo", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Numero de departamento : " + ultimoValor.depto + "\nNumero de empleado : " + ultimoValor.numemp +
                    "\n Nombre : " + ultimoValor.nombre + "\n Sueldo :" + ultimoValor.sueldo, "Ultimo Nodo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void tamano() {
        if (tam == 0) {
            JOptionPane.showMessageDialog(null, "La pila esta vacia", "Tamaño", JOptionPane.WARNING_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "El tamaño es : " + tam, "Tamaño", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostraPila() {
        if (pilaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila esta vacia", "Pila", JOptionPane.WARNING_MESSAGE);
        } else {
            NodoEmpleados imprimir = ultimoValor;
            String lista = "";

            while (imprimir != null) {
                lista += "-------------------------------" + "\nNumero de departamento : " + imprimir.depto + "\nNumero de empleado : " + imprimir.numemp +
                        "\nNombre : " + imprimir.nombre + "\nSueldo :" + imprimir.sueldo + "\n -------------------------------";
                imprimir = imprimir.next;
            }
            JOptionPane.showMessageDialog(null, lista, "Mostrar Pila", JOptionPane.INFORMATION_MESSAGE);
            lista = "";
        }
    }

    public void imprimirDEPTOIgualX() {
        if (pilaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila esta vacia", "Imprimir por DEPTO", JOptionPane.WARNING_MESSAGE);
        } else {

            int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserta un numero de departamento :", "Imprimir por DEPTO", JOptionPane.QUESTION_MESSAGE));
            NodoEmpleados temp = ultimoValor;
            String lista = "";

            while (temp != null) {
                if (x == temp.depto) {
                    lista += "-------------------------------" + "\nNumero de departamento : " + temp.depto + "\nNumero de empleado : " + temp.numemp +
                            "\nNombre : " + temp.nombre + "\nSueldo :" + temp.sueldo + "\n -------------------------------";
                }
                temp = temp.next;
            }
            JOptionPane.showMessageDialog(null, lista, "Imprimir por DEPTO", JOptionPane.INFORMATION_MESSAGE);
            lista = "";
        }
    }

    public void imprimirSUELDOImayoresigualSAL() {
        if (pilaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila esta vacia", "Sueldo >= SAL", JOptionPane.WARNING_MESSAGE);
        } else {
            float SAL = Float.parseFloat(JOptionPane.showInputDialog(null, "Inserta un sueldo :", "Sueldo >= SAL", JOptionPane.QUESTION_MESSAGE));

            NodoEmpleados temp = ultimoValor;
            String lista = "";

            while (temp != null) {
                if (temp.sueldo >= SAL) {
                    lista += "-------------------------------" +"\nNumero de departamento : " + temp.depto + "\nNumero de empleado : " + temp.numemp +
                            "\nNombre : " + temp.nombre + "\nSueldo :" + temp.sueldo + "\n -------------------------------";
                } else {
                    JOptionPane.showMessageDialog(null, "No hay sueldo mayores a " + SAL, "", JOptionPane.WARNING_MESSAGE);
                }
                temp = temp.next;
            }

            JOptionPane.showMessageDialog(null, lista, "Sueldo >= SAL", JOptionPane.INFORMATION_MESSAGE);
            lista = "";
        }
    }

    public void invertir() {

        if (pilaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila esta vacia", "Invertir", JOptionPane.WARNING_MESSAGE);
        } else {

            NodoEmpleados ant, temp, sig;
            temp = ultimoValor;
            ant = ultimoValor;
            sig = ultimoValor.next;

            while (temp != null) {
                temp = sig.next;
                sig.next = ant;
                if (ant == ultimoValor) {
                    ant.next = null;
                }
                ant = sig;
            }
            ultimoValor = ant;
            JOptionPane.showMessageDialog(null, "Se ha invertido la Pila", "Invertir", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}

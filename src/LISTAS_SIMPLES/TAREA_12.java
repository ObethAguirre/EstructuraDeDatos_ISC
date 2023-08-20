package LISTAS_SIMPLES;

import javax.swing.*;

/*
TIPO COLA
Efectuar un programa en JAVA que maneje una LISTA ENCADENADA SIMPLE (LES) usando memoria dinámica CON OBJETOS PUNTERO  con la clase NODO
CON LOS DATOS DE INT NUMEMP, STRING NOMBRE, INT DEPTO; FLOAT SUELDO; NODO  NEXT;
USAR LOS APUNTADORES INICIO,FIN,TEMP,ANT;
    Y los métodos de:
	1. Crear la LES
	2. Verificar si esta vacía.                                 --LISTO
	3. Insertar un elemento.                                    --LISTO
	4. Borrar un elemento.                                      --LISTO
	5. Imprimir todos los elementos de COLA-LES                 --LISTO
	6. Imprimir los nodos con el DEPTO igual a X                --LISTO
	7. Imprimir el ÚLTIMO elemento de la  COLA-LES              --LISTO
	8. Imprimir el PRIMER elemento de la COLA-LES               --LISTO
	9. Imprimir el tamaño (cantidad de nodos)  de la LES        --LISTO
	10. Imprimir los nodos con SUELDO >=XSAL                    --LISTO
	11. Método de invertir la COLA-LES                          --NO FUNCIONA

 */
public class TAREA_12 {
    NodoEmpleados inicio, ultimo;
    int tam;

    public TAREA_12(){
        ultimo=null;
        inicio=null;
        tam=0;
    }

    public boolean vacia(){
        if (inicio == null){
            return true;
        }else
            return false;
    }

    public void insertar(int numemp, String nombre, int depto, float sueldo){
        NodoEmpleados nuevo_nodo = new NodoEmpleados(numemp,nombre,depto,sueldo);
        nuevo_nodo.next = null;

        if (vacia()){
            inicio = nuevo_nodo;
            ultimo  = nuevo_nodo;
        }else{
            ultimo.next = nuevo_nodo;
            ultimo = nuevo_nodo;
        }
        tam++;
    }

    public void extraer(){
        if (!vacia()){
            NodoEmpleados temp = inicio;
            if (inicio == ultimo){
                inicio = null;
                ultimo = null;
                JOptionPane.showMessageDialog(null, "La cola esta vacia", "Borrar un elemento", JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Se ha extraido el nodo con la siguiente informacion :\n "
                        + "\nNumero de departamento : " + inicio.depto + "\nNumero de empleado : " + inicio.numemp +
                        "\nNombre : " + inicio.nombre + "\nSueldo : " + inicio.sueldo, "Borrar un elemento", JOptionPane.WARNING_MESSAGE);
                inicio = inicio.next;
                tam--;
            }
        }else{
            JOptionPane.showMessageDialog(null, "La cola esta vacia", "Borrar un elemento", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void mostrarCola(){
        if (!vacia()) {
            NodoEmpleados temp = inicio;
            String cola = "";

            while (temp != null){
                cola += "-------------------------------" + "\nNumero de departamento : " + temp.depto + "\nNumero de empleado : " + temp.numemp +
                        "\nNombre : " + temp.nombre + "\nSueldo : " + temp.sueldo + "\n -------------------------------";
                temp = temp.next;
            }
            JOptionPane.showMessageDialog(null, cola, "Mostrar cola", JOptionPane.WARNING_MESSAGE);
            cola="";
        }else{
            JOptionPane.showMessageDialog(null, "La cola esta vacia", "Mostrar cola", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void mostrarUltimo() {
        if (vacia()) {
            JOptionPane.showMessageDialog(null, "La pila esta vacia", "Mostrar ultimo", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Numero de departamento : " + ultimo.depto + "\nNumero de empleado : " + ultimo.numemp +
                    "\nNombre : " + ultimo.nombre + "\nSueldo : " + ultimo.sueldo, "Mostrar ultimo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mostrarPrimero() {
        if (vacia()) {
            JOptionPane.showMessageDialog(null, "La pila esta vacia", "Mostrar primero", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Numero de departamento : " + inicio.depto + "\nNumero de empleado : " + inicio.numemp +
                    "\nNombre : " + inicio.nombre + "\nSueldo : " + inicio.sueldo, "Mostrar primero", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void tamano(){
        if (tam == 0) {
            JOptionPane.showMessageDialog(null, "La pila esta vacia", "Tamaño", JOptionPane.WARNING_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "El tamaño es : " + tam, "Tamaño", JOptionPane.INFORMATION_MESSAGE);
    }

    public void imprimirDEPTOIgualX() {
        if (vacia()) {
            JOptionPane.showMessageDialog(null, "La pila esta vacia", "Imprimir por DEPTO", JOptionPane.WARNING_MESSAGE);
        } else {

            int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserta un numero de departamento :", "Imprimir por DEPTO", JOptionPane.QUESTION_MESSAGE));
            NodoEmpleados temp = inicio;
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
        if (vacia()) {
            JOptionPane.showMessageDialog(null, "La pila esta vacia", "Sueldo >= SAL", JOptionPane.WARNING_MESSAGE);
        } else {
            float SAL = Float.parseFloat(JOptionPane.showInputDialog(null, "Inserta un sueldo :", "Sueldo >= SAL", JOptionPane.QUESTION_MESSAGE));

            NodoEmpleados temp = inicio;
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

        if (vacia()) {
            JOptionPane.showMessageDialog(null, "La pila esta vacia", "Invertir", JOptionPane.WARNING_MESSAGE);
        } else {

            NodoEmpleados ant, temp, sig;
            temp = inicio;
            ant = inicio;
            sig = inicio.next;

            while (temp != null) {
                temp = sig.next;
                sig.next = ant;
                if (ant == inicio) {
                    ant.next = null;
                }
                ant = sig;
            }
            inicio = ant;
            JOptionPane.showMessageDialog(null, "Se ha invertido la Pila", "Invertir", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}


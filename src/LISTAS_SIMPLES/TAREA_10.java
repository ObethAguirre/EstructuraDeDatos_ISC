package LISTAS_SIMPLES;

import javax.swing.*;

/*
Efectuar un programa en JAVA que maneje una LISTA ENCADENADA SIMPLE (LES) usando memoria dinámica CON OBJETOS PUNTERO  con la clase NODO
CON LOS DATOS DE INT NUMEMP, STRING NOMBRE, INT DEPTO; FLOAT SUELDO; NODO  NEXT;
USAR LOS APUNTADORES FIRST,ANT,TEMP,NVONODO
    Y los métodos de:
	1. Crear la LES
	2. Verificar si esta vacia                                                              --LISTO
	3. Insertar un elemento ORDENADO DE MENOR  MAYOR POR DEPTO Y DENTRO EL POR NUEMP        --LISTO
	4. Borrar un elemento BUSCANDODOLO POR EL CAMPO DE NUMEP                                --LISTO
	5. Imprimir todos los elementos de LES                                                  --LISTO
	6. Imprimir los nodos con el DEPTO igual a X                                            --LISTO
	7. Imprimir el primer elemento de la  LES                                               --LISTO
	8. Imprimir el tamaño (cantidad de nodos)  de la LES                                    --LISTO
	9. Imprimir los nodos con SUELDO >=XSAL
	10. Método de invertir la LES
 */
public class TAREA_10 {

    JOptionPane panel = new JOptionPane();
    NodoEmpleados first;

    public TAREA_10(){
        first = null;
    }

    public boolean estaVacia(){
        return first == null;
    }

    public void insertarOrden(int numemp, String nombre, int depto, float sueldo){
        NodoEmpleados nvonodo = new NodoEmpleados(numemp,nombre,depto,sueldo);
        if (estaVacia()){
            // SI ESTA VACIA CREAMOS UN NUEVO NODO
            first = nvonodo;

            // SI ESTA VACIA INSERTAMOS EL NODO CONDICIONANDO SI NUMERO DEPTO ES MENOR QUE EL QUE ESTA YA EN LA LISTA
            //ORDEN : MENOR A MAYOR
        }else if (depto < first.depto || (depto == first.depto && numemp < first.numemp)){
            nvonodo.next = first;
            first = nvonodo;
        }else{
            //SI NO ESTA VACIA
            NodoEmpleados ant = null;
            NodoEmpleados temp = first;
            //MIENTRAS -- QUE INICIO SEA DIFERENTE DE VACIO Y EL DEPTO QUE TENEMOS EN LA LISTA SEA MENOR QUE EL NUEVO DEPTO A INSERTAR
            //ENTONCES ANTERIOR IGUAL INICIO
            // Y INICIO AHORA SERA EL NUEVO NODO QUE INSERTAMOS
            while (temp != null && temp.depto < depto) {
                ant = temp;
                temp = temp.next;
            }
            //FUNCIONA IGUAL QUE EL WHILE DE ARRIBA SOLO QUE AQUI AGREGAMOS UNA CONDICION EN CASO DE QUE EL DEPTO QUE HAY
            // EN LA LISTA SEA IGUAL AL NUEVO DEPTO INSERTADO
            while (temp != null && temp.depto == depto && temp.numemp < numemp) {
                ant = temp;
                temp = temp.next;
            }

            //EN CASO DE QUE EL DEPTO QUE INSERTEMOS SEA MAYOR QUE EL DEPTO QUE YA TENEMOS SOLO LO MANDAMOS AL FINAL
            //NUEVO NODO IGUAL A INICIO
            nvonodo.next = temp;
            //NUEVO NODO IGUAL A INICIO
            ant.next = nvonodo;
        }
    }

    public NodoEmpleados buscar(int numemp) {
        NodoEmpleados temp = first;
        /*
        MIENTRAS INICIO SEA DIFERENTE DE VACIO Y NUMERO DE EMPLEADO SEA DIFERENTE AL NUMERO DE EMPLEADO QUE ESTAMOS BUSCANDO
         */
        while (temp != null && temp.numemp != numemp) {
            //ENTONCES RECORREMOS LA LISTA
            temp = temp.next;
        }

        //HASTA QUE SE CUMPLA AHI ENTONCES SI MOSTRAMOS EL NUMERO QUE BUSCABAMOS
        return temp;
    }

    public void borrar(int numemp) {
        // PRIMERO COMPROBAMOS QUE NO ESTE VACIA
        if (estaVacia()) {
            //SI ESTA VACIA RETORNAMOS NULL
            return;
        }
        // SI NO ESTA VACIA
        NodoEmpleados temp = first;
        NodoEmpleados ant = null;
        /*
        MIENTRAS INCIO  NO SEA VACIO Y NUEMP QUE ESTA EN LA LISTA SEA DIFERENTE AL NUEMP QUE BUSCAMOS
         */
        while (temp != null && temp.numemp != numemp) {
            //ENTONCES ANTERIOR IGUAL A INICIO
            ant = temp;
            //RECORREMOS EL INICIO
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        if (ant == null) {
            first = temp.next;
        } else {
            ant.next = temp.next;
        }
    }

    public void imprimir() {
        NodoEmpleados temp = first;
        //VARIABLE PARA GUARDAR LOS DATOS COMO TEXTO
        String lista="";
        // MIENTRAS  INICIO SEA DIFERENTE DE VACIO
        while (temp != null) {
            //MIENTRAS RECORREMOS EL INICIO GUARSAMOS LOS VALORES DE LOS NODOS EN LA VARIABLE STRING
            lista += "-------------------------------" +"\nNumero de departamento : " + temp.depto + "\nNumero de empleado : " + temp.numemp +
                    "\nNombre : " + temp.nombre + "\nSueldo :" + temp.sueldo + "\n -------------------------------";
            //RECORREMOS EL INICIO HASTA QUE NO QUEDE NINGUN NODO
            temp = temp.next;
        }
        //IMPRIMIMOS LOS DATOS GUARDADOS, LLAMANDO  A LA VARIABLE STRING
        JOptionPane.showMessageDialog(null, lista, "Sueldo >= SAL", JOptionPane.INFORMATION_MESSAGE);
    }

    public void imprimirPorDepto(int depto) {
        NodoEmpleados temp = first;
        String lista="";
        //MIENTRAS INICIO SEA DIFERENTE DE VACIO
        while (temp != null) {
            // SI DEPTO QUE TENEMOS EN LA LISTA ES IGUAL AL DEPTO QUE BUSCAMOS IMPRIMIMOS LOS DATOS DEL NODO
            if (temp.depto == depto) {
                lista += "-------------------------------" +"\nNumero de departamento : " + temp.depto + "\nNumero de empleado : " + temp.numemp +
                        "\nNombre : " + temp.nombre + "\nSueldo :" + temp.sueldo + "\n -------------------------------";
            }
            //RECORREMOS EL INCIO HASTA EL ENCONTRARLO
            temp = temp.next;
        }
        JOptionPane.showMessageDialog(null, lista, "Sueldo >= SAL", JOptionPane.INFORMATION_MESSAGE);
    }

    public void imprimirPrimerElemento() {
        if (estaVacia()) {
            return;
        }
        JOptionPane.showMessageDialog(null,first.numemp + ", " + first.nombre + ", " + first.depto + ", " + first.sueldo);
    }

    public int tamaño() {
        NodoEmpleados temp = first;
        int count = 0;
        //MIENTRAS INICIO SEA DIFERENTE DE VACIO
        while (temp != null) {
            //AUMENTAMOS EL CONTADOR
            count++;
            //RECORREMOS EL INICIO HASTA QUE SEA NULL
            temp = temp.next;
        }
        return count;
    }

    public void imprimirSUELDOImayoresigualSAL() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila esta vacia", "Sueldo >= SAL", JOptionPane.WARNING_MESSAGE);
        } else {
            float SAL = Float.parseFloat(JOptionPane.showInputDialog(null, "Inserta un sueldo :", "Sueldo >= SAL", JOptionPane.QUESTION_MESSAGE));

            NodoEmpleados temp = first;
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

        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila esta vacia", "Invertir", JOptionPane.WARNING_MESSAGE);
        } else {

            NodoEmpleados ant, temp, sig;
            temp = first;
            ant = first;
            sig = first.next;

            while (temp != null) {
                temp = sig.next;
                sig.next = ant;
                if (ant == first) {
                    ant.next = null;
                }
                ant = sig;
            }
            first = ant;
            JOptionPane.showMessageDialog(null, "Se ha invertido la Pila", "Invertir", JOptionPane.INFORMATION_MESSAGE);
        }
    }



    }

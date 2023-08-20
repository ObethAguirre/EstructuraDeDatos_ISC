package LISTAS_SIMPLES;

import javax.swing.*;
/*
ENCADENADA SIMPLE CIRCULAR
Efectuar un programa en JAVA que maneje una LISTA ENCADENADA SIMPLE CIRCULAR (LESC) usando memoria dinámica CON OBJETOS PUNTERO  con la clase NODO
CON LOS DATOS DE INT NUMEMP, STRING NOMBRE, INT DEPTO; FLOAT SUELDO; NODO  NEXT;
USAR LOS APUNTADORES NC,ANT,TEMP,NVONODO

	1. Crear la LESC, inicializando el NC sin datos.                                             LISTO
	2. Verificar si esta vacia                                                                   LISTO
	3. Insertar un elemento ORDENADO DE MENOR  MAYOR POR DEPTO Y DENTRO EL POR NUMEMP            LISTO
	4. Borrar un elemento BUSCANDODOLO POR EL CAMPO DE NUMEMP                                    LISTO
	5. Imprimir todos los elementos de LESC                                                      LISTO
	6. Imprimir los nodos con el DEPTO igual a X                                                 LISTO
	7. Imprimir el primer elemento de la  LESC                                                   LISTO
	8. Imprimir el tamaño (cantidad de nodos)  de la LESC                                        LISTO
	9. Imprimir los nodos con SUELDO >=XSAL                                                      LISTO
    10. Método de invertir la LESC                                                               LISTO
 */
public class TAREA_13 {
    NodoEmpleados prev, ultimo, nc, temp;
    int tam;

    public TAREA_13(){
        prev = null;
        ultimo = null;
        nc = null;
        tam = 0;
    }

    public void insertarInicio(int numemp, String nombre, int depto, float sueldo){
        NodoEmpleados nuevo_nodo = new NodoEmpleados(numemp,nombre,depto,sueldo);
        if (nc == null) {
            nc = new NodoEmpleados(numemp,nombre,depto,sueldo);
            nc.next = nc;
        }
        temp = nc.next;
        prev = nc;
        while ((temp != nc) && (temp.numemp < nuevo_nodo.numemp)) {
            prev = temp;
            temp = temp.next;

        }
        tam++;
        nuevo_nodo.next = prev.next;
        prev.next = nuevo_nodo;

    }

    public void imprimirPrimerElemento(){
        JOptionPane.showMessageDialog(null, "EL primero empleado es :\n" +
                "Numero de empleado :"+nc.next.numemp+"\nSueldo: "+nc.next.sueldo
                +"\nDepartamento: "+nc.next.depto+"\nNombre del empleado: "+nc.next.nombre);
    }


    public void imprimir() {
        NodoEmpleados temp = nc.next;
        String cola = "";

            while (temp != nc) {
                cola += "-------------------------------" + "\nNumero de departamento : " + temp.depto + "\nNumero de empleado : " + temp.numemp +
                        "\nNombre : " + temp.nombre + "\nSueldo : " + temp.sueldo + "\n -------------------------------";
                temp = temp.next;
            }
            JOptionPane.showMessageDialog(null, cola, "Mostrar cola", JOptionPane.PLAIN_MESSAGE);
            cola = "";
        }

    public void imprimirPorDEPTO(){
        String lista="";
        boolean tiene=false;
        int departamento=Integer.parseInt(JOptionPane.showInputDialog(null, "Cual es el departamento que buscara los empleados"));
        NodoEmpleados temporal =nc.next;
        while (temporal!=nc){
            if(temporal.depto==departamento){
                lista=lista+"Numero de empleado: " + temporal.numemp + "\nSueldo: " + temporal.sueldo + "\nDepartamento: " + temporal.depto + "\nNombre: " + temporal.nombre + "\n----------------------------------------------------------------------------------------\n";
                tiene=true;
            }
            temporal=temporal.next;
        }
        if(tiene){
            JOptionPane.showMessageDialog(null, lista);
        }else{
            JOptionPane.showMessageDialog(null, "No existen","ERROR", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void imprimirPorSUELDO(){
        String lista="";
        boolean tiene=false;
        int sueldo=Integer.parseInt(JOptionPane.showInputDialog(null, "Cual es el sueldo que buscas en  los empleados para imprimir igual a mayor a sueldo que ingrese"));
        NodoEmpleados temporal =nc.next;
        while (temporal!=nc){
            if(temporal.sueldo>=sueldo){
                lista=lista+"Numero de empleado: " + temporal.numemp + "\nSueldo: " + temporal.sueldo + "\nDepartamento: " + temporal.depto + "\nNombre: " + temporal.nombre + "\n----------------------------------------------------------------------------------------\n";
                tiene=true;
            }
            temporal=temporal.next;
        }
        if(tiene){
            JOptionPane.showMessageDialog(null, lista);
        }else{
            JOptionPane.showMessageDialog(null, "No existen","ERROR", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void invertir(){
        NodoEmpleados sig=nc.next,anterior=nc,p;
        p=anterior.next;
        while (sig!=nc){
            sig=p.next;
            p.next=anterior;
            anterior=p;
            p=sig;

        }
        nc.next=anterior;


    }

    public boolean vacia(){
        if (nc!=null){
            return true;
        }else{
            return false;
        }
    }

    public void borrar(){
        NodoEmpleados temporal,siguiente;
        temporal=nc.next;
        prev=nc;
        int numero_de_empleado=Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de empleado que vas a borrar", "Borrar empleado", JOptionPane.WARNING_MESSAGE));
        if(temporal==null){
            JOptionPane.showMessageDialog(null, "la lista  esta vacia");
        }else {
            while ((temporal!=nc)&& (temporal.numemp != numero_de_empleado)){
                prev=temporal;
                temporal=temporal.next;
            }
            if(temporal==nc){
                JOptionPane.showMessageDialog(null, "numero de empleado no existe");

            }else {
                prev.next = temporal.next;
                JOptionPane.showMessageDialog(null, "Numero de empleado: " + numero_de_empleado + " fue eliminado");
                tam--;
            }
        }

    }

    public  void tamaño(){
        JOptionPane.showMessageDialog(null, "La cantidad de nodos que contiene la lista son : "+tam);
    }
    }

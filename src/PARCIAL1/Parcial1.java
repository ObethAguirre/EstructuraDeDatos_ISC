package PARCIAL1;

import LISTAS_SIMPLES.NodoEmpleados;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

public class Parcial1 {
    //19010290
    //Fernando Alonso Medellin Facundo
    //Estructura de  Datos
    NodeCola ultimoValor;
    LinkedList<Integer> COLA1 = new LinkedList<>();
    LinkedList<Integer> COLA2 =new LinkedList<>();
    Stack<Integer> PILA = new Stack<>();

    int tam=0;

    public void LlegadaCOLA1LinkedList(){
        int elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa un elemento : "));
        JOptionPane.showMessageDialog(null, "Se ha añadido [ " + elemento + " ] a la cola.", "INSERTAR ELEMENTO",
                JOptionPane.INFORMATION_MESSAGE);
        COLA1.add(elemento);
    }

    public void BorreCOLA1InsertePILAstack(){
        if (COLA1.isEmpty()){
            JOptionPane.showMessageDialog(null, "La COLA esta vacia", "ERROR", JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "EL cliente numero [ " + COLA1.getFirst() + " ] se movera a PILA", "MOVIENDO A PILA STACK", JOptionPane.INFORMATION_MESSAGE);
            PILA.push(COLA1.pollFirst());
        }
    }

    public void BorreDePilaStack(){
        if (PILA.isEmpty()){
            JOptionPane.showMessageDialog(null, "La PILA esta vacia", "PILA VACIA", JOptionPane.WARNING_MESSAGE);
        }else{
            //mostrar pila
            String mostrarPILA = "";
            for (int i = 0; i < PILA.size(); i++) {
                mostrarPILA += PILA.get(i) + "\n";
            }

            //Contains
            int sacar = Integer.parseInt(JOptionPane.showInputDialog(null, "Elmentos de la pila\n" + mostrarPILA + "\nQue elemento deseas sacar :", "SACAR", JOptionPane.QUESTION_MESSAGE));
            if (PILA.contains(sacar)){
                while (!PILA.peek().equals(sacar)){
                    NodeCola nuevo_nodo =new NodeCola(PILA.pop());
                    nuevo_nodo.next = ultimoValor;
                    //Ahora nuestro nodo guarda la informacion
                    ultimoValor = nuevo_nodo;
                    tam++;
                }
                JOptionPane.showMessageDialog(null, "El cliente numero [ "+PILA.peek()+" ] se ha borrado de PILA y ha pasado a COLA2");
                COLA2.push(PILA.pop());

                //REGRESAR LO DE PILA TEMP A PILA
                while (ultimoValor != null){
                    JOptionPane.showMessageDialog(null, "El nodo con numero de cliente " + ultimoValor.numeroCliente+" ha regresado a PILA :", "Eliminar Nodo", JOptionPane.WARNING_MESSAGE);
                    PILA.push(ultimoValor.numeroCliente);
                    //Ahora eliminamos el ultimo valor que esta ingresado, se recorrerian los valores
                    ultimoValor = ultimoValor.next;
                    //disminuimos el tamaÃ±o
                    tam--;
                }
            }else{
                JOptionPane.showMessageDialog(null, "El numero de cliente no se encuentra dentro de la PILA", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void BorraElemCOLA2(){
        if (COLA2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La COLA2 esta vacia.", "BORRAR ELEMENTO COLA2",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Se ha eliminado [ " + COLA2.pollFirst() + " ] de la cola.",
                    "BORRAR PRIMER ELEMENTO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void ImprimirPILASTACK(){
        if (PILA.isEmpty()){
            JOptionPane.showMessageDialog(null, "La PILA esta vacia", "ERROR", JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Numeros de clientes en PILA:\n  " + PILA, "IMPRIMIR PILA", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void ImprimirCOLA2(){
        if (COLA2.isEmpty()){
            JOptionPane.showMessageDialog(null, "La COLA2 esta vacia", "ERROR", JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Numeros de clientes en COLA2:  " + COLA2 + " ", "IMPRIMIR COLA", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void ImprimirCOLA1(){
        if (COLA1.isEmpty()){
            JOptionPane.showMessageDialog(null, "La COLA1 esta vacia", "ERROR", JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Numeros de clientes en COLA1:  " + COLA1 + " ", "IMPRIMIR COLA", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void tamanos(){
        JOptionPane.showMessageDialog(null, "TamaÃ±o de PILA : "+PILA.size()
                + "\n Tamaño de COLA : "+COLA1.size()
                + "\n Tamaño de COLA : "+COLA2.size(), "TAMAÑOS", JOptionPane.INFORMATION_MESSAGE);
    }

    public void primerInsertadoCOLA1(){
        if (COLA1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La COLA1 esta vacia.", "IMPRIMIR PRIMER ELEMENTO INSERTADO",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Primer elemento de la COLA1 [ " + COLA1.getFirst() + " ].",
                    "IMPRIMIR PRIMER ELEMENTO INSERTADO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void UltimoInsertadoPILA(){
        if (PILA.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La PILA esta vacia", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El ultimo elemento insertado enn la PILA :\n"+PILA.peek(),"IMPRIMIR ULTIMO ELEMENTO INSERTADO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void ULTIMOInsertadoCOLA1(){
        if (COLA1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La COLA1 esta vacia.", "IMPRIMIR PRIMER ELEMENTO INSERTADO",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Ultimo elemento de la COLA1 [ " + COLA1.getLast() + " ].",
                    "IMPRIMIR ULTIMO ELEMENTO INSERTADO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        int opcion;

        Parcial1 p = new Parcial1();

        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "0.- Salir del programa.\n"
                            + "1.- Llegada de cliente COLA1\n"
                            + "2.- BORRE COLA1 PASE PILA\n"
                            + "3.- BORRE DE PILA\n"
                            + "4.- BORRE DE COLA2\n"
                            + "5.- Imprimir PILA\n"
                            + "6.- Imprimir COLA1\n"
                            + "7.- Imprimir COLA2\n"
                            + "8.- Tamaños\n"
                            + "9.- Primer elemento COLA1\n"
                            + "10.- Ultimo elemento PILA\n"
                            + "11.- Ultimo elemento COLA1\n"
                            + "12.- Mis Datos\n"
                    ,"OBETH AGUIRRE GARCIA", JOptionPane.PLAIN_MESSAGE));

            switch (opcion){
                case 0:JOptionPane.showMessageDialog(null, "EL PROGRAMA HA TERMINADO", "Fin de programa",JOptionPane.WARNING_MESSAGE);break;
                case 1: p.LlegadaCOLA1LinkedList();break;
                case 2: p.BorreCOLA1InsertePILAstack();break;
                case 3: p.BorreDePilaStack();break;
                case 4: p.BorraElemCOLA2();break;
                case 5: p.ImprimirPILASTACK();break;
                case 6: p.ImprimirCOLA1();break;
                case 7: p.ImprimirCOLA2();break;
                case 8: p.tamanos();break;
                case 9: p.primerInsertadoCOLA1();break;
                case 10: p.UltimoInsertadoPILA();break;
                case 11: p.ULTIMOInsertadoCOLA1();break;
                case 12:
                    JOptionPane.showMessageDialog(null, "Nombre : OBETH RIGOBERTO AGUIRRE GARCIA\n"+"Matricula: 21291509\n"+"Materia: ESTRUCTURA DE DATOS");
                default: JOptionPane.showMessageDialog(null, "Opcion invalida", "INVALIDO", JOptionPane.WARNING_MESSAGE);break;
            }

        }while(opcion!=0);
    }

}


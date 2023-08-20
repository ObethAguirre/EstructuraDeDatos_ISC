package PARCIAL1;

import LISTAS_SIMPLES.NodoEmpleados;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

/*
OBETH RIGOBERTIO AGUIRRE GARCIA
21291509
EXAMEN CANCELADO
ESTRUCTURA DE DATOS
 */

public class ParcialPractico {

    NodeCola inicio, ultimo;

    Stack<Integer> pila = new Stack<>();
    LinkedList<Integer> cola = new LinkedList<>();

    int tam = 0;

    //Lllegada a cola linkedlist
    public void LlegadaAColaLinkedList() {
        int numeroCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero de cliente", "INGRESA CLIENTE", JOptionPane.QUESTION_MESSAGE));
        cola.add(numeroCliente);
    }

    //Metodo que borre LINKEDLIST COLA y pase PILA
    public void BorreColapasePILA() {
        if (cola.isEmpty()){
            JOptionPane.showMessageDialog(null, "La COLA esta vacia", "ERRRO", JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "EL cliente numero [ " + cola.getFirst() + " ] se movera a PILA", "MOVIENDO A PILA", JOptionPane.INFORMATION_MESSAGE);
            pila.push(cola.pollFirst());
        }
    }

    /*
    4.	Método que borre un elemento de la PILA, con la premisa que si es el del tope(último elemento insertado) simplemente se borra y se manda imprimir,
    si no es el del tope, sacar elemento de la PILA y pasarlo a LA CLASE NODE COLA  hasta eliminar el elemento indicado, después regresar TODOS LOS ELEMENTOS DE LA NODE  COLA
    a la PILA.
     */

    //nodo vacio?
    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else
            return false;

    }

    public void borraDePila() {
        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La PILA esta vacia", "PILA VACIA", JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrarPILA = "";
            for (int i = 0; i < pila.size(); i++) {
                mostrarPILA += pila.get(i) + "\n";
            }

            int sacar = Integer.parseInt(JOptionPane.showInputDialog(null, "Elmentos de la pila\n" + mostrarPILA + "\nQue elemento deseas sacar :", "SACAR", JOptionPane.QUESTION_MESSAGE));
            if (pila.contains(sacar)) {
                //Mientras sea dif de sacar lo insertamos a una clase nodo
                while (!pila.peek().equals(sacar)) {
                    NodeCola nuevo = new NodeCola(pila.pop());
                    nuevo.next = null;

                    if (vacia()) {
                        inicio = nuevo;
                        ultimo = nuevo;
                    } else {
                        ultimo.next = nuevo;
                        ultimo = nuevo;
                    }
                    tam++;
                }
                JOptionPane.showMessageDialog(null, "El cliente numero [ "+pila.pop()+" ] se ha borrado de pila");


                //Pasar lo del nodo a la pila
                        while (inicio != null) {
                            JOptionPane.showMessageDialog(null, "Se ha extraido el nodo y se ha movido a PILA :\n "
                                    + "\nNumero de cliente : " + inicio.numeroCliente, "Moviendo a PILA", JOptionPane.WARNING_MESSAGE);
                            pila.push(inicio.numeroCliente);
                            inicio = inicio.next;
                            tam--;
                        }
            }else{
                JOptionPane.showMessageDialog(null, "El numero de cliente no se encuentra dentro de la PILA", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    //imprimir pila
    public void ImprimirPILA(){
        if (pila.isEmpty()){
            JOptionPane.showMessageDialog(null, "La PILA esta vacia", "ERROR", JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Numeros de clientes en PILA:  " + pila + " ", "IMPRIMIR PILA", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //imprimir COLA
    public void imprimirCOLA(){
        if (cola.isEmpty()){
            JOptionPane.showMessageDialog(null, "La COLA esta vacia", "ERROR", JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Numeros de clientes en COLA:  " + cola + " ", "IMPRIMIR COLA", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Impimir cola nodo
    public void imprimirCOlaNODO(){
        if (!vacia()) {
            NodeCola temp = inicio;
            String Mostrarcola = "";

            while (temp != null){
                Mostrarcola += "-------------------------------" + "\nNumero de cliente : " + temp.numeroCliente + "\n -------------------------------";
                temp = temp.next;
            }
            JOptionPane.showMessageDialog(null, Mostrarcola, "Mostrar COLA NODO", JOptionPane.WARNING_MESSAGE);
            Mostrarcola="";
        }else{
            JOptionPane.showMessageDialog(null, "La COLA NODO esta vacia", "Mostrar COLA NODO", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Imprimir tamaños
    public void tamaños(){
        JOptionPane.showMessageDialog(null, "Tamaño de PILA : "+pila.size()
        + "\n Tamaño de COLA : "+cola.size()
        + "\n Tamaño de NODECOLA : "+tam, "TAMAÑOS", JOptionPane.INFORMATION_MESSAGE);
    }

    //Primer de cola
    public void primerCola(){
        if (cola.isEmpty()){
            JOptionPane.showMessageDialog(null, "La COLA esta vacia", "PRIMER COLA",JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Primer numero de cliente  "+cola.getFirst()+" ]", "PRIMER COLA", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //ultimo de PILA
    public void ultimoPILA(){
        if (cola.isEmpty()){
            JOptionPane.showMessageDialog(null, "La PILA esta vacia", "ULTIMO PILA",JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Ultimo numero de cliente [ "+pila.peek()+" ]", "ULTIMO PILA", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //ultimo en cola linkedlist
    public void ultimoCola(){
        if (cola.isEmpty()){
            JOptionPane.showMessageDialog(null, "La COLA esta vacia", "ULTIMO COLA",JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Primer numero de cliente [ "+cola.getLast()+" ]", "ULTIMO COLA", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    //MENU//

    public static void main(String[] args) {
        int opcion;

        ParcialPractico p = new ParcialPractico();

        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "0.- Salir del programa.\n"
                            + "1.- Llegada de cliente COLA\n"
                            + "2.- BORRE COLA PASE PILA\n"
                            + "3.- BORRE DE PILA\n"
                            + "4.- Imprimir PILA\n"
                            + "5.- Imprimir COLA\n"
                            + "6.- Imprimir COLA NODO\n"
                            + "7.- Tamaños\n"
                            + "8.- Primer elemento COLA\n"
                            + "9.- Ultimo elemento PILA\n"
                            + "10.- Ultimo elemento COLA\n"
                            ,"OBETH AGUIRRE GARCIA", JOptionPane.PLAIN_MESSAGE));

            switch (opcion){
                case 0:JOptionPane.showMessageDialog(null, "EL PROGRAMA HA TERMINADO", "Fin de programa",JOptionPane.WARNING_MESSAGE);break;
                case 1: p.LlegadaAColaLinkedList();break;
                case 2: p.BorreColapasePILA();break;
                case 3: p.borraDePila();break;
                case 4: p.ImprimirPILA();break;
                case 5: p.imprimirCOLA();break;
                case 6: p.imprimirCOlaNODO();break;
                case 7: p.tamaños();break;
                case 8: p.primerCola();break;
                case 9: p.ultimoPILA();break;
                case 10: p.ultimoCola();break;
                default: JOptionPane.showMessageDialog(null, "Opcion invalida", "INVALIDO", JOptionPane.WARNING_MESSAGE);
            }


        }while(opcion!=0);
    }
}

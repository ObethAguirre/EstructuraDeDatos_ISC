package PARCIAL1;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

/*

 */
public class ExamPrueba {
    Stack<Integer> pila = new Stack<>();
    Stack<Integer> temporal = new Stack<>();
    LinkedList<Integer> cola1 = new LinkedList<>();
    LinkedList<Integer> cola2 = new LinkedList<>();

    public void ImprimirPILA(){
        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La PILA esta vacia", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrar="";
            for (int i = 0; i < pila.size(); i++) {
                mostrar+=pila.get(i)+"\n";
            }
            JOptionPane.showMessageDialog(null, "Elementos de la pila : \n"+mostrar);
        }
    }

    public void ImprimirTEMPORAL(){
        if (temporal.isEmpty()) {
            JOptionPane.showMessageDialog(null, "TEMPORAL esta vacio", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrar="";
            for (int i = 0; i < temporal.size(); i++) {
                mostrar+=temporal.get(i)+"\n";
            }
            JOptionPane.showMessageDialog(null, "Elementos de la pila : \n"+mostrar);
        }
    }

    public void ImprimirCOLA1(){
        if (cola1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La COLA1 esta vacia.", "IMPRIMIR TODOS LOS ELEMENTOS",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrar = "";
            mostrar = cola1 + "\n";
            JOptionPane.showMessageDialog(null, "Contenido : " + mostrar, "IMPRIMIR TODOS LOS ELEMENTOS",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void ImprimirCOLA2(){
        if (cola2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La COLA2 esta vacia.", "IMPRIMIR TODOS LOS ELEMENTOS",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            String mostrar = "";
            mostrar = cola2 + "\n";
            JOptionPane.showMessageDialog(null, "Contenido : " + mostrar, "IMPRIMIR TODOS LOS ELEMENTOS",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //INSERTAR A COLA1
    public void LlegadaClientesACola1(){
        int llegaCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar cliente :", "Llegada de Cliente", JOptionPane.QUESTION_MESSAGE));
        //Mostrar numero que ingreso
        JOptionPane.showMessageDialog(null, "El cliente "+llegaCliente+" se ha formado","CONFIRMACION",JOptionPane.PLAIN_MESSAGE);
        cola1.add(llegaCliente);
    }

    //BORRE DE COLA1 E INSERTAR A PILA TEMPORAL
    public void BorraCola1EInsertorTemporal(){
        if (cola1.isEmpty()){
            JOptionPane.showMessageDialog(null,"La cola1 esta vacia", "BORRAR DE COLA 1", JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "EL cliente "+cola1.getFirst()+" se ha movido a la pila", "MOVIENDO A PILA", JOptionPane.INFORMATION_MESSAGE);
            pila.push(cola1.pollFirst());
        }
    }

    /*
        Método que borre un elemento de la PILA, con la premisa que si es el del tope(último elemento insertado)
        simplemente se borra y se manda a la COLA2 (SE PUEDE IMPRIMIR SI LO DESEAN) ,
        si no es el del tope, sacar elemento de la PILA y pasarlo a otra clase PILA TEMPORAL hasta eliminar el elemento indicado,
        después regresar de la PILATEMPORAL a la PILA.
     */
    public void BorreDePila(){
        if (pila.isEmpty()){
            JOptionPane.showMessageDialog(null,"La PILA está vacia", "BORRAR DE PILA", JOptionPane.WARNING_MESSAGE);
        }else{
            //ESTO ES PARA IMPRIMIR Y VER QUE QUIERO SACAR
            String mostrarPILA = "";
            for (int i = 0; i < pila.size(); i++) {
                mostrarPILA += pila.get(i) + "\n";
            }

            int sacar = Integer.parseInt(JOptionPane.showInputDialog(null, "Elmentos de la pila\n"+mostrarPILA+"\nQue elemento deseas sacar :", "SACAR",JOptionPane.QUESTION_MESSAGE));
            if (pila.contains(sacar)){
                while (!pila.peek().equals(sacar)) {
                    JOptionPane.showMessageDialog(null,temporal.push(pila.pop()) + "Se ha modivo a temporal", "MOVIENDO A TEMPORAL", JOptionPane.INFORMATION_MESSAGE);
                }
                cola2.add(pila.pop());
                JOptionPane.showMessageDialog(null, "El cliente "+sacar+" se ha pasado a cola2","ELIMINANDO CLIENTE",JOptionPane.WARNING_MESSAGE);

                //Regresar de temporal a pila
                while (!temporal.isEmpty()) {
                    pila.push(temporal.pop());
                }
            }else{
                JOptionPane.showMessageDialog(null,"El elemento no existe", "BORRAR DE PILA", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    //BORRA DE COLA2 e imprimir
    public void BorreDeCOLA2eImprimir(){
        if (cola2.isEmpty()){
            JOptionPane.showMessageDialog(null,"La COLA2 está vacia", "BORRAR DE COLA2", JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Borrando de cola2 " + cola2.getFirst(), "BORRANDO COLA2", JOptionPane.WARNING_MESSAGE);
            cola2.pollFirst();
        }
    }

    public void tamaños(){
        JOptionPane.showMessageDialog(null, "Tamaño de PILA : "+pila.size()+"\n"+
                "Tamaño COLA1 : "+cola1.size()+"\n"+
                "Tamaño COLA2 : "+cola2.size()+"\n", "TAMAÑOS", JOptionPane.PLAIN_MESSAGE);
    }

    public void primerCOLA1(){
        if (cola1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La COLA1 esta vacia.", "IMPRIMIR TODOS LOS ELEMENTOS",
                    JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Primer elemento COLA1 : " + cola1.getFirst(), "PIRMER ELEMENTO COLA1", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void primerCOLA2(){
        if (cola2.isEmpty()){
            JOptionPane.showMessageDialog(null, "La COLA2 esta vacia.", "IMPRIMIR TODOS LOS ELEMENTOS",
                    JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Primer elemento COLA1 : " + cola2.getFirst(), "PIRMER ELEMENTO COLA2", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void ultimoPILA(){
        if (pila.isEmpty()){
            JOptionPane.showMessageDialog(null, "La PILA esta vacia", "Error", JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Ultimo elemento PILA : " + pila.peek(), "ULTIMO ELEMENTO PILA", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void ultimoCOLA2(){
        if (cola2.isEmpty()){
            JOptionPane.showMessageDialog(null, "La COLA2 esta vacia.", "IMPRIMIR TODOS LOS ELEMENTOS",
                    JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Ultimo elemento COLA2 : " + cola2.getLast(), "ULTIMO ELEMENTO PILA", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public static void main(String[] args) {
        int opcion;
        ExamPrueba e = new ExamPrueba();

        do{
           opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                   "0.- Salir del programa.\n"
                   + "1.- Llegada de clientes\n"
                   + "2.- Mover cola1 a pila\n"
                   + "3.- Borre un elemento de pila\n"
                   + "4.- Borra de cola2 e imprimir\n"
                   + "5.- Imprimir PILA\n"
                   + "6.- Imprimir TEMPORAL\n"
                   + "7.- Imprimir COLA1\n"
                   + "8.- Imprimir COLA2\n"
                   + "9.- Tamaños\n"
                   + "10.- Primer elemento COLA1\n"
                   + "11.- Primer elemento COLA2\n"
                   + "12.- Ultimo elemento PILA\n"
                   + "13.- Ultimo elemento COLA2\n","OBETH RIGOBERTO AGUIRRE GARCIA", JOptionPane.PLAIN_MESSAGE));

        switch (opcion){
            case 0: JOptionPane.showMessageDialog(null, "EL PROGRAMA HA TERMINADO", "Fin de programa",JOptionPane.PLAIN_MESSAGE);break;
            case 1: e.LlegadaClientesACola1();break;
            case 2: e.BorraCola1EInsertorTemporal();break;
            case 3: e.BorreDePila();break;
            case 4: e.BorreDeCOLA2eImprimir();break;
            case 5: e.ImprimirPILA();break;
            case 6: e.ImprimirTEMPORAL();break;
            case 7: e.ImprimirCOLA1();break;
            case 8: e.ImprimirCOLA2();break;
            case 9: e.tamaños();break;
            case 10: e.primerCOLA1();break;
            case 11: e.primerCOLA2();break;
            case 12: e.ultimoPILA();break;
            case 13: e.ultimoCOLA2();break;
            default: JOptionPane.showMessageDialog(null, "Opcion invalida", "INVALIDO", JOptionPane.WARNING_MESSAGE);
        }
        }while(opcion!=0);
    }
}

package LISTAS_SIMPLES;

import javax.swing.*;

public class testTAREA_13 {

    public static void main(String[] args) {


        TAREA_13 t = new TAREA_13();
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1.- Verifica si esta vacia\n"
                    + "2.- Inserta elemento\n"
                    + "3.- Borra elemento por numemp\n"
                    + "4.- Imprimir todos los elementos\n"
                    + "5.- Impimir DEPTO igual X\n"
                    + "6.- Imprimir primer elemento\n"
                    + "7.- Imprimir tamaño\n"
                    + "8.- Imprimir SUELDO >= SAL\n"
                    + "9.- Invertir\n"
                    + "10.- Salir del programa\n"
                    + "\nIngrese la opcion deseada:", "MENU", JOptionPane.QUESTION_MESSAGE));

            switch (opcion) {
                case 1:
                    if (t.vacia()) {
                        JOptionPane.showMessageDialog(null, "VACIO", "Verifica si esta vacia", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "VACIO", "Verifica si esta vacia", JOptionPane.WARNING_MESSAGE);
                    }
                    break;

                case 2:
                    int numemp = Integer.parseInt(JOptionPane.showInputDialog("Número de empleado :"));
                    String nombre = JOptionPane.showInputDialog("Nombre :");
                    int depto = Integer.parseInt(JOptionPane.showInputDialog("Número de departamento :"));
                    float sueldo = Float.parseFloat(JOptionPane.showInputDialog("Sueldo :"));
                    t.insertarInicio(numemp, nombre, depto, sueldo);
                    break;

                case 3:
                    t.borrar();
                    break;
                case 4:
                    t.imprimir();
                    break;
                case 5:
                    t.imprimirPorDEPTO();
                    break;
                case 6:
                    t.imprimirPrimerElemento();
                    break;
                case 7:
                    t.tamaño();
                    break;
                case 8:
                    t.imprimirPorSUELDO();
                    break;
                case 9:
                    t.invertir();
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null, "Fin del programa", "FIN", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida", "INVALIDO", JOptionPane.WARNING_MESSAGE);
            }
        } while (opcion != 10);
    }
    }


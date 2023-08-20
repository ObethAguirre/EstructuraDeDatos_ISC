package LISTAS_SIMPLES;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;

    public class testTAREA_10 {
        public static void main(String[] args) {


            TAREA_10 t = new TAREA_10();
            int opcion;
            int numemp;
            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "TAREA 10\n"
                        + "1.- Insertar elemento.\n"
                        + "2.- Verificar vacio.\n"
                        + "3.- Borrar elemento por numero de empleado.\n"
                        + "4.- Imprimir todos los elementos.\n"
                        + "5.- Imprimir con el departamento.\n"
                        + "6.- Imprimir el priimer elemento.\n"
                        + "7.- Imprimir el tamaño.\n"
                        + "8.- Imprimir con el sueldo\n"
                        + "9.- Salir del programa.\n" + "Seleccione una opcion\n\n", "OBETH RIGOBERTO AGUIRRE GARCIA", JOptionPane.PLAIN_MESSAGE));

                switch (opcion) {
                    case 1:
                        numemp = Integer.parseInt(JOptionPane.showInputDialog("Numero de empleado: "));
                        String nombre = JOptionPane.showInputDialog("Nombre: ");
                        int depto = Integer.parseInt(JOptionPane.showInputDialog("Numero de departamento: "));
                        float sueldo = Float.parseFloat(JOptionPane.showInputDialog("Sueldo: "));
                        t.insertarOrden(numemp, nombre, depto, sueldo);
                        break;
                    case 2:
                        if (t.estaVacia()){
                            JOptionPane.showMessageDialog(null, "No hay departamentos", "CASO 2", JOptionPane.WARNING_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Hay " + t.tamaño() + " departamento(s)", "CASO 2", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3:
                        numemp = Integer.parseInt(JOptionPane.showInputDialog("Numero de empleado: "));
                        t.borrar(numemp);
                        break;
                    case 4: t.imprimir();break;

                    case 5:
                        int dep = Integer.parseInt(JOptionPane.showInputDialog("Numero de departamento"));
                        t.imprimirPorDepto(dep); break;

                    case 6:
                        t.imprimirPrimerElemento();break;

                    case 7:
                        t.tamaño();break;

                    case 8:
                        t.imprimirSUELDOImayoresigualSAL();break;
                    case 9:
                        JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "INGRESE UNA OPCION VALIDA \n", "ERROR OPCION", JOptionPane.WARNING_MESSAGE);
                        break;

                }
            } while (opcion != 9);
        }
    }


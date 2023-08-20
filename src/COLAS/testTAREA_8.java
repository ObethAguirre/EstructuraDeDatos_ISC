package COLAS;

import javax.swing.JOptionPane;
public class testTAREA_8 {


        public static void main(String[] args) {
            int opcion;
            TAREA_8 c = new TAREA_8();

            do{
                opcion=Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione un opcion.\n" + "1.- Insertar elemento.\n" + "2.- Borrar elemento del inicio.\n"
                        + "3.- Verifica si esta vacia. \n" + "4.- Imprimir todos los elementos. \n" + "5.- Imprimir el primer elemento. \n" + "6.- Imprimir el ultimo elemento. \n"
                        + "7.- Imprimir el tamaño de la cola. \n" + "8.- Buscar un elemento en la cola. \n" + "9.- Eliminar cola. \n" + "10.- Fin del programa.\n\n", "MENU", JOptionPane.QUESTION_MESSAGE));

                switch(opcion){
                    case 1: c.insertarElementroAlFinal(); break;
                    case 2: c.BorrarElementoDelInicio(); break;

                    case 3: if (c.VerificarSiEstaVacia()) {
                        JOptionPane.showMessageDialog(null, "La cola no estÃ¡ vacia.", "VERIFICANDO", JOptionPane.PLAIN_MESSAGE);
                    } else {JOptionPane.showMessageDialog(null, "La cola aÃºn esta vacia.", "VERIFICANDO", JOptionPane.PLAIN_MESSAGE);
                    }break;

                    case 4: c.ImprimirTodosElementos(); break;
                    case 5: c.ImprimirPrimerInsertado(); break;
                    case 6: c.ImprimirUltimoInsertado(); break;
                    case 7: c.ImprimirCantidadElementos(); break;
                    case 8: c.Contains(); break;
                    case 9: c.BorrarCola(); break;
                    case 10: JOptionPane.showMessageDialog(null, "Fin del programa.", "FIN", JOptionPane.WARNING_MESSAGE);break;
                    default: JOptionPane.showMessageDialog(null, "Ingrese una opcion valida. \n", "ERROR OPCION", JOptionPane.WARNING_MESSAGE);break;
                }
            }while(opcion!=10);
        }

    }


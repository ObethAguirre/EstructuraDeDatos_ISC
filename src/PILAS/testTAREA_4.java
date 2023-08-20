package PILAS;
import javax.swing.JOptionPane;
public class testTAREA_4 {

        public static void main(String[] args) {
            int opcion;
            TAREA_4 p = new TAREA_4();
            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.- INSERTAR NUEVO ELEMENTO\n"
                                + "2.- MOSTRAR PILA\n" + "3.- ULTIMO ELEMENTO\n"
                                + "4.- ELMILIMINAR ELEMENTO\n"
                                + "5.- VACIAR PILA\n" + "6.- CANTIDAD DE ELEMENTOS\n\n"
                                + "7.- SALIR DEL PROGRAMA", JOptionPane.QUESTION_MESSAGE));

                switch(opcion){
                    case 1: p.insertarEnPila();break;
                    case 2: p.imprimirPila();break;
                    case 3: p.elementoTope();break;
                    case 4: p.eliminaElemento();break;
                    case 5: p.vaciaPila();break;
                    case 6: p.cantidadElementos();break;
                    case 7: JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA");break;
                    default: JOptionPane.showMessageDialog(null, "INGRESE UNA OPCION VALIDA \n", "ERROR OPCION", JOptionPane.WARNING_MESSAGE);break;
                }
            } while (opcion != 7);

        }

    }


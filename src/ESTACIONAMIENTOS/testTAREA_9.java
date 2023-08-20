package ESTACIONAMIENTOS;
import javax.swing.JOptionPane;
public class testTAREA_9 {

        public static void main(String[] args) {
            TAREA_9 e = new TAREA_9();
            int opcion;
            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.- INGRESAR AUTO\n"
                                + "2.- SACAR AUTO\n"
                                + "3.- MOSTRAR ESTACIONAMIENTO PRINCIPAL\n"
                                + "4.- MOSTRAR ESTACIONAMIENTO TEMPORAL\n"
                                + "5.- SALIR DEL PROGRAMA\n"+"SELECCIONA UNA OPCION\n", JOptionPane.QUESTION_MESSAGE));

                switch(opcion){
                    case 1: e.Alta();break;
                    case 2: e.Baja();break;
                    case 3: e.MostrarPRIN();break;
                    case 4: e.MostrarTEMP();break;
                    case 5: JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA");break;
                    default: JOptionPane.showMessageDialog(null, "INGRESE UNA OPCION VALIDA \n", "ERROR OPCION", JOptionPane.WARNING_MESSAGE);break;
                }
            } while (opcion != 5);
        }

    }


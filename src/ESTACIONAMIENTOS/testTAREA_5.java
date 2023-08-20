package ESTACIONAMIENTOS;
import javax.swing.JOptionPane;
public class testTAREA_5 {



        public static void main(String[] args) {
            TAREA_5 e = new TAREA_5();
            int opcion;
            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.- INGRESAR AUTO\n"
                                + "2.- SACAR AUTO\n"
                                + "3.- MOSTRAR VEHICULOS ESTACIONADOS\n"
                                + "4.- CUANTOS VEHICULOS HAY\n"
                                + "5.- MOSTRAR ULTIMO VEHICULO ESTACIONADO\n"
                                + "6.- SALIR DEL PROGRAMA\n"+"SELECCIONA UNA OPCION\n", JOptionPane.QUESTION_MESSAGE));

                switch(opcion){
                    case 1: e.insertarPRINCIPAL();break;
                    case 2: e.sacarAuto();break;
                    case 3: e.mostrarEstacionamientoPrincipal();break;
                    case 4: e.cuantosElementos();break;
                    case 5: e.ultimoAuto();break;
                    case 6: JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA");break;
                    default: JOptionPane.showMessageDialog(null, "INGRESE UNA OPCION VALIDA \n", "ERROR OPCION", JOptionPane.WARNING_MESSAGE);break;
                }
            } while (opcion != 6);
        }

    }


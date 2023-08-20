package COLAS;
import javax.swing.JOptionPane;
public class testTAREA_7 {

        public static void main(String[] args) {
            int MAX=Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tamaño de la memoria"));
            TAREA_7 c = new TAREA_7(MAX);
            int opcion;

            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.- INSERTAR ELEMENTOS\n"+
                                "2.- MOSTRAR COLA\n"+ "3.- ULTIMO ELEMENTO\n" + "4.- PRIMER ELEMNTO\n" +
                                "5.- ELMILIMINAR ELEMENTO\n"+
                                "6.- Â¿CONTIENE ELEMENTOS?\n" + "7.- CANTIDAD DE ELEMENTOS\n\n" +
                                "8.- SALIR DEL PROGRAMA", JOptionPane.QUESTION_MESSAGE));
                switch(opcion){
                    case 1: c.insertar();break;
                    case 2: c.imprimirCola();break;
                    case 3: c.imprimirUltimo();break;
                    case 4: c.imprimirPrimer();break;
                    case 5: c.borrar();break;
                    case 6: if (!c.llena()) {
                        JOptionPane.showMessageDialog(null, "La cola contienen elementos");
                    }else{
                        JOptionPane.showMessageDialog(null, "La cola aun esta vacia");
                    };break;
                    case 7: c.cantidad();break;
                    case 8: JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA");break;
                    default: JOptionPane.showMessageDialog(null, "INGRESE UNA OPCION VALIDA \n", "ERROR OPCION", JOptionPane.WARNING_MESSAGE);break;
                }
            } while (opcion!=8);
        }

    }


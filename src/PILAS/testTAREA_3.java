package PILAS;

import javax.swing.JOptionPane;

public class testTAREA_3 {


    public static void main(String[] args) {
        int TAMAÑO;
        TAMAÑO = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tamaÃ±o de la pila :"));
        TAREA_3 m = new TAREA_3(TAMAÑO);

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1.- INSERTAR ELEMENTOS\n" +
                            "2.- MOSTRAR PILA\n" + "3.- ULTIMO ELEMENTO\n" +
                            "4.- ELMILIMINAR ELEMENTO\n" +
                            "5.- VACIAR PILA\n" + "6.- CANTIDAD DE ELEMENTOS\n\n" +
                            "7.- SALIR DEL PROGRAMA", JOptionPane.QUESTION_MESSAGE));
            switch (opcion) {
                case 1:
                    m.insertaPila();
                    break;
                case 2:
                    m.mostrarPila();
                    break;
                case 3:
                    m.ultimoElemento();
                    break;
                case 4:
                    m.eliminarPila();
                    break;
                case 5:
                    m.vaciaPila();
                    break;
                case 6:
                    m.TOPE();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "INGRESE UNA OPCION VALIDA \n", "ERROR OPCION", JOptionPane.WARNING_MESSAGE);
                    break;
            }
        } while (opcion != 7);
    }

}


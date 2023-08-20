package ESTACIONAMIENTOS;
import java.util.LinkedList;
import java.util.Stack;
import javax.swing.JOptionPane;
public class TAREA_9 {

        LinkedList<String> PRIN = new LinkedList<>();
        Stack<String> TEMP = new Stack<>();
        String auto;

        public void Alta() {
            auto = JOptionPane.showInputDialog(null, "Ingresa una placa.", "ALTA DEL VEHICULO", JOptionPane.QUESTION_MESSAGE);
            auto = auto.trim();
            PRIN.add(auto);
        }

        public void Baja() {
            if (PRIN.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El estacionamiento principal esta vacio.", "ESTACIONAMIENTO PRINCIPAL", JOptionPane.WARNING_MESSAGE);
            } else {

                String mostrarPlacas = "";
                for (int i = 0; i < PRIN.size(); i++) {
                    mostrarPlacas += PRIN.get(i) + "\n";
                }

                String sacar = JOptionPane.showInputDialog(null, "Autos estacionados: \n" + mostrarPlacas + "\nIngresa una placa.", "BAJA DEL VEHICULO", JOptionPane.QUESTION_MESSAGE);
                //Recordar que .trim() es para eliminar espacios innecesarios
                sacar = sacar.trim();

                //Si sacar se encuentra en la cola PRIN entonces:
                if (PRIN.contains(sacar)) {

                    //mientras el primer elemento de la cola no sea igual a sacar
                    while (!PRIN.getFirst().equalsIgnoreCase(sacar)) {
                        //Entonces lo aÃ±adimos al estacionamiento temporal PILA
                        TEMP.push(PRIN.pollFirst());
                    }

                    //Cuando ya haya sido igual entonces lo sacamos de la COLA y mostramos que se llevo acabo la salida
                    PRIN.pollFirst();
                    JOptionPane.showMessageDialog(null, "Vehiculo con placa  [ " + sacar + " ]  ha salido del estacionamiento principal.");

                    //Ahora solo queda vaciar el estacionamiento TEMP (pila)
                    //Mientras el estacionamiento temporal no este vacio movemos los elementos a PRIN(cola)
                    while (!TEMP.isEmpty()) {
                        PRIN.addFirst(TEMP.pop());
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "La placa [" + sacar + "] no se ha encontrado.");
                }
            }
        }


        //Estacionamiento principal COLA
        public void MostrarPRIN(){
            if (PRIN.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El estacionamiento principal esta vacio.", "ESTACIONAMIENTO PRINCIPAL",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                String mostrar = "";
                mostrar += PRIN + "\n";
                JOptionPane.showMessageDialog(null, "Autos en el estacionamiento principal : \n" + mostrar, "ESTACIONAMIENTO PRINCIPAL",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }


        //Estacionamiento temporal PILAS
        public void MostrarTEMP(){
            if (TEMP.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El estacionamiento temporal esta vacio.", "ESTACIONAMIENTO TEMPORAL", JOptionPane.WARNING_MESSAGE);
            } else {
                String mostrar = "";
                for (int i = 0; i < TEMP.size(); i++) {
                    mostrar += TEMP.get(i) + "\n";
                }
                JOptionPane.showMessageDialog(null, "Autos en el estacionamiento temporal : \n" + mostrar, "ESTACIONAMIENTO TEMPORAL" , JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }


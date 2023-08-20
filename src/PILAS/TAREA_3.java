package PILAS;
import javax.swing.JOptionPane;
public class TAREA_3 {


    /*
    â€¢ Crea PILA
    â€¢ De VacÃ­a PILA true o false
    â€¢ De llena PILA true o false
    â€¢ De Inserta elemento en la PILA
    â€¢ De borrar elemento de la PILA
    â€¢ Imprimir los elementos de la PILA
    â€¢ Imprimir el elemento del tope de la PILA
    â€¢ Imprimir la cantidad de elementos que contiene la PILA
    â€¢ MenÃº principal que llame a los mÃ©todos anteriores,
        entendiendo que para insertar se tiene que llamar al metodo de lleno antes de insertar
        y para borrar se tiene que validar el metodo de vacio antes de borrar.

     */


        int pila[];
        int MAX, TOPE;

        //SIN ASIGNAR MAX
        public TAREA_3() {
            this.TOPE = 0;
            this.MAX = 100;
            this.pila = new int[this.MAX + 1];
        }

        //ASIGNANDO MAX
        public TAREA_3(int MAX) {
            this.TOPE=0;
            this.MAX = MAX;
            this.pila = new int[this.MAX+1];
        }

        //OBTENER CANTIDAD MAXIMA
        public void TOPE() {
            JOptionPane.showMessageDialog(null,"La cantidad de elementos que contiene la pila es " + this.TOPE);
        }

        //VACIA PILA
        public void vaciaPila() {
            this.TOPE = 0;
        }

        //PILA LLENA
        public boolean pilaLlena() {
            if (this.MAX == this.TOPE) {
                return true;
            } else {
                return false;
            }
        }

        //PILA VACIA
        public boolean pilaVacia() {
            if (this.TOPE == 0) {
                return true;
            } else {
                return false;
            }
        }

        public void insertaPila() {
            if (this.pilaLlena()) {
                JOptionPane.showMessageDialog(null, "LA PILA ESTA LLENA");
            } else {
                int e;

                e = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el valor a aÃ±adir"));
                this.TOPE++;
                this.pila[this.TOPE] = e;
                JOptionPane.showMessageDialog(null, "Ha ingresado el valor " + e + " a la pila.");
            }
        }

        public void eliminarPila() {
            if (this.pilaVacia()) {
                JOptionPane.showMessageDialog(null, "LA PILA ESTA VACIA");
            } else {
                int e = this.pila[this.TOPE];
                this.TOPE--;

                JOptionPane.showMessageDialog(null, "Ha eliminado el valor " + e + " de la pila.");
            }
        }

        public void mostrarPila(){
            if (this.pilaVacia()) {
                JOptionPane.showMessageDialog(null, "VACIA\n No hay contenido que mostrar");
            } else {
                String mostrar="";
                for (int i = 1; i <= this.TOPE; i++) {
                    mostrar += this.pila[i]+"\n";
                }
                JOptionPane.showMessageDialog(null, "Cantidad de elementos "+this.TOPE+"\n"+"Los elementos de la pila son: \n"+mostrar);
            }
        }

        public void ultimoElemento(){
            JOptionPane.showMessageDialog(null, "Elemento tope es "+this.pila[this.TOPE]);
        }
    }



package LISTAS_SIMPLES;
import javax.swing.*;
public class TAREA_14 {

    /*
    DOBLEMENTENTE ENCADENADA CIRCULAR
    Desarrollar un programa en JAVA que utiliza una clase LISTA DOBLEMENTE ENCADENADA CIRCULAR (LDEC), con los datos :
    Con los métodos de:
    Crear nodo cabeza sin datos.
    Insertar un nodo en la LDEC ordenando los datos por el campo de DEPTO y dentro de el por NUMEMP de menor a mayor.
    Baja de un nodo de la LDEC localizando el dato por NUMEMP.
    Imprimir la cantidad de elementos de la LDEC.
    Imprimir los datos de la LDEC recorriendo hacia adelante la lista (next).
    Imprimir los datos de la LDEC recorriendo hacia atrás la lista (prev).
    Imprimir el nodo con SUELDO mayor.
    Imprimir los datos de la LDEC solo de los empleados de un DEPTO=X.
    */

        TAREA_14 next, nodo_cabeza, anterior;
        int numemp, tam;
        int departamento;
        String nombre;
        float sueldo;

        TAREA_14 prev,temporal;

        public TAREA_14(int numero, String nom, float sue, int depa) {
            this.nombre = nom;
            this.sueldo = sue;
            this.departamento = depa;
            this.numemp = numero;

        }

        public TAREA_14() {

        }

        public void insertar() {
            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre");
            int numero_empleado = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero del empleado"));
            Float sueldo = Float.parseFloat(JOptionPane.showInputDialog(null, "Sueldo del empleado"));
            int depa = Integer.parseInt(JOptionPane.showInputDialog(null, "Departamento del empleado"));

            TAREA_14 nodo = new TAREA_14(numero_empleado, nombre, sueldo, depa);
            if (nodo_cabeza == null) {
                nodo_cabeza = new TAREA_14();
                nodo_cabeza.next = nodo_cabeza;
                nodo_cabeza.prev = nodo_cabeza;
                tam = 0;
            }
            temporal=nodo_cabeza.next;
            anterior=nodo_cabeza;
            while ((temporal!= nodo_cabeza)&&(temporal.departamento< nodo.departamento)){
                temporal=temporal.next;

            }
            while ((temporal!=nodo_cabeza)&&(temporal.departamento== nodo.departamento)&& (temporal.numemp< nodo.numemp)){
                temporal=temporal.next;
            }
            anterior=temporal.prev;
            nodo.next=temporal;
            nodo.prev=anterior;
            temporal.prev=nodo;
            anterior.next=nodo;
            tam++;
        }
        public void borrar(){
            temporal=nodo_cabeza.next;
            int numero_empleado=Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de empleado que quieres eliminar"));
            TAREA_14 sig,ant;
            ant=nodo_cabeza.next;
            if(nodo_cabeza==temporal){
                JOptionPane.showMessageDialog( null, "La lista esta vacia");
                return;
            }
            while ((temporal!=nodo_cabeza)&&(temporal.numemp!=numero_empleado)){
                temporal=temporal.next;
            }
            if( temporal==nodo_cabeza){
                JOptionPane.showMessageDialog(null, "Ese numero de empleado no existe");
                return;
            }
            anterior=temporal.prev;
            sig=temporal.next;
            anterior.next=sig;
            sig.prev=ant;
            tam--;

        }
        public void ImprimirNormal(){
            String lista="";
            TAREA_14 temp1=nodo_cabeza.next;
            if( temp1== nodo_cabeza){
                JOptionPane.showMessageDialog(null, "La lista esta vacia");

            }else{
                while (temp1!=nodo_cabeza){
                    lista=lista+"Nombre del empleado: "+temp1.nombre+"\nNumero de empleado: "+temp1.numemp+"\nSueldo: "+temp1.sueldo+"\nDepartamento: "+temp1.departamento+"\n" +
                            "/////////////////////////////////////////////////////////////////////////////////////////////////////////////\n";
                    temp1=temp1.next;

                }
            }

            JOptionPane.showMessageDialog(null, lista);
        }
        public void ImprimirInverso(){
            String lista="";
            TAREA_14 temp1=nodo_cabeza.prev;
            if( temp1== nodo_cabeza){
                JOptionPane.showMessageDialog(null, "La lista esta vacia");

            }else{
                while (temp1!=nodo_cabeza){
                    lista=lista+"Nombre del empleado: "+temp1.nombre+"\nNumero de empleado: "+temp1.numemp+"\nSueldo: "+temp1.sueldo+"\nDepartamento: "+temp1.departamento+"\n" +
                            "-----------------------------\n";
                    temp1=temp1.prev;

                }
            }

            JOptionPane.showMessageDialog(null, lista);
        }
        public void ImprimirPorSueldo() {
            int sueldo_dado = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique un sueldo para buscar quienes tienen ese sueldo o mayo al ingresado"));
            String lista = "\nLos empleados con un sueldo mayor o igual a "+sueldo_dado+" son los siguientes\n";
            TAREA_14 temp1 = nodo_cabeza.next;
            if (temp1 == nodo_cabeza) {
                JOptionPane.showMessageDialog(null, "La lista esta vacia");
                return;
            } else {

                while (temp1 != nodo_cabeza) {
                    if(temp1.sueldo>= sueldo_dado){
                        lista = lista + "Nombre del empleado: " + temp1.nombre + "\nNumero de empleado: " + temp1.numemp + "\nSueldo: " + temp1.sueldo + "\nDepartamento: " + temp1.departamento + "\n" +
                                "-----------------------------\n";


                    }
                    temp1 = temp1.next;
                }
                JOptionPane.showMessageDialog(null, lista);
            }
        }
        public void ImprimirPorDEPTO() {
            int departamento = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique un departamento"));
            String lista = "\nLos empleados con departamento:  "+departamento+"\n";
            TAREA_14 temp1 = nodo_cabeza.next;
            if (temp1 == nodo_cabeza) {
                JOptionPane.showMessageDialog(null, "La lista esta vacia");
                return;
            } else {

                while (temp1 != nodo_cabeza) {
                    if(temp1.departamento== departamento){
                        lista = lista + "Nombre del empleado: " + temp1.nombre + "\nNumero de empleado: " + temp1.numemp + "\nSueldo: " + temp1.sueldo + "\nDepartamento: " + temp1.departamento + "\n" +
                                "-----------------------------\n";


                    }
                    temp1 = temp1.next;
                }
                JOptionPane.showMessageDialog(null, lista);
            }
        }
        public  void tamaño(){
            JOptionPane.showMessageDialog(null, "Tamaño de la lista: "+ tam);
        }
        public static void main(String[] args) {
            int op;
            TAREA_14 p = new TAREA_14();
            do{
                op=Integer.parseInt(JOptionPane.showInputDialog(null, "Opcion: \n" +
                        "0. Salir del programa\n" +
                        "1. Agregar\n" +
                        "2. Eliminar\n" +
                        "3. Imprimir Normal\n" +
                        "4. Imprimir Inversa\n" +
                        "5. Tamaño \n" +
                        "6. Imprimir >= X\n" +
                        "7. Imprimir = DEPTO\n" + "ELIGE UNA OPCION :", "MENU", JOptionPane.QUESTION_MESSAGE));
                switch (op){
                    case 0:
                        JOptionPane.showMessageDialog(null, "Saliendo del programa");
                        break;
                    case 1:
                        p.insertar();
                        break;
                    case 2:
                        p.borrar();
                        break;
                    case 3:
                        p.ImprimirNormal();
                        break;
                    case 4:
                        p.ImprimirInverso();
                        break;
                    case 5:
                        p.tamaño();
                        break;
                    case 6:
                        p.ImprimirPorSueldo();
                        break;
                    case 7:
                        p.ImprimirPorDEPTO();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                }

            }while (op!=0);
        }

}

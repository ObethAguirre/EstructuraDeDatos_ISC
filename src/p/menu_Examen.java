package p;
import javax.swing.JOptionPane;

public class menu_Examen {

    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Arbol_Binario a= new Arbol_Binario();
        LCDC_Examen lc = new LCDC_Examen();
        LES_Examen ls = new LES_Examen();
        int op;
        boolean continuar = false;
        
        
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "OBETH RIGOBERTO AGUIRRE GARCIA\n"
                    + "0.- Salir\n"
                    + "1.- Insertar un dato en la lista encadenada simple(linkedlist) \n"
                    + "2.- Baja de un nodo de la lista encadenada simple (linkedlist)\n"
                    + "3.- Insertar Empleado en Arbol Binario\n"
                    + "4.- IMPRIMIR RECORIDO INORDEN Arbol\n"
                    + "5.- IMPRIMIR RECORRIDO POSORDEN Arbol\n"
                    + "6.- IMPRIMIR RECORRIDO POSTORDEN Arbol\n"
                    + "7.- Eliminar un nodo del Arbol Binario \n"
                    + "8.- Numero de Nodos en Arbol Activos\n"
                    + "9.- Copiar los datos del árbol binario a la   Lista Doblemente Encadenada Circular\n"
                    + "10.-Imprimir el contenido de la Lista Encadenada Simple\n"
                    + "11.- Imprimir el contenido de la Lista Doblemente Encadenada Circular\n"));
            switch(op){
                case 0:
                    System.exit(0);
                    break;   
                case 1:
                    int d=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato Entero: "));
                    ls.InsertarALKD(d);
                    break;
                 case 2:
                    int d1=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato que dese eliminar: "));
                    ls.Borrar(d1);
                    break;
                case 3:
                    int nE=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero del Empleado: "));
                    String nom=JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado : ");
                    a.Insertar(nE, nom);
                    break;  
                case 4:
                    a.inOrder(a.raiz);
                    break;
                case 5:
                    a.Postorder(a.raiz);
                    break;
                case 6:
                    a.Preorden(a.raiz);
                    break;
                case 7:
                    int xe=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero del Empleado que dese Eliminar: "));
                    a.BorrarAB(xe);
                    break;
                case 8 :
                    a.Tamaño();
                    break;
                 case 9:

                    break;
                case 10:

                    break;
                case 11:
                    lc.Imprimir();
                    break;
               
                default:
                    JOptionPane.showMessageDialog(null,"Opción Inválida");
                    break;
                }       
        }
        while(!continuar); 
    }
    
}

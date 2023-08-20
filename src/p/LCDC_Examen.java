package p;

import javax.swing.JOptionPane;

public class LCDC_Examen {
    public class Nodo {
        Nodo next ;
        int numEmp;
        String nombre;
        Nodo prev;

        public Nodo(int nEmp, String nom) {
        numEmp=nEmp;
        nombre = nom;
        
        }
    }
    
    public static Nodo nc;
    public static Nodo ant,temp;
    static int tam;
    
    
    public void Insertar(int nE, String nom){
        Nodo ndata= new Nodo(nE, nom);
        if(nc==null){
            nc=new Nodo(0,"");   
            nc.next=nc;
            nc.prev=nc;
            tam=0;
        }
        temp=nc.next;
        ant=nc;
        while((temp!=nc)&&(temp.numEmp< ndata.numEmp)){
            ant=temp;
            temp=temp.next;
        }
        while((temp!=nc)&&(temp.numEmp==ndata.numEmp)){
            ant=temp;
            temp=temp.next;
        }
        ndata.next=temp;
        ndata.prev=ant;
        temp.prev=ndata;
        ant.next=ndata;
        tam++;
            System.out.println("Nodo dado de Alta");
            JOptionPane.showMessageDialog(null,"Nodo dado de Alta");
            return;
    }
    
    public void Imprimir(){
        Nodo temp=nc.next;
        if(temp==nc){
            System.out.println("La LDEC se encuentra vacia");
            JOptionPane.showMessageDialog(null,"La LDEC se encuentra vacia");
            return;
        }
        while(temp!=nc){
            System.out.println("Numero de empleado: "+temp.numEmp+" Nombre del Empleado: "+temp.nombre);
            JOptionPane.showMessageDialog(null,"Numero de empleado: "+temp.numEmp+" Nombre del Empleado: "+temp.nombre);
            temp=temp.next;
        }
    }

    
    
}

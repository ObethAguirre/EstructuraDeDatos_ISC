package p;
import javax.swing.JOptionPane;

public class Arbol_Binario {
    public class NodoA{
        NodoA hijoI, hijoD;
        int numEmp;
        String nombre;
        
        public NodoA (int nEmp, String nom){
            numEmp=nEmp;
            nombre=nom;
            this.hijoI = null;
            this.hijoD = null;
        }
    }
    
    public NodoA raiz= null;
    static int tamaño = 0;
    
    public void Insertar(int nEmp, String nom){
          
        NodoA nNodo = new NodoA(nEmp,nom);
        if(raiz==null){
          raiz=nNodo;
        }
        else{
            NodoA aux=raiz;
            NodoA padre;
            while(true){
                padre=aux;
                if(nEmp<aux.numEmp){
                    aux=aux.hijoI;
                    if(aux==null){
                        padre.hijoI=nNodo;
                         return;
                    }
                }
                else{
                    aux=aux.hijoD;
                    if(aux==null){
                        padre.hijoD=nNodo;
                        return;
                    }
                }
            }   
        }
        
        tamaño++;
      
    }
    
    public void inOrder(NodoA a){
        if(a!=null){
        inOrder(a.hijoI);
            if (a.numEmp!=0)
                   System.out.println(a.numEmp);
                   System.out.println(a.nombre);
           inOrder(a.hijoD);
        }
    }
    
     public void Preorden(NodoA a){
        if(a!=null){
            if (a.numEmp!=0)
                System.out.println(a.numEmp);
                System.out.println(a.nombre);
                Preorden(a.hijoI);
                Preorden(a.hijoD);}
    }
     
    public void Postorder(NodoA a){
        if(a!=null){
            Postorder(a.hijoI);
            Postorder(a.hijoD);
            if(a.numEmp!=0)
                System.out.println(a.numEmp);
                System.out.println(a.nombre);
        }
    }
    
    public void BorrarAB(int nE){
        NodoA aux=raiz;
        while((aux!=null)&&(aux.numEmp!=nE)){
            if(nE<aux.numEmp){
            aux=aux.hijoI;
            }
            else{
            aux=aux.hijoD;
            }
            if(aux==null){
             JOptionPane.showMessageDialog(null, "No existe el empleado en el Nodo (Arbol Binario)");
             return;
            }
        }
         JOptionPane.showMessageDialog(null,"Se elimino correctamente el empleado del Nodo(Arbol Binario): "+ nE);
         tamaño--;
    }
    
    public  void Tamaño(){
        if(tamaño==0){
            JOptionPane.showMessageDialog(null,"El Arbol Binario se encuentra vacia ");
            System.out.println("El Arbol Binario se encuentra vacia");
        }
        else
            JOptionPane.showMessageDialog(null,"El tamaño de el Arbol Binario es: "+ tamaño);
        System.out.println("El tamaño de el Arbol Binario es:\n"+tamaño);
    }
    
    
    
}

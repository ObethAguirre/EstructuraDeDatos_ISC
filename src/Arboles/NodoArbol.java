package Arboles;

public class NodoArbol {
    NodoArbol izq;
    NodoArbol der;
    char estatus;
    int matricula;
    String nombre;

    public NodoArbol(int matricula, String nombre){
        this.matricula=matricula;
        this.nombre=nombre;
        this.izq=null;
        this.der=null;
        this.estatus='A';
    }
}

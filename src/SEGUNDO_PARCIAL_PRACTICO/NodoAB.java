package SEGUNDO_PARCIAL_PRACTICO;

public class NodoAB {
    int numart;
    String nomart;
    int existencia;
    char estatus;
    NodoAB izq;
    NodoAB der;

    public NodoAB(int numart, String nomart, int existencia) {
        this.numart = numart;
        this.nomart = nomart;
        this.existencia = existencia;
        this.izq = null;
        this.der = null;
        this.estatus ='A';
    }
}
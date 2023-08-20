package ESTUDIO_FOR_ORDI;

public class Nodo {
    int numemp;
    String nombre;
    int depto;
    float sueldo;

    Nodo next;

    public Nodo(int numemp, String nombre, int depto, float sueldo){
        this.numemp=numemp;
        this.nombre=nombre;
        this.depto=depto;
        this.sueldo=sueldo;
        this.next=null;
    }

    public int obtenerNUMEMP(){
        return numemp;
    }

    public void enlazarSiguienteNodo(Nodo n){
        next = n;
    }

    public Nodo obtenerSiguienteNodo(){
        return next;
    }
}

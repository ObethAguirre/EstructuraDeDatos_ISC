package LISTAS_SIMPLES;

public class NodoEmpleados {
    int numemp;
    String nombre;
    int depto;
    float sueldo;
NodoEmpleados next;
    public NodoEmpleados(int numemp, String nombre, int depto, float sueldo){
        this.numemp = numemp;
        this.nombre = nombre;
        this.depto = depto;
        this.sueldo = sueldo;
    }
}

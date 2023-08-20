package LISTAS_SIMPLES;

public class NodoPractica {
    NodoPractica next;
    NodoPractica prev;
    int id;
    String nombre;
    float precio;
    int inventario;

    public NodoPractica(int id, String nombre, float precio, int inventario){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
        this.next = null;
        this.prev = null;
    }
}

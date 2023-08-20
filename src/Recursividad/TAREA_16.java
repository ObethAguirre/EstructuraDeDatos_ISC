package Recursividad;
import javax.swing.*;
import java.util.Stack;

/*
Desarrollar un programa en JAVA que simule el juego de TORRES DE HANOI, utilizando tres clases stack,
con valores numéricos enteros mínimo del 1 al 5, efectuar con las reglas siguientes:
	1. Sólo se puede mover un valor por stack a la vez.
	2. Sólo se puede mover el elemento del tope (peek()).
	3. Un valor numérico mayor no puede estar encime de un valor numérico menor.
	4. Al cargar las clase stack deben quedar los valores mayores primero y en el tope los valores menores.
	5. Imprimir las clases stack movimiento por movimiento


 */
public class TAREA_16 {
    static Stack<Integer> h1 = new Stack<>();
    static Stack<Integer> h2 = new Stack<>();
    static Stack<Integer> h3 = new Stack<>();

    public TAREA_16() {
        h1.push(5);
        h1.push(4);
        h1.push(3);
        h1.push(2);
        h1.push(1);
    }

    public void mostrarPilas() {
        JOptionPane.showMessageDialog(null, " HANOI 1 : " + h1 + "\n HANOI 2 : " + h2 + "\n HANOI 3 : " + h3);
    }

    public void moverDisco(Stack<Integer> h1,Stack<Integer> h3) {
        int disco = h1.pop();
        h3.push(disco);
        mostrarPilas();

    }

    public void resolver(int numDiscos, Stack<Integer> h1, Stack<Integer> h2, Stack<Integer> h3) {
        if (numDiscos > 0) {
            resolver(numDiscos - 1, h1, h3, h2);
            moverDisco(h1, h3);
            resolver(numDiscos - 1, h2, h1, h3);
        }

    }

    public static void main(String[] args) {
        TAREA_16 t = new TAREA_16();
        t.mostrarPilas();
        t.resolver(5,h1,h2,h3);
    }
}

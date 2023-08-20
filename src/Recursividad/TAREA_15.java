package Recursividad;
import javax.swing.*;
public class TAREA_15 {

    //SIN RECURSIVIDAD
    public static long FactorialSinRecursividad(long x) {
        if (x <= 0)
            return 1;
        long factorial = 1;
        while (x > 1) {
            factorial = factorial * x;
            x--;
        }
        return factorial;
    }

    public int FibonacciSinRecursividad(int n){
        int f=0,prim=1,seg=0;
        while(n>0){
            f = prim + seg;
            prim = seg;
            seg = f;
            n--;
        }
        return f;
    }

    //CON RECURSIVIDAD
    public static long FactorialConRecursividad(long x){
            if (x <= 1)
                return 1;
            return x * FactorialConRecursividad(x - 1);
    }

    public int FibonacciConRecursividad(int n){
        if(n==1 || n==2){
            return 1;
        }else{
            return FibonacciConRecursividad(n-1) + FibonacciConRecursividad(n-2);
        }
    }


    public static void main(String[] args) {
        TAREA_15 f = new TAREA_15();
        int opcion,numero;
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1.- Factorial Con Recursividad\n"+
                    "2.- Factorial Sin Recursividad\n"+"3.- Fibonacci Con Recursividad\n"+"4.- Fibonacci Sin Recursivdad\n"+"5.- Salir\n"+"ENTER OPCION","RECURSIVIDAD",JOptionPane.QUESTION_MESSAGE));
            switch (opcion){
                case 1:
                    numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa un número : ", "Calcular Factorial Con Recursividad",JOptionPane.QUESTION_MESSAGE));
                    JOptionPane.showMessageDialog(null,"Resultado : "+f.FactorialConRecursividad(numero));break;
                case 2:
                    numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa un número : ", "Calcular Factorial Sin Recursividad",JOptionPane.QUESTION_MESSAGE));
                    JOptionPane.showMessageDialog(null,"Resultado : "+f.FactorialSinRecursividad(numero));break;
                case 3:
                    numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa un número : ", "Calcular Fibonacci Con Recursividad",JOptionPane.QUESTION_MESSAGE));
                    JOptionPane.showMessageDialog(null, "Resultado : "+f.FibonacciConRecursividad(numero));break;
                case 4:
                    numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa un número : ", "Calcular Fibonacci Sin Recursividad",JOptionPane.QUESTION_MESSAGE));
                    JOptionPane.showMessageDialog(null,"Resultado : "+f.FibonacciSinRecursividad(numero));break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Fin del programa", "FIN", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida", "INVALIDO", JOptionPane.WARNING_MESSAGE);
            }
        }while (opcion !=5);


    }
}

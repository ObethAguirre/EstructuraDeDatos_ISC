package Arreglos;
import java.util.Scanner;
import java.lang.Math;
public class TAREA_2 {


    /*
    OBETH RIGOBERTO AGUIRRE GARCIA 21291509

    Desarrollar un programa en JAVA que defina tres objetos de arreglos bidimensionales de tipo INT,
    de M renglones y N columnas (todos de la misma dimensiÃ³n), debe contener los siguientes mÃ©todos :

        â€¢ Leer/cargos valores para dos arreglos bidimensionales (A y B), cada uno con sus propios valores.
        â€¢ Realizar la SUMA de los dos arreglos Bidimensionales A y B y depositar el resultado en el arreglo C. Imprimir los tres arreglos.
        â€¢ Realizar la RESTA de los dos arreglos Bidimensionales A y B y depositar el resultado en el arreglo C. Imprimir los tres arreglos.
        â€¢ Realizar la MULTIPLICACION de los dos arreglos Bidimensionales A y B y depositar el resultado en el arreglo C. Imprimir los tres arreglos.
        â€¢ Obtener el promedio de cada renglÃ³n del arreglo A. Imprimir el arreglo incluyendo el promedio.
        â€¢ Obtener el promedio de cada renglÃ³n del arreglo B. Imprimir el arreglo incluyendo el promedio.
        â€¢ Clonar el arreglo A al arreglo C. iMPRIMIR AMBOS ARREGLOS.
     */


        private int a[][], b[][], c[][], tamaño;
        public Scanner s = new Scanner(System.in);

        public TAREA_2(int tamaño) {
            this.tamaño = tamaño;
            a = new int[tamaño][tamaño];
            b = new int[tamaño][tamaño];
            c = new int[tamaño][tamaño];

        }

        public void LlenarAyB() {
            //LLENAR ARREGLOS
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    a[i][j] = (int) (Math.random() * 10);
                    b[i][j] = (int) (Math.random() * 10);
                }
            }
        }

        public void MostrarAyB() {
            System.out.println("\nArreglo A");
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    System.out.print(" [ " + a[i][j] + " ] ");
                }
                System.out.println("");
            }

            System.out.println("\nArreglo B");
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    System.out.print(" [ " + b[i][j] + " ] ");
                }
                System.out.println("");
            }
        }

        public void Suma() {
            System.out.println("\nMostrar la suma de los arreglos A y B, guardarlos en arreglo C :");
            //SUMA
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    c[i][j] = a[i][j] + b[i][j];
                }
            }
            //MOSTRAR
            for (int i = 0; i < a.length; i++) {

                for (int j = 0; j < a.length; j++) {
                    System.out.print("[ " + a[i][j] + " ]");
                }

                if (i == 1) {
                    System.out.print("     +     ");
                } else {
                    System.out.print("           ");
                }

                for (int j = 0; j < b.length; j++) {
                    System.out.print("[ " + b[i][j] + " ]");
                }

                if (i == 1) {
                    System.out.print("    =    ");
                } else {
                    System.out.print("         ");
                }

                for (int j = 0; j < c.length; j++) {
                    System.out.print("[ " + c[i][j] + " ]");
                }
                System.out.println("");
            }
        }

        public void Resta() {
            System.out.println("\nMostrar la resta de los arreglos A y B, guardarlos en arreglo C :");
            //RESTA
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    c[i][j] = a[i][j] - b[i][j];
                }
            }
            //MOSTRAR
            for (int i = 0; i < a.length; i++) {

                for (int j = 0; j < a.length; j++) {
                    System.out.print("[ " + a[i][j] + " ]");
                }

                if (i == 1) {
                    System.out.print("     -     ");
                } else {
                    System.out.print("           ");
                }

                for (int j = 0; j < b.length; j++) {
                    System.out.print("[ " + b[i][j] + " ]");
                }

                if (i == 1) {
                    System.out.print("    =    ");
                } else {
                    System.out.print("         ");
                }

                for (int j = 0; j < c.length; j++) {
                    System.out.print("[ " + c[i][j] + " ]");
                }
                System.out.println("");
            }
        }

        public void Multiplicion() {
            System.out.println("\nMostrar la multiplicaciÃ³n de los arreglos A y B, guardarlos en arreglo C :");
            //MULTIPLICACION
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    c[i][j] = a[i][j] * b[i][j];
                }
            }
            //MOSTRAR
            for (int i = 0; i < a.length; i++) {

                for (int j = 0; j < a.length; j++) {
                    System.out.print("[ " + a[i][j] + " ]");
                }

                if (i == 1) {
                    System.out.print("     *     ");
                } else {
                    System.out.print("           ");
                }

                for (int j = 0; j < b.length; j++) {
                    System.out.print("[ " + b[i][j] + " ]");
                }

                if (i == 1) {
                    System.out.print("    =    ");
                } else {
                    System.out.print("         ");
                }

                for (int j = 0; j < c.length; j++) {
                    System.out.print("[ " + c[i][j] + " ]");
                }
                System.out.println("");
            }
        }

        public void promedioA() {
            System.out.println("\nPromedios de arreglo A");
            double suma = 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    System.out.print(" [" + a[i][j] + "] ");
                    suma += a[i][j];
                }
                System.out.println("- Promedio : [" + (suma / tamaño) + "]");
                suma = 0;
            }
        }

        public void promedioB() {
            System.out.println("\nPromedios de arreglo B");
            double suma = 0;
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    System.out.print(" [" + b[i][j] + "] ");
                    suma += b[i][j];

                }
                System.out.println("- Promedio : [" + (suma / tamaño) + "]");
                suma = 0;
            }
        }

        public void clonarA() {
            System.out.println("\nClonar arreglo A en un nuevo arreglo C");
            c = a.clone();

            //imprimir A
            System.out.println("Arreglo A : ");
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    System.out.print(" [" + a[i][j] + "] ");
                }
                System.out.println("");
            }

            //imprimir C
            System.out.println("\nArreglo C : ");
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c.length; j++) {
                    System.out.print(" [" + c[i][j] + "] ");
                }
                System.out.println("");
            }
        }

    }



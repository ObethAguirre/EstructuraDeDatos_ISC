package Arreglos;
import java.util.Arrays;
import java.util.Scanner;
public class TAREA_1 {
        private int array[], tamaño;

        //CONSTRUCTOR
        public TAREA_1(int tamaño) {
            this.tamaño = tamaño;
            array = new int[tamaño];
        }

        public void Llenar() {
            Scanner s = new Scanner(System.in);
            System.out.println("Teclea un valor entero para i : ");
            for (int i = 0; i < tamaño;
            i++){
                System.out.print((i + 1) + ".-   Inserte numero: ");
                array[i] = s.nextInt();
            }
            System.out.println("\n");
        }

        public void Leer() {
            System.out.print("\nNÃºmeros Guardados en el Arreglo : ");
            for (int i = 0; i < tamaño;
            i++){
                System.out.print("[" + array[i] + "]");
            }
            System.out.println("\n");
        }

        public void OrdenarMenorMayor() {
            Arrays.sort(array);
            System.out.print("\nOrdenar Mayor a Menor :");
            for (int i = 0; i < tamaño;
            i++){
                System.out.print("[" + array[i] + "]");
            }
            System.out.println("\n");
        }

        public void Promedio() {
            int prom = 0;
            for (int i = 0; i < tamaño;
            i++){
                prom += array[i];
            }
            System.out.println("Promedio :" + (prom / array.length) + "\n");
        }

        public void Moda() {
            int mayor = 0;
            int numero = 0;

            for (int i = 0; i < array.length; i++) {
                int contador = 0;
                for (int j = 0; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        contador++;
                    }
                }
                if (contador > mayor) {
                    mayor = contador;
                    numero = array[i];
                }
            }
            System.out.println("Moda : [" + numero + "]\n");
        }

        public void Mediana() {
            int[] clon = array.clone();
            Arrays.sort(clon);
            int mitad = (int) clon.length / 2;
            int mediana = clon[mitad];
            System.out.println("Mediana : [" + mediana + "]\n");
        }

        public void posicionCero() {
            System.out.println("PosiciÃ³n cero :[" + array[0] + "]\n");
        }

        public void posicionN() {
            Scanner s = new Scanner(System.in);
            System.out.print("Ingrese una posicion (int) hasta el " + (tamaño - 1));
            int nPosicion = s.nextInt();
            System.out.print("Numero de la posicion " + nPosicion + " : [" + array[nPosicion] + "]\n");
        }

        public void valorMaximo() {
            int mayor = 0;
            for (int i = 0; i < tamaño;
            i++){
                if (array[i] > mayor) {
                    mayor = array[i];
                }
            }
            System.out.println("Obtener NÃºmero Mayor guardado en el arreglo : " + "[" + mayor + "]\n");
        }

        public void valorMinimo() {
            int menor = array[0];
            for (int i = 0; i < tamaño;
            i++){
                if (array[i] < menor) {
                    menor = array[i];
                }
            }
            System.out.println("Obtener NÃºmero Menor guardado en el arreglo : " + "[" + menor + "]\n");
        }
    }



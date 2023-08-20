package Arreglos;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class testTAREA_2 {




        static Scanner s = new Scanner(System.in);

        public static void main(String[] args) {
            JOptionPane.showMessageDialog(null,"Se mostrara un programa para ver el comportamiento de un arreglo");
            System.out.print("Ingrese el tamaÃ±o del arreglo : ");
            int tamaño = s.nextInt();
            TAREA_1 a = new TAREA_1(tamaño);

            System.out.print("Menu Opciones \n"+
                    "1.- Llenar\n"+"2.- Leer\n"+"3.- Ordenar de Menor a Mayor\n"+"4.- Promedio \n"+
                    "5.- Moda \n"+"6.- Mediana\n"+"7.- Posicion Cero\n"+"8.- Posicion N\n"+"9.- Valor Maximo\n" +
                    "10.- Valor Minimo\n"+"11.- Fin de programa\n"+ "Enter Opcion = ");

            int opcion;
            do{
                opcion =s.nextInt();
                switch (opcion) {
                    case 1 :a.Llenar();break;
                    case 2 :a.Leer();break;
                    case 3 :a.OrdenarMenorMayor();break;
                    case 4 :a.Promedio();break;
                    case 5 :a.Moda();break;
                    case 6 :a.Mediana();break;
                    case 7 :a.posicionCero();break;
                    case 8 :a.posicionN();break;
                    case 9 :a.valorMaximo();break;
                    case 10 :a.valorMinimo();break;
                    case 11:System.out.print("Fin de Programa");break;
                    default: JOptionPane.showMessageDialog(null, "Opcion Invalida");
                }
            }while(opcion!=11);
        }

    }


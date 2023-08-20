package LISTAS_SIMPLES;

import javax.swing.*;
/*
tamaño --LISTO
Imprimir desde primero --LISTO
Imprmir desde ultimo --LISTO
Insertar --LISTO
 */
public class PRACTICA {

    NodoPractica primero;
    NodoPractica ultimo;
    int tam = 0;

    public PRACTICA() {
        primero = null;
        ultimo = null;
    }

    public boolean vacio() {
        if (primero == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertarArticulo(int id, String nombre, float precio, int inventario) {
        NodoPractica nuevo = new NodoPractica(id, nombre, precio, inventario);

        if (primero == null) {
            primero = nuevo;
            primero.next = null;
            primero.prev = null;
            ultimo = primero;
            tam++;
        } else {
            ultimo.next = nuevo;
            nuevo.prev = ultimo;
            nuevo.next = null;
            ultimo = nuevo;
            tam++;
        }
    }

    public void mostrarListaDesdeInicio() {
        NodoPractica temp;
        temp = primero;
        String cola = "";

        while (temp != null) {
            cola += "-------------------------------" + "\nID : " + temp.id + "\nNombre del Articulo : " + temp.nombre +
                    "\nPrecio : " + temp.precio + "\nInventtario : " + temp.inventario + "\n -------------------------------";
            temp = temp.next;
        }

        JOptionPane.showMessageDialog(null, "NODOS : \n" + cola, "Mostrar Nodos", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarListaDesdeFinal() {
        NodoPractica temp;
        temp = ultimo;
        String cola = "";

        while (temp != null) {
            cola += "-------------------------------" + "\nID : " + temp.id + "\nNombre del Articulo : " + temp.nombre +
                    "\nPrecio : " + temp.precio + "\nInventtario : " + temp.inventario + "\n -------------------------------";
            temp = temp.prev;
        }

        JOptionPane.showMessageDialog(null, "NODOS : \n" + cola, "Mostrar Nodos", JOptionPane.INFORMATION_MESSAGE);
    }

    public void tamano() {
        JOptionPane.showMessageDialog(null, "Tamaño de la lista : " + tam, "Tamaño", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean eliminarID(int dat) {
        NodoPractica actual=primero;
        NodoPractica anterior;
        NodoPractica siguiente;
        for(int i=0;i<=dat;i++) {
            if(actual==ultimo) {

                if(i<dat) return false;

                else {
                    if(i==dat)
                    {
                        anterior=actual.prev;
                        anterior.next=primero;
                        primero.prev=anterior;
                        ultimo=anterior;
                        return true;
                    }

                }

            }
            else
            {
                if(dat==0)
                {
                    siguiente=actual.next;
                    siguiente.prev=ultimo;
                    ultimo.next=siguiente;
                    primero=siguiente;
                    return true;
                }
                if(dat==i)
                {
                    anterior=actual.prev;
                    siguiente=actual.next;
                    anterior.next=siguiente;
                    siguiente.prev=anterior;
                    return true;
                }
            }
            actual=actual.next;
        } return false;
    }
    }



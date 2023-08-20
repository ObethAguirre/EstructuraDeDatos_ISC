package ESTUDIO_FOR_ORDI;

public class Lista_Enlazada {

    Nodo first;

    public Lista_Enlazada(){
        first=null;
    }

    public boolean estaVacia(){
        return (first == null)?true:false;
    }

    public void añadirEnOrden(int numemp, String nombre, int depto, float sueldo){
        Nodo nuevo_nodo = new Nodo(numemp,nombre,depto,sueldo);


        if (first==null){
            //SI ESTA VACIA CREAMOS UN NODO
            first = nuevo_nodo;
            // SI NO ESTA VACIA INSERTAMOS EL NODO CONDICIONANDO SI NUMERO DEPTO ES MENOR QUE EL QUE ESTA YA EN LA LISTA
            //ORDEN : MENOR A MAYOR
        }else if (depto < first.depto || (depto == first.depto && depto < first.depto)){
            nuevo_nodo.next=first;
        }else{
            Nodo anterior = null;
            Nodo auxiliar = first;

            while ( auxiliar != null && auxiliar.depto < depto ){
                anterior = auxiliar;
                auxiliar = auxiliar.next;
            }

        }
    }
}

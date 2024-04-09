package impl;

import api.PilaTDA;

/*Estrategia 1: Implementaci´on en donde se guardan los datos en un arreglo y
adem´as se tiene una variable que indica la cantidad de elementos que se tienen
guardados en la pila. Cuando agregamos un nuevo elemento a la pila, el mismo
se guarda en la posici´on indicada por la variable que me indica la cantidad de
elementos. Cuando se tiene que desapilar un elemento de la pila, solo es necesario
decrementar en una unidad la variable que me indica la cantidad de elementos */

public class PilaTF implements PilaTDA{
    int[] a; //arreglo en donde se guarda la informacion
    int indice; //variable entera en donde se guarde la cantidad
    //de elementos que se tienen guardados

    public void InicializarPila(){
        a = new int[100];
        indice = 0;
    }

    public void Apilar(int x){
        a[indice] = x;
        indice++;
    }

    public void Desapilar(){
        indice--;
    }

    public boolean PilaVacia(){
        return (indice == 0);
    }

    public int Tope(){
        return a[indice -1];
    }

}

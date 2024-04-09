package impl;

import api.ColaPrioridadTDA;

/* Estrategia 1: Consideramos como estructuras dos arreglos, en uno de ellos
tendremos los elementos y en el otro la prioridad de cada uno de esos elementos.
Como veremos se tendr´an que mantener ambos arreglos sincronizados en cuanto
a que para una posici´on dada se tendr´a en un arreglo el valor del elemento y en
el otro la prioridad que le corresponde a ese elemento. Adem´ as, como en todos
los casos que hemos trabajado con arreglos tendremos una variable en donde
llevemos la cantidad de elementos que se tienen. El elemento con mayor prioridad estar´a en la
posici´on anterior a la marcada por indice. */

public class ColaPrioridadDA implements ColaPrioridadTDA {

    int[] elementos;
    int[] prioridades;
    int indice;

    public void InicializarCola(){
        indice = 0;
        elementos = new int[100];
        prioridades = new int[100];
    }

    public void AcolarPrioridad(int x, int prioridad){
        //desplazar a derecha los elementos de la cola mientras
        //estos tengan mayor o igual prioridad que la de x
        int j = indice;
        for ( ; j>0 && prioridades[j-1] >= prioridad; j--){
            elementos[j] = elementos[j-1];
            prioridades[j] = prioridades[j-1];
        }
        elementos[j] = x;
        prioridades[j] = prioridad;
        indice++;
    }

    public void Desacolar(){
        indice--;
    }

    public int Primero(){
        return elementos[indice-1];
    }

    public boolean ColaVacia(){
        return (indice == 0);
    }

    public int Prioridad(){
        return prioridades[indice-1];
    }

}

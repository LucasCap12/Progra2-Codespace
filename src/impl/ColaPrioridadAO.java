package impl;

import api.ColaPrioridadTDA;

/* Estrategia 2: Otra opci´on de implementaci´on de las colas de prioridades es
considerar un arreglo cuyos elementos representan una estructura (por ser en
Java una clase) que contiene el valor y la prioridad asociada a ese valor */

public class ColaPrioridadAO implements ColaPrioridadTDA{

    class Elemento{
        int valor;
        int prioridad;
    }

    Elemento[] elementos;
    int indice;

    public void InicializarCola(){
        indice = 0;
        elementos = new Elemento[100];
    }

    public void AcolarPrioridad( int x, int prioridad){
        int j = indice;
        //desplaza a derecha los elementos de la cola mientras
        //estos tenga mayor o igual prioridad que la de x
        for (; j>0 && elementos[j-1].prioridad >= prioridad; j--){
            elementos[j] = elementos[j-1];
        }
        elementos[j] = new Elemento();
        elementos[j].valor = x;
        elementos[j].prioridad = prioridad;
        indice++;
    }

    public void Desacolar(){
        elementos[indice - 1]= null;
        indice--;
    }

    public int Primero(){
        return elementos[indice-1].valor;
    }

    public boolean ColaVacia(){
        return (indice == 0);
    }

    public int Prioridad(){
        return elementos[indice-1].prioridad;
    }

}

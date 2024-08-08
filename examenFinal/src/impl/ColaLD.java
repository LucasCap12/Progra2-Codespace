package impl;

import api.ColaTDA;

public class ColaLD implements ColaTDA{

    //Primer elemento en la cola
    NodoCursada primero;

    //Ultimo elemento en la cola, ultimo agregado
    NodoCursada ultimo;

    public void InicializarCola(){
        primero = null;
        ultimo = null;
    }

    public void Acolar( int x){
        NodoCursada aux = new NodoCursada();
        aux.info = x;
        aux.sig= null;
        //si la cola no esta vacia
        if (ultimo != null)
            ultimo.sig = aux;
        ultimo = aux;

        //Si la cola estaba vacia
        if(primero == null)
            primero = ultimo;

    }

    public void Desacolar(){
        primero = primero.sig;

        //si la cola queda vacia
        if (primero == null)
            ultimo = null;
    }

    public boolean ColaVacia(){
        return (ultimo == null);
    }

    public int Primero(){
        return primero.info;
    }



}

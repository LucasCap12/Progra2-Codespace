package impl;

import api.ColaTDA;

/*Estrategia 1: Ultimo elemento ingresado a la cola en la posici´on inicial d ´ el
arreglo: Implementaci´on en donde se guardan los datos en un arreglo y adem´as
se tiene una variable que indica la cantidad de elementos que se tienen guardados
en la cola. Cuando agregamos un nuevo elemento a la cola, el mismo se guarda
en la posici´on cero del arreglo, por lo cual se requiere previo a la inserci´on un
corrimiento a derecha de los elementos que se encuentran en la cola. Cuando se
tiene que desacolar un elemento de la cola, solo es necesario decrementar en una
unidad la variable que me indica la cantidad de elementos. */

public class ColaPU implements ColaTDA {
    int [] a;
    int indice;

    public void InicializarCola(){
        a = new int[100];
        indice = 0;
    }

    public void Acolar(int x){
        for (int i = indice-1; i >= 0; i--)
            a[i+1] = a[i];
        a[0] = x;
        indice++;
    }

    public void Desacolar(){
        indice--;
    }

    public boolean ColaVacia(){
        return (indice == 0);
    }

    public int Primero(){
        return a[indice -1];
    }

}

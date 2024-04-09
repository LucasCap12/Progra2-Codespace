package impl;

import api.PilaTDA;

/*Estrategia 2: Otra variante de implementaci´on es utilizar tambi´en un arreglo
para almacenar los datos y tener una variable que indica la cantidad de elementos
que se tienen guardados en la pila, pero cuando agregamos un nuevo elemento a
la pila, en vez de hacerlo en la posici´on se˜nalada por la variable que me indica
la cantidad de elementos, se guarda en la primera posici´on (es decir, la posici´on
0 del arreglo). Esto tiene como desventaja que cuando se agrega un elemento se
debe hacer un corrimiento del resto de los elementos hacia la derecha, y cuando
se desapila un elemento de la pila nuevamente se tiene que hacer un corrimiento
de elementos pero esta vez hacia la izquierda.
Se puede observar que la variante entre esta implementaci´on y la anterior no
esta dada en la estructura utilizada para guardar los elementos sino en el criterio
utilizado para almacenar esa informaci´on. */

public class PilaTI implements PilaTDA{
    int [] a; //arreglo en donde se guarda la información
    int indice; //variable entera en donde se guarda la cantidad
    //de elementos que se tienen guardados

    public void InicializarPila(){
        a = new int [100];
        indice = 0;
    }

    public void Apilar(int x){
        for (int i = indice-1; i >= 0; i--)
            a[i+1] = a[i];
        a[0] = x;
        indice++;
    }

    public void Desapilar(){
        for (int i = 0; i <indice; i++)
            a[i] = a[i+1];
        indice--;
    }

    public boolean PilaVacia(){
        return (indice == 0);
    }

    public int Tope(){
        return a[0];
    }


}

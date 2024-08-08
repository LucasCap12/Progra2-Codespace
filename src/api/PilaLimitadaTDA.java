package api;

/*Queremos un tipo de dato abtracto que denominaremos PilaDinamicaTDA que representa una pila de un tamaño limitado.
 * El limite se especifica en el momento de inicialización. Este TDA debe permitir las siguientes operaciones:
 */

public interface PilaLimitadaTDA {
    void InicializarPila(); 
    /*genera una pila vacia lista para ser usada. la pila tendra el tamaño indicado por por un numero entero positovp como parametro*/
    void Apilar(int x);
    /*agrega un entero pasado a la pila. Si el tamaño maximo se excede, se produce un corrimineto, de manera que el elemento más antiguo de la pila (el fondo) se elimina.
    por ejemplo, si tenemos una pila inicialmente vacía con capacidad máxima 3 y apilamos 1,2,3 y 4 en ese orden, la pila contrendá sucesivamente( siempre el tope hacia la izquierda):
    [1],[2,1],[3,2,1],[4,3,2]*/
    void Desapilar();
    /*funciona como en las pilas normales */
    boolean PilaVacia();
    /*funciona como en las pilas normales */
    int Tope();
    /*funciona como en las pilas normales */

}

/* Se pide:
 * 1. Defina la interfaz de este TDA y las precondiciones correspondientes.
 * 2. Implemente la interfaz anterior de forma estática.
 * 3. Implemente la interfaz anterior de forma dinámica.
 * 4. Pruebe sus implmentaciones con un conjunto de datos.
 * 5. Indique en ambas implementaciones cual es el costo de cada metodo
 */

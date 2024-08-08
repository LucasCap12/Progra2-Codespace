package api;

public interface PilaLimitadaTDA {
    // Inicializa la pila con un tamaño máximo dado.
    void InicializarPila(int maxTam);

    // Agrega un entero a la pila. Si la pila está llena, elimina el elemento más antiguo.
    void Apilar(int x);

    // Elimina el elemento en la parte superior de la pila.
    void Desapilar();

    // Devuelve true si la pila está vacía.
    boolean PilaVacia();

    // Devuelve el elemento en la parte superior de la pila.
    int Tope();
}

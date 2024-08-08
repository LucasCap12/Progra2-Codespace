package api;

public interface ABBTDA {
    
    // siempre que el arbol este inicializado y no este vacio
    int Raiz();
    // siempre que el arbol este inicializado y no este vacio
    ABBTDA HijoIzq();
    // siempre que el arbol este inicializado y no este vacio
    ABBTDA HijoDer();
    // siempre que el arbol este inicializado
    boolean ArbolVacio();
    void InicializarArbol();
    // siempre que el arbol este inicializado
    void AgregarElemento(int x);
    // siempre que el arbol este inicializado
    void EliminarElemento(int x);

}

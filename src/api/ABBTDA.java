package api;
//Los ´arboles binarios de b´usqueda (ABB)
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
    void AgregarElem(int x);
    // siempre que el arbol este inicializado
    void EliminarElem(int x);

}

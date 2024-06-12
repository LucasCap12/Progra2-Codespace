//interaz
package api;

public interface ArbolAVL {
    
    void InicializarArbol();
    void Insertar(int x);
    void Eliminar(int x);
    int Raiz();
    ArbolAVL HijoIzq();
    ArbolAVL HijoDer();
    boolean ArbolVacio();

}

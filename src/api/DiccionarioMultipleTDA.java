package api;

public interface DiccionarioMultipleTDA {
    void InicializarDiccionario();
    //siempre que el diccionario este inicializado
    void Agregar(int clave, int valor);
    //siempre que el diccionario este inicializado
    void Eliminar(int clave);
    //siempre que el diccionario este inicializado
    void EliminarValor(int clave, int valor);
    //siempre que el diccionario este inicializado
    ConjuntoTDA Recuperar(int clave);
    //siempre que el diccionario este inicializado
    ConjuntoTDA Claves();

}

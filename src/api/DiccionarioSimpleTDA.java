package api;

public interface DiccionarioSimpleTDA {
    //siempre que el diccionario esté inicializado
    void InicializarDiccionario();
    //siempre que el diccionario este inicializado
    void Agregar(int clave, int valor);
    //siempre que el diccionario este inicializado
    void Eliminar(int clave);
    //siempre que el diccionario esté inicializado
    // y la clave exista en el mismo
    int Recuperar(int clave);
    //siempre que el diccionario este inicializado
    ConjuntoTDA Claves();

}

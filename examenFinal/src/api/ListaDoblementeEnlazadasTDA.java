package api;

public interface ListaDoblementeEnlazadasTDA {
    void Agregar(int num);
    /*1. Definir un metodo Agregar que reciba un valor entero num y lo agregue
     a la listadoblemente enlazada, posiblemente vacia. Por supuesto. */
    void Eliminar(int num);
    /*2. Definir un metodo Eliminar que reciba un valor entero num y elimine
     la primera ocurrencia de num en la lista doblemente enlazada. */
    void EliminarTodos(int num);
    /* 3. Definir metodo EliminarTodos al que le pasemos un valor entero num y elimine todas
     sus ocurrencias. Por supuesto, la lista debe seguir siendo una lista doblemente enlazada. */
    void MostrarCabezaCola();
    void MostrarColaCabeza();
    /*4. Definir un metodo MostrarCabezaCola y MostrarColaCabeza. Estos metodos
     deberan imprimir por pantalla la lista en el sentido que dice el nombre del metodo. */

    /*5.Calcule el costo de los metodos de los puntos anteriores*/ 

}

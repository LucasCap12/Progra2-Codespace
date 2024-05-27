package EjercicioSimulacro.api;

public interface PilaColaParesTDA {
    void inicializar();
    void guardar(int x);
    void sacar(); //desacolo o desapila
    int mostrar(); //como tope o primero
    boolean estaVacia();
    void imprimir();

}
/* cola que al pasar los 10 numeros pares pase a ser pila y al revez */
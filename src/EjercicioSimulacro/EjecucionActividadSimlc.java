package EjercicioSimulacro;

import EjercicioSimulacro.impl.ListaPromediada;
import EjercicioSimulacro.api.ColaTDA;

public class EjecucionActividadSimlc {
    public static void main(String[] args) {
        ListaPromediada lista = new ListaPromediada();
        
        // Inicializamos la lista
        lista.inicializar();

        // Agregamos valores a la lista
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(5);
        lista.agregar(30);
        lista.agregar(15);

        // Mostramos el promedio
        System.out.println("Promedio actual: " + lista.promedio());

        // Agregamos un valor igual al promedio (no debería agregarse)
        lista.agregar(16); // Asumiendo que el promedio actual es 16, este valor no se agrega

        // Eliminamos un valor (elimina todas las ocurrencias)
        lista.eliminar(20);

        // Mostramos los elementos menores al promedio
        ColaTDA menores = lista.menores();
        System.out.print("Valores menores al promedio: ");
        while (!menores.ColaVacia()) {
            System.out.print(menores.Primero() + " ");
            menores.Desacolar();
        }
        System.out.println();

        // Mostramos los elementos mayores al promedio
        ColaTDA mayores = lista.mayores();
        System.out.print("Valores mayores al promedio: ");
        while (!mayores.ColaVacia()) {
            System.out.print(mayores.Primero() + " ");
            mayores.Desacolar();
        }
        System.out.println();

        // Verificamos si la lista está vacía
        System.out.println("La lista está vacía: " + lista.estaVacia());
    }
}
